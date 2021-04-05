package com.uogames.lesson17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_click)
        val infoText = findViewById<TextView>(R.id.info_text)
        val inputText = findViewById<EditText>(R.id.input_field)

        button.setOnClickListener {
            val newText = inputText.text.toString()
            infoText.text = newText
            inputText.text.clear()
        }
    }
}