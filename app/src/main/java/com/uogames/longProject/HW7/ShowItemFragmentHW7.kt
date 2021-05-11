package com.uogames.longProject.HW7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso
import com.uogames.longProject.HW7.database.entity.Item
import com.uogames.longProject.R
import java.lang.Exception
import java.util.*

class ShowItemFragmentHW7 : Fragment() {

    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModelHW7::class.java) }
    private val databaseModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(DatabaseViewModelHW7::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_item_hw7, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<ImageView>(R.id.hw7_image_view)
        val tvNameItem = view.findViewById<TextView>(R.id.hw7_name_item)
        val tvCurrentPay = view.findViewById<TextView>(R.id.hw7_current_pay)
        val tvDateOpen = view.findViewById<TextView>(R.id.hw7_date_open)
        val tvCurrentParticipant = view.findViewById<TextView>(R.id.hw7_current_participant)
        val tvDescription = view.findViewById<TextView>(R.id.hw7_description)
        val tilMyPay = view.findViewById<TextInputLayout>(R.id.hw7_my_pay)
        val tilMyName = view.findViewById<TextInputLayout>(R.id.hw7_my_name)
        val bPay = view.findViewById<Button>(R.id.hw7_pay)

        val id = arguments?.getInt(MainViewModelHW7.ITEM_ID) ?: 0

        databaseModel.itemList.observe(requireActivity()) {
            if (it.size != 1) return@observe
            val item = it[0]
            Picasso.get().load(item.image).into(imageView)
            tvNameItem.text = item.name
            tvCurrentPay.text = String.format("%.2f", item.getCurrentPay().toString().toDouble())
            tvDateOpen.text = Date().also { it -> it.time = item.dateOpen ?: 0 }.toString()
            tvCurrentParticipant.text = item.currentParticipant
            tvDescription.text = item.description

            bPay.setOnClickListener {
                checkEmpty(tilMyName)
                checkNumber(tilMyPay)
                if (tilMyPay.error.isNullOrEmpty()) checkPay(tilMyPay, item.getCurrentPay() ?: 0.0)
                if (tilMyName.error.isNullOrEmpty() &&
                    tilMyPay.error.isNullOrEmpty()
                ) {
                    item.setBet(
                        tilMyName.editText?.text.toString(),
                        tilMyPay.editText?.text.toString().toDouble()
                    )
                    databaseModel.update(item)
                    findNavController().popBackStack()
                }
            }
        }

        databaseModel.fiendItemById(id)


    }

    private fun checkEmpty(input: TextInputLayout) {
        input.error = null
        if (input.editText?.text.isNullOrEmpty()) {
            input.error = getString(R.string.error_empty)
        }
    }

    private fun checkNumber(input: TextInputLayout) {
        input.error = null
        try {
            String.format("%.2f", input.editText?.text.toString().toDouble())
        } catch (e: Exception) {
            input.error = getString(R.string.error_not_number)
        }
    }

    private fun checkPay(input: TextInputLayout, cPay: Double) {
        input.error = null
        val inputDouble = input.editText?.text.toString().toDouble()
        println(String().format("%.2f", inputDouble))
        println(inputDouble)
        val castC = String.format("%.2f", input.editText?.text.toString().toDouble()).toDouble()
        val castN = String.format("%.2f", cPay).toDouble()
        println("$castC \t $castN")
        if (castC <= castN) {
            input.error = getString(R.string.error_should_be_more_than) + "$castN"
        }
    }

}