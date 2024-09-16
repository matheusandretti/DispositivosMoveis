import java.text.DecimalFormat

fun main() {
    val nome: String = "Matheus"
    val prec: Double = 28.50
    val qtdprod: Int = 54
    val tax: Double = 0.195
    val margem: Double = 0.30

    val total: Double = prec * qtdprod
    val totalImp: Double = total * tax + total
    val varVenda: Double = totalImp / (1 - margem) //Se a margem de lucro é de 30% do valor da venda, então o valor com impostos corresponde a 70%
    // do valor total, não basta multiplicar o valor com impostos por 30% e somar no valor, se não a porcentagem final estará incorreta

    val df = DecimalFormat("R$ #,##0.00")

    println("Nome: $nome")
    println("Preço: ${df.format(prec)}")
    println("Quantidade de produtos: $qtdprod")
    println("Imposto: ${tax * 100}%")
    println("Margem de lucro: ${margem * 100}%")
    println("Valor total sem impostos: ${df.format(total)}")
    println("Valor total com impostos: ${df.format(totalImp)}")
    println("Preço sugerido de venda: ${df.format(varVenda)}")
}