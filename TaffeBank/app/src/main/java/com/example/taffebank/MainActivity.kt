package com.example.taffebank

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tipoTransacao: Spinner = findViewById<Spinner>(R.id.spTipoTransacao)
        val valorTransacao = findViewById<EditText>(R.id.etValor)
        val descricaoTransacao = findViewById<EditText>(R.id.etDescricao)
        val btnLancar = findViewById<Button>(R.id.btnLancar)

        btnLancar.setOnClickListener{

            println("Cliquei no botão")
            println(tipoTransacao.selectedItem.toString())


        }

    }
}