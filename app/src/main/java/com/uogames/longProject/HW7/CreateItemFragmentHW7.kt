package com.uogames.longProject.HW7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputLayout
import com.uogames.longProject.HW7.database.entity.Item
import com.uogames.longProject.R
import java.lang.Exception
import java.util.*

class CreateItemFragmentHW7 : Fragment() {

    private val databaseModel by lazy { ViewModelProvider.AndroidViewModelFactory(requireActivity().application).create(DatabaseViewModelHW7::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val participantInput = view.findViewById<TextInputLayout>(R.id.hw7_participant_input)
        val nameItem = view.findViewById<TextInputLayout>(R.id.hw7_name_item)
        val urlImage = view.findViewById<TextInputLayout>(R.id.hw7_url_image)
        val description = view.findViewById<TextInputLayout>(R.id.hw7_description)
        val startPay = view.findViewById<TextInputLayout>(R.id.hw7_start_pay)
        val createButton = view.findViewById<Button>(R.id.hw7_create_item)

        createButton.setOnClickListener {
            checkEmpty(nameItem)
            checkEmpty(participantInput)
            checkEmpty(urlImage)
            checkEmpty(description)
            checkNumber(startPay)
            if (
                !nameItem.error.isNullOrEmpty() ||
                !participantInput.error.isNullOrEmpty() ||
                !urlImage.error.isNullOrEmpty() ||
                !description.error.isNullOrEmpty() ||
                !startPay.error.isNullOrEmpty()
            ) return@setOnClickListener

            val item = Item(
                nameItem.editText?.text.toString(),
                description.editText?.text.toString(),
                urlImage.editText?.text.toString(),
                Date().time,
                startPay.editText?.text.toString().toDouble(),
                participantInput.editText?.text.toString()
            )
            databaseModel?.insert(item)
            findNavController().popBackStack()
        }
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
            String().format("%0.2f", input.editText?.text.toString().toDouble())
        } catch (e: Exception) {
            input.error = getString(R.string.error_not_number)
        }
    }


}