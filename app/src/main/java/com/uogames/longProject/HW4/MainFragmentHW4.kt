package com.uogames.longProject.HW4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.uogames.longProject.R

class MainFragmentHW4 : Fragment() {

    private val addSnowdropListeners = ArrayList<(View?) -> Unit>()
    private val watchSnowdropsListeners = ArrayList<(View?) -> Unit>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_hw4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addSnowdrop = view.findViewById<Button>(R.id.hw4_add_snowdrop)
        val watchSnowdrops = view.findViewById<Button>(R.id.hw4_watch_collection)

        addSnowdrop.setOnClickListener { addSnowdropListeners.forEach { e -> e(it) } }
        watchSnowdrops.setOnClickListener { watchSnowdropsListeners.forEach { e -> e(it) } }
    }

    fun addSnowdropListener(listener: (View?) -> Unit) {
        addSnowdropListeners.add(listener)
    }

    fun removeSnowdropListener(listener: (View?) -> Unit): Boolean {
        return addSnowdropListeners.remove(listener)
    }

    fun addWatchSnowdropsListener(listener: (View?) -> Unit) {
        watchSnowdropsListeners.add(listener)
    }

    fun removeWatchSnowdropListener(listener: (View?) -> Unit): Boolean {
        return watchSnowdropsListeners.remove(listener)
    }


}