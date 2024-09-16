fun main() {
    var nome: String = "Matheus"
    var idade: Int = 22
    var sal: Double = 2000.00
    var qtdmes: Int = 12
    var qtdprod: Int = 50

    var calcSal: Double = sal*qtdmes
    val desc: Double = 900.00
    var saliq: Double = calcSal-desc
    var conca = "$nome, $saliq, meus parabéns"

    println("Nome: $nome")
    println("Idade: $idade")
    println("Salário: $sal")
    println("Quantidade de meses trabalhados: ")
    println("Quantidade de produtos: $qtdprod")
    println("Salário anual: $calcSal")
    println("Valor de desconto anual: $desc")
    println("Salário Líquido: $saliq")
    println(conca)
}