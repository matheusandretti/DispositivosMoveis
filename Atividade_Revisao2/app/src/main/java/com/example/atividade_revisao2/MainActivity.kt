package com.example.atividade_revisao2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.atividade_revisao2.R

class MainActivity : AppCompatActivity() {

    var pontosNos = 0
    var pontosEles = 0
    var vitoriasNos = 0
    var vitoriasEles = 0
    val limitePontos = 12 // Pontuação máxima para vencer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMaisNos = findViewById<Button>(R.id.btnMaisNos)
        val btnMenosNos = findViewById<Button>(R.id.btnMenosNos)
        val btnMaisEles = findViewById<Button>(R.id.btnMaisEles)
        val btnMenosEles = findViewById<Button>(R.id.btnMenosEles)
        val btnResetar = findViewById<Button>(R.id.btnResetar)


        // Incrementar pontuação "Nós"
        btnMaisNos.setOnClickListener {
            if (pontosNos < limitePontos) {
                pontosNos++
                atualizarPlacar()
                verificarVencedor()
            }
        }

        // Decrementar pontuação "Nós"
        btnMenosNos.setOnClickListener {
            if (pontosNos > 0) {
                pontosNos--
                atualizarPlacar()
            }
        }

        // Incrementar pontuação "Eles"
        btnMaisEles.setOnClickListener {
            if (pontosEles < limitePontos) {
                pontosEles++
                atualizarPlacar()
                verificarVencedor()
            }
        }

        // Decrementar pontuação "Eles"
        btnMenosEles.setOnClickListener {
            if (pontosEles > 0) {
                pontosEles--
                atualizarPlacar()
            }
        }

        // Reiniciar pontuação
        btnResetar.setOnClickListener {
            mostrarDialogoReset()
        }
    }

    private fun atualizarPlacar() {
        val tvPontosNos = findViewById<TextView>(R.id.tvPontosNos)
        val tvPontosEles = findViewById<TextView>(R.id.tvPontosEles)
        val tvVitoriasNos = findViewById<TextView>(R.id.tvVitoriasNos)
        val tvVitoriasEles = findViewById<TextView>(R.id.tvVitoriasEles)
        tvPontosNos.text = pontosNos.toString()
        tvPontosEles.text = pontosEles.toString()
        tvVitoriasNos.text = "vitórias ($vitoriasNos)"
        tvVitoriasEles.text = "vitórias ($vitoriasEles)"
    }

    private fun verificarVencedor() {
        if (pontosNos >= limitePontos) {
            vitoriasNos++
            mostrarDialogoVencedor("Nós")
        } else if (pontosEles >= limitePontos) {
            vitoriasEles++
            mostrarDialogoVencedor("Eles")
        }
    }

    private fun mostrarDialogoVencedor(vencedor: String) {
        AlertDialog.Builder(this)
            .setTitle("Fim do jogo")
            .setMessage("$vencedor ganhou!")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                resetarPlacar()
            }
            .setCancelable(false)
            .show()
    }

    private fun mostrarDialogoReset() {
        AlertDialog.Builder(this)
            .setTitle("Zerar")
            .setMessage("Tem certeza que deseja começar novamente a pontuação?")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                vitoriasNos = 0
                vitoriasEles = 0
                resetarPlacar()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun resetarPlacar() {
        pontosNos = 0
        pontosEles = 0
        atualizarPlacar()
    }
}
