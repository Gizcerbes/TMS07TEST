package com.uogames.longProject.HW5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.uogames.longProject.R

class RegisterDialog :DialogFragment() {

    companion object {
        val TAG = "REGISTRATION"
    }

    val viewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_hw5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = view.findViewById<TextView>(R.id.input_text)

        text.text = getString(R.string.registration_successful)

        val applyButton = view.findViewById<Button>(R.id.log_in)

        applyButton.setOnClickListener {
            val intent = Intent(requireActivity(), SecondActivityHW5::class.java)
            intent.putExtra(User.LOGIN, viewModel.selectedUser.first)
            requireActivity().startActivity(intent)
        }

        val okButton = view.findViewById<Button>(R.id.ok)

        okButton.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}

