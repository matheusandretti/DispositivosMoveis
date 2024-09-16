fun main() {
    var idade: Int = 22
    var altura: Double = 1.74
    var nome: String = "Matheus"
    var student: Boolean = true

    var somaid: Int = idade + idade
    var alt: Double = altura*2

    var saudacao: String = "Olá, $nome"

    //exibição de resultados
    println("Idade: $idade")
    println("Altura: $altura")
    println("Nome: $nome")
    println("É estudante? $student")
    println("Soma das idades: $somaid")
    println("Altura dobrada: $alt")
    println(saudacao)
}