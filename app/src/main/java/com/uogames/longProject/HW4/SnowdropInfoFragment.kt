package com.uogames.longProject.HW4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.uogames.longProject.R

class SnowdropInfoFragment : Fragment() {
    private var snowdrop: Snowdrop = Snowdrop("unsigned", "unsigned", "unsigned")
    private val onBackListeners = ArrayList<(View?) -> Unit>()

    fun setSnowdrop(snowdrop: Snowdrop) {
        this.snowdrop = snowdrop
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_snowdrop_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kind = view.findViewById<TextView>(R.id.hw4_kind_info)
        val image = view.findViewById<ImageView>(R.id.hw4_image)
        val descriptor = view.findViewById<TextView>(R.id.hw4_description)

        kind.text = snowdrop.kind
        if (!snowdrop.link.isNullOrEmpty())
            Picasso.get().load(snowdrop.link).error(R.drawable.iconfinder_bullet_error_66701)
                .into(image)
        descriptor.text = snowdrop.descriptor

        val backBtn = view.findViewById<Button>(R.id.hw4_back_btn)

        backBtn.setOnClickListener { onBackListeners.forEach { e -> e(it) } }

    }


    fun addOnBackListener(listener: (View?) -> Unit) {
        onBackListeners.add(listener)
    }

    fun removeOnBackListener(listener: (View?) -> Unit): Boolean {
        return onBackListeners.remove(listener)
    }

}