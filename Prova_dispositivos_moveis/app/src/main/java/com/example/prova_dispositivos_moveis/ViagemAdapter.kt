package br.unipar.prova_dispositivos_moveis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.prova_dispositivos_moveis.R
import java.text.DecimalFormat

class ViagemAdapter(private val context: Context,
                    private val listaViagem: MutableList<Viagem>)
    : ArrayAdapter<Viagem>(context, 0, listaViagem) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viagem = listaViagem[position]

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_viagem, parent, false)

        val destino = view.findViewById<TextView>(R.id.txtDestino)
        val valor = view.findViewById<TextView>(R.id.txtValor)
        val data = view.findViewById<TextView>(R.id.txtData)

        destino.text = viagem.destino
        val dec = DecimalFormat("#,###.00")
        valor.text = "R$ ${dec.format(viagem.valor)}"
        data.text = viagem.data

        return view
    }
}
