package com.uogames.longProject.HW4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.uogames.longProject.R

class ListSnowdropFragmentHW4 : Fragment() {

    private val snowdrops = ArrayList<Snowdrop>()
    private val onSelectedSnowdropListeners = ArrayList<(View?, Snowdrop) -> Unit>()
    private val onBackListeners = ArrayList<(View?) -> Unit>()
    private var onLoaded = false

    fun addSnowdrop(snowdrop: Snowdrop) {
        snowdrops.add(snowdrop)
    }

    fun removeSnowdrop(snowdrop: Snowdrop): Boolean {
        return snowdrops.remove(snowdrop)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list_snowdrop_hw4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!onLoaded){
            filList()
            onLoaded = true
        }

        val linearList = view.findViewById<LinearLayout>(R.id.hw4_list)
        val backBtn = view.findViewById<Button>(R.id.hw4_back_btn)

        snowdrops.forEach { snowdrop ->
            var params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 16, 0, 16)

            val button = Button(context)
            button.text = snowdrop.kind
            button.setOnClickListener {
                onSelectedSnowdropListeners.forEach { e -> e(it, snowdrop) }
            }
            linearList.addView(button, params)
        }

        backBtn.setOnClickListener { onBackListeners.forEach { e -> e(it) } }
    }

    fun addOnSelectListener(listener: (View?, Snowdrop) -> Unit) {
        onSelectedSnowdropListeners.add(listener)
    }

    fun removeOnSelectListener(listener: (View?, Snowdrop) -> Unit): Boolean {
        return onSelectedSnowdropListeners.remove(listener)
    }

    fun addOnBackListener(listener: (View?) -> Unit) {
        onBackListeners.add(listener)
    }


    fun removeOnBackListener(listener: (View?) -> Unit): Boolean {
        return onBackListeners.remove(listener)
    }

    private fun filList() {
        snowdrops.add(
            Snowdrop(
                getString(R.string.сommon_snowdrop),
                getString(R.string.link_common_snowdrop),
                getString(R.string.info_common_snowdrop)
            )
        )

       snowdrops.add(
            Snowdrop(
                getString(R.string.giant_snowdrop),
                getString(R.string.link_giant_snowdrop),
                getString(R.string.info_giant_snowdrop)
            )
        )

       snowdrops.add(
            Snowdrop(
                getString(R.string.galanthus_plicatus),
                getString(R.string.link_galanthus_plicatus),
                getString(R.string.info_galanthus_plicatus)
            )
        )


    }


}