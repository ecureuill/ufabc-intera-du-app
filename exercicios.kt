import java.util.Scanner

fun soma(a: Int, b: Int): Int {
    return a + b
}

fun parOuImpar(n: Int): String {
    return if (n % 2 == 0) "Par" else "Ímpar"
}

fun areaCirculo(raio: Double): Double {
    return Math.PI * raio * raio
}

fun cadastrarProduto() {
    val scanner = Scanner(System.`in`)

    print("Digite o nome do produto: ")
    val nome = scanner.nextLine()

    print("Digite o preço: ")
    val precoInput = scanner.nextLine()
    val preco = precoInput.toDoubleOrNull() ?: 0.0

    var codigoBarras: String
    while (true) {
        print("Digite o código de barras (8 dígitos): ")
        codigoBarras = scanner.nextLine()
        if (codigoBarras.length == 8 && codigoBarras.all { it.isDigit() }) break
        println("Código de barras inválido. Digite exatamente 8 dígitos.")
    }

    print("O produto está em promoção? (True/False): ")
    var promocional: Boolean
    while (true) {
        val promocionalInput = scanner.nextLine()
        val ehTrue = promocionalInput.equals("True", ignoreCase = true)
        val ehFalse = promocionalInput.equals("False", ignoreCase = true)
        if (ehTrue || ehFalse) {
            promocional = ehTrue
            break
        }
        println("Valor inválido. O produto está em promoção? (True/False): ")
    }
    println("\nProduto: $nome Preco:")
    println("R$%.2f".format(preco))
    println("Código de barras: $codigoBarras")
    println("Item promocional: $promocional")
    println("\nO produto '$nome' foi cadastrado com sucesso.")
}

fun mostrarTemperaturaConvertida() {
    val scanner = Scanner(System.`in`)
    print("Digite a temperatura em Celsius: ")
    val celsiusInput = scanner.nextLine()
    val celsius = celsiusInput.toDoubleOrNull() ?: 0.0
    val fahrenheit = celsius * 9 / 5 + 32
    println("Temperatura equivalente em Fahrenheit: %.2f".format(fahrenheit))
}

fun maiorDeDoisNumeros() {
    val scanner = Scanner(System.`in`)
    print("Digite o primeiro número: ")
    val num1Input = scanner.nextLine()
    val num1 = num1Input.replace(",", ".").toDoubleOrNull() ?: 0.0

    print("Digite o segundo número: ")
    val num2Input = scanner.nextLine()
    val num2 = num2Input.replace(",", ".").toDoubleOrNull() ?: 0.0

    if (num1 > num2) {
        println("O maior número é: $num1")
    } else if (num2 > num1) {
        println("O maior número é: $num2")
    } else {
        println("Os números são iguais: $num1")
    }
}

fun classificarIdade() {
    val scanner = Scanner(System.`in`)
    print("Digite sua idade: ")
    val idadeInput = scanner.nextLine()
    val idade = idadeInput.toIntOrNull() ?: 0

    val classificacao = when {
        idade in 0..11 -> "Criança"
        idade in 12..17 -> "Adolescente"
        idade in 18..59 -> "Adulto"
        idade >= 60 -> "Idoso"
        else -> "Idade inválida"
    }
    println("Classificação: $classificacao")
}

fun calculadoraSimples() {
    val scanner = Scanner(System.`in`)
    print("Digite o primeiro número: ")
    val num1Input = scanner.nextLine()
    val num1 = num1Input.replace(",", ".").toDoubleOrNull() ?: 0.0

    print("Digite o segundo número: ")
    val num2Input = scanner.nextLine()
    val num2 = num2Input.replace(",", ".").toDoubleOrNull() ?: 0.0

    print("Digite a operação (+, -, *, /): ")
    val operacao = scanner.nextLine()

    val resultado = when (operacao) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> if (num2 != 0.0) num1 / num2 else "Erro: divisão por zero"
        else -> "Operação inválida"
    }
    println("Resultado: $resultado")
}

fun mostrarNumerosPares() {
    println("Números pares de 1 a 20:")
    for (i in 1..20) {
        if (i % 2 == 0) {
            println(i)
        }
    }
}

