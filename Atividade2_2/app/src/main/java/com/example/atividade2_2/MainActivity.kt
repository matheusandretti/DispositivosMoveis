package com.example.atividade2_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
                    if (isValidInput(number1, number2)) {
                        val result = number1.toDouble() + number2.toDouble()
                        tvResult.text = "Resultado: $result"
                    } else {
                        Toast.makeText(this, "Por favor, insira números válidos.", Toast.LENGTH_SHORT).show()
                    }
                }

                // Função para subtrair os números
                btnSubtract.setOnClickListener {
                    val number1 = etNumber1.text.toString()
                    val number2 = etNumber2.text.toString()

                    // Verificar se os campos não estão vazios
                    if (isValidInput(number1, number2)) {
                        val result = number1.toDouble() - number2.toDouble()
                        tvResult.text = "Resultado: $result"
                    } else {
                        Toast.makeText(this, "Por favor, insira números válidos.", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            // Função para validar a entrada do usuário
            private fun isValidInput(number1: String, number2: String): Boolean {
                return try {
                    number1.toDouble()
                    number2.toDouble()
                    true
                } catch (e: NumberFormatException) {
                    false
                }
            }
        }

