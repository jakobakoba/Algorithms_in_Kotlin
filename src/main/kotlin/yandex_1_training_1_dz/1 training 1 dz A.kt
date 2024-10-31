package yandex_1_training_1_dz

import java.util.*

fun main(){
    val scanner = Scanner(System.`in`)
    val (temp, wanted) = scanner.nextLine().split(" ").map{it.toInt()}
    val s = scanner.nextLine()

    when(s){
        "freeze" -> {
            println(if (temp <= wanted ) temp else wanted)
        }
        "heat" -> {
            println(if (temp >= wanted) temp else wanted)
        }
        "auto" -> {
            println(wanted)
        }
        "fan" -> {
            println(temp)
        }
    }


}