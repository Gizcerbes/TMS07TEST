package com.uogames.longProject.HW4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.uogames.longProject.R

class AddSnowdropFragmentHW4 : Fragment() {

    private val addSnowdropListeners = ArrayList<(View?, Snowdrop) -> Unit>()
    private val onBackListeners = ArrayList<(View?) -> Unit>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_snowdrop_hw4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputKind = view.findViewById<EditText>(R.id.hw4_input_kind)
        val inputUrl = view.findViewById<EditText>(R.id.hw4_input_url)
        val preloadView = view.findViewById<ImageView>(R.id.hw4_preload_image)
        val inputDescription = view.findViewById<EditText>(R.id.hw4_input_description)
        val addSnowDrop = view.findViewById<Button>(R.id.hw4_add_snowdrop_btn)
        val backBtn = view.findViewById<Button>(R.id.hw4_back_btn)

        addSnowDrop.setOnClickListener {
            if (checkInput(inputKind)) {
                addSnowdropListeners.forEach { e ->
                    e(
                        it,
                        Snowdrop(
                            inputKind.text.toString(),
                            inputUrl.text.toString(),
                            inputDescription.text.toString()
                        )
                    )
                }
            }
        }

        backBtn.setOnClickListener { onBackListeners.forEach { e -> e(it) } }

        inputUrl.addTextChangedListener {
            if (!it.isNullOrEmpty()) {
                Picasso.get().load(it.toString()).error(R.drawable.iconfinder_bullet_error_66701)
                    .into(preloadView)
            }
        }
    }

    fun addSnowdropListener(listener: (View?, Snowdrop) -> Unit) {
        addSnowdropListeners.add(listener)
    }

    fun removeSnowdropListener(listener: (View?, Snowdrop) -> Unit): Boolean {
        return addSnowdropListeners.remove(listener)
    }

    fun addOnBackListener(listener: (View?) -> Unit) {
        onBackListeners.add(listener)
    }

    fun removeOnBackListener(listener: (View?) -> Unit): Boolean {
        return onBackListeners.remove(listener)
    }

    private fun checkInput(kind: EditText): Boolean {
        if (kind.text.isNullOrEmpty()) kind.error = getString(R.string.error_empty)
        return kind.error.isNullOrEmpty()
    }

}