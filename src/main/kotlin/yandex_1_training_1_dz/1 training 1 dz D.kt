package yandex_1_training_1_dz

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()

    if (c < 0){
        println("NO SOLUTION")
        return
    }

    if (a == 0){
        if (c * c == b){
            println("MANY SOLUTIONS")
        } else {
            println("NO SOLUTION")
        }
    } else {
        val diff = c * c - b
        if (diff % a == 0){
            println(diff / a)
        } else {
            println("NO SOLUTION")
        }
    }


}