fun mostrarTabuada() {
    val scanner = Scanner(System.`in`)
    print("Digite um número para ver a tabuada: ")
    val numeroInput = scanner.nextLine()
    val numero = numeroInput.replace(",", ".").toDoubleOrNull() ?: 0.0
    var i = 1
    println("Tabuada de $numero:")
    while (i <= 10) {
        println("$numero x $i = ${numero * i}")
        i++
    }
}

fun pedirSenha() {
    val scanner = Scanner(System.`in`)
    val senhaCorreta = "kotlin123"
    var senha: String
    do {
        print("Digite a senha: ")
        senha = scanner.nextLine()
        if (senha != senhaCorreta) {
            println("Senha incorreta. Tente novamente.")
        }
    } while (senha != senhaCorreta)
    println("Senha correta! Acesso permitido.")
}

class Carro(val marca: String, val modelo: String, val ano: Int) {
    fun detalhes() {
        println("Carro: $marca $modelo, Ano: $ano")
    }
}

class ContaCorrente {
    private var saldo: Double = 0.0

    fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
            println("Depositado R$%.2f".format(valor))
            exibirSaldo()
        } else {
            println("Valor de depósito inválido.")
        }
    }

    fun sacar(valor: Double) {
        if (valor > saldo) {
            println("Tentativa de saque de R$%.2f. Saldo insuficiente.".format(valor))
        } else if (valor <= 0) {
            println("Valor de saque inválido.")
        } else {
            saldo -= valor
            println("Sacado R$%.2f".format(valor))
            exibirSaldo()
        }
    }

    fun exibirSaldo() {
        println("Saldo atual: R$%.2f".format(saldo))
    }
}

fun main() {
    println("Olá, Mundo!")
    println("Menu nome é Camilla Silva")
    println("Estudo 'Desenvolvimento de Aplicativos Móveis Acessíveis voltados ao Design Universal' na UFABC")

    val scanner = Scanner(System.`in`)
    while (true) {
        println("\n===== MENU PRINCIPAL =====")
        println("0. Sair do programa")
        println("1. Cadastrar produto")
        println("2. Converter temperatura Celsius para Fahrenheit")
        println("3. Maior de dois números")
        println("4. Classificar idade")
        println("5. Calculadora simples")
        println("6. Mostrar números pares de 1 a 20")
        println("7. Mostrar tabuada de um número")
        println("8. Verificar senha")
        println("9. Soma de dois inteiros")
        println("10. Par ou Ímpar")
        println("11. Área do círculo")
        println("12. Mostrar detalhes de dois carros")
        println("13. Operações com conta corrente")
        print("Escolha uma opção: ")
        val opcao = scanner.nextLine().toIntOrNull() ?: -1
        if (opcao == 0) {
            println("Saindo do programa...")
            break
        }
        when (opcao) {
            1 -> cadastrarProduto()
            2 -> mostrarTemperaturaConvertida()
            3 -> maiorDeDoisNumeros()
            4 -> classificarIdade()
            5 -> calculadoraSimples()
            6 -> mostrarNumerosPares()
            7 -> mostrarTabuada()
            8 -> pedirSenha()
            9 -> {
                print("Digite o primeiro número inteiro: ")
                val a = scanner.nextLine().toIntOrNull() ?: 0
                print("Digite o segundo número inteiro: ")
                val b = scanner.nextLine().toIntOrNull() ?: 0
                println("Soma: ${soma(a, b)}")
            }
            10 -> {
                print("Digite um número inteiro: ")
                val n = scanner.nextLine().toIntOrNull() ?: 0
                println("$n é ${parOuImpar(n)}")
            }
            11 -> {
                print("Digite o raio do círculo: ")
                val raio = scanner.nextLine().replace(",", ".").toDoubleOrNull() ?: 0.0
                println("Área do círculo: %.2f".format(areaCirculo(raio)))
            }
            12 -> {
                val carro1 = Carro("Toyota", "Corolla", 2020)
                val carro2 = Carro("Ford", "Fiesta", 2018)
                carro1.detalhes()
                carro2.detalhes()
            }
            13 -> {
                val conta = ContaCorrente()
                conta.depositar(200.0)
                conta.depositar(150.0)
                conta.sacar(100.0)
                conta.sacar(500.0)
            }
            else -> println("Opção inválida. Tente novamente.")
        }
        print("\nPressione ENTER para continuar...")
        scanner.nextLine()
    }
}