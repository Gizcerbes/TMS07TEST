package com.uogames.longProject.HW7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.uogames.longProject.HW7.adapter.RecyclerAdapterHW7
import com.uogames.longProject.R

class RecyclerFragmentHW7 : Fragment() {

    private val viewModel by lazy { ViewModelProvider.AndroidViewModelFactory(requireActivity().application).create(MainViewModelHW7::class.java) }

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

        viewModel.getAll()
        viewModel.itemList.observe(requireActivity()){
            Toast.makeText(view.context, it.size.toString(), Toast.LENGTH_SHORT).show()
        }
        recycler.adapter = RecyclerAdapterHW7(viewModel)
        createButton.setOnClickListener { findNavController().navigate(R.id.show_createItemFragmentHW7) }


    }

}