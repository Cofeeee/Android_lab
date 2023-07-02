package com.example.homework1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nameEditText = findViewById<EditText>(R.id.TextName)
        val heightEditText = findViewById<EditText>(R.id.TextHeight)
        val weightEditText = findViewById<EditText>(R.id.TextNumberWeight)
        val ageEditText = findViewById<EditText>(R.id.textNumberAge)
        val answer = findViewById<TextView>(R.id.textView)

        val clickButton = findViewById<Button>(R.id.button)

        clickButton?.setOnClickListener {
            val calculated = calculate(nameEditText, heightEditText, weightEditText, ageEditText)

            if (calculated != -1) {
                answer.text = "Ответ: $calculated"
            } else {
                answer.text = "Данные введены некорректно."
            }
        }
    }

    private fun calculate(nameEditText: EditText,
                          heightEditText: EditText,
                          weightEditText: EditText,
                          ageEditText: EditText) : Int {

        val name = nameEditText.text.toString()
        val height = heightEditText.text.toString().toDoubleOrNull()
        val weight = weightEditText.text.toString().toDoubleOrNull()
        val age = ageEditText.text.toString().toDoubleOrNull()

        if (height != null && weight != null && age != null) {
            if (name.length in 1..50
                && height in 1.0..249.0
                && weight in 1.0..249.0
                && age in 1.0..149.0) return ((height + weight + age) / name.length).toInt()
        }
        return -1
    }
}