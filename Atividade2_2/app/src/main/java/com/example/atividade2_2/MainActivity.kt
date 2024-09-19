package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val btnSum = findViewById<Button>(R.id.btnSum)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Função para somar os números
        btnSum.setOnClickListener {
            val number1 = etNumber1.text.toString()
            val number2 = etNumber2.text.toString()

            // Verificar se os campos não estão vazios
            if (number1.isNotEmpty() && number2.isNotEmpty()) {
                val result = number1.toDouble() + number2.toDouble()
                tvResult.text = "Resultado: $result"
            } else {
                tvResult.text = "Por favor, insira ambos os números."
            }
        }

        // Função para subtrair os números
        btnSubtract.setOnClickListener {
            val number1 = etNumber1.text.toString()
            val number2 = etNumber2.text.toString()

            // Verificar se os campos não estão vazios
            if (number1.isNotEmpty() && number2.isNotEmpty()) {
                val result = number1.toDouble() - number2.toDouble()
                tvResult.text = "Resultado: $result"
            } else {
                tvResult.text = "Por favor, insira ambos os números."
            }
        }
    }
}
