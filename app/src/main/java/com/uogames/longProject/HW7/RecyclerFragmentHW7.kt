package com.uogames.longProject.HW7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputLayout
import com.uogames.longProject.HW7.adapter.RecyclerAdapterHW7
import com.uogames.longProject.R

class RecyclerFragmentHW7 : Fragment() {

    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModelHW7::class.java) }
    private val databaseModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(DatabaseViewModelHW7::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resycler_hw7, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.hw7_recycler)
        val createButton = view.findViewById<Button>(R.id.hw7_create_item)
        val fiendItem = view.findViewById<TextInputLayout>(R.id.textField_hw7)

        val adapter = RecyclerAdapterHW7(databaseModel, viewModel)
        recycler.adapter = adapter
        databaseModel.getAll()
        databaseModel.itemList.observe(requireActivity()) {
            adapter.notifyDataSetChanged()
        }

        createButton.setOnClickListener { findNavController().navigate(R.id.show_createItemFragmentHW7) }

        fiendItem.editText?.addTextChangedListener {
            if (!it.isNullOrEmpty()) databaseModel.fiendItem(it.toString())
            else databaseModel.getAll()
        }
    }

}