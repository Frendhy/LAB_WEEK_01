package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        val nameInputField = findViewById<TextInputEditText>(R.id.name_input)
        val studentNumberField = findViewById<TextInputEditText>(R.id.student_number_input)

        nameSubmit.setOnClickListener {
            val nameInput = nameInputField?.text.toString().trim()
            val studentNumber = studentNumberField?.text.toString().trim()

            when {
                nameInput.isEmpty() -> {
                    Toast.makeText(this, getString(R.string.nameEmpty), Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                }
                studentNumber.length != 11 -> {
                    Toast.makeText(this, getString(R.string.student_number_error), Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                }
                else -> {
                    nameDisplay?.text =
                        getString(R.string.name_greet) + " " + nameInput + "\nStudent No: " + studentNumber
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}