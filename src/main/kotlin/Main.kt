import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите сумму (в рублях):")
    val sum = ((scanner.nextLine().toFloat())*100).toInt()
    println("Выберите способ оплаты: \n1. Mastercard/Maestro\n2. Visa/Мир\n3. VK Pay")
    while (true) {
        when (scanner.nextLine()) {
            "1" -> {
                if (sum > 150_000_00){
                    println("Сумма по карте не может превышать 150 тысяч рублей")
                    break
                } else {
                    val tax = ((sum * 0.006) + 2000).toInt()
                    val result = if (tax >= sum) 0 else sum-tax
                    val tax2 = if (result == 0) sum else tax
                    println("К зачислению ${(result.toFloat()/100)}, комиссия составит ${(tax2.toFloat()/100)}")
                    break
                }
            }
            "2" -> {
                if (sum > 150_000_00){
                    println("Сумма по карте не может превышать 150 тысяч рублей")
                    break
                } else {
                    val tax = Integer.max((sum * 0.0075).toInt(),3500)
                    val result = if (tax >= sum) 0 else sum-tax
                    val tax2 = if (result == 0) sum else tax
                    println("К зачислению ${(result.toFloat()/100)}, комиссия составит ${(tax2.toFloat()/100)}")
                    break
                }
            }
            "3" -> {
                if (sum > 15_000_00){
                    println("Сумма VK Pay не может превышать 15 тысяч рублей")
                    break
                }else {
                    println("К зачислению $sum, комиссия не взимается")
                    break
                }
            }
            else -> println("Нет такого пункта, попробуйте ещё раз")
        }
    }

}