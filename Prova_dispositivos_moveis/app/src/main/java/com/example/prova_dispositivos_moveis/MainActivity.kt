package com.example.prova_dispositivos_moveis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unipar.prova_dispositivos_moveis.Viagem
import br.unipar.prova_dispositivos_moveis.ViagemAdapter
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private val listaViagem = mutableListOf<Viagem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edInserirDestino = findViewById<EditText>(R.id.edInserirDestino)
        val edInserirValor = findViewById<EditText>(R.id.edInserirValor)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val listViewTarefas = findViewById<ListView>(R.id.listViewTarefas)
        val txtTotalGasto = findViewById<TextView>(R.id.txtTotalGasto)
        val btnZerar = findViewById<Button>(R.id.btnZerar)

        val adapter = ViagemAdapter(this, listaViagem)
        listViewTarefas.adapter = adapter

        fun updateTotalGasto() {
            val totalGasto = listaViagem.sumOf { it.valor }
            val dec = DecimalFormat("#,###.00")
            txtTotalGasto.text = "Total gasto: R$ ${dec.format(totalGasto)}"
        }

        btnInserir.setOnClickListener {
            val destinoViagem = edInserirDestino.text.toString()
            val valorViagem = edInserirValor.text.toString().toDoubleOrNull()
            val dataAtual = SimpleDateFormat("dd/MM", Locale.getDefault()).format(Date())

            if (destinoViagem.isNotEmpty() && valorViagem != null) {
                val novaViagem = Viagem(destinoViagem, valorViagem, dataAtual)
                listaViagem.add(novaViagem)
                adapter.notifyDataSetChanged()

                Toast.makeText(this, "Destino: $destinoViagem\nValor: R$%.2f".format(valorViagem), Toast.LENGTH_SHORT).show()
                updateTotalGasto()
            } else {
                Toast.makeText(this, "Por favor, insira valores válidos.", Toast.LENGTH_SHORT).show()
            }
        }

        btnZerar.setOnClickListener {
            if (listaViagem.isNotEmpty()) {
                listaViagem.clear()
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Viagens removidas", Toast.LENGTH_SHORT).show()
                updateTotalGasto()
            }
        }
    }
}
