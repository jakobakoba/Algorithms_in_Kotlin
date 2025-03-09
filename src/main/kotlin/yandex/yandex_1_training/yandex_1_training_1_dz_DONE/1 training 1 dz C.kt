package yandex.yandex_1_training.yandex_1_training_1_dz_DONE

import java.util.Scanner

fun normalizeNumber(num: String): String {
    var result = ""

    for(char in num){
        if (char.isDigit()){
            result += char
        }
    }

    if (result.length > 10){
        result = result.substring(result.length - 10)
    }

    if (result.length == 7){
        result = "495" + result
    }
    return result
}


fun main() {
    val scanner = Scanner(System.`in`)
    val addNumber = normalizeNumber(scanner.nextLine())
    val firstNumber = normalizeNumber(scanner.nextLine())
    val secondNumber = normalizeNumber(scanner.nextLine())
    val thirdNumber = normalizeNumber(scanner.nextLine())

    fun checkNumber(num: String){
        if (num == addNumber){
            println("YES")
        } else {
            println("NO")
        }
    }

    checkNumber(firstNumber)
    checkNumber(secondNumber)
    checkNumber(thirdNumber)
}
