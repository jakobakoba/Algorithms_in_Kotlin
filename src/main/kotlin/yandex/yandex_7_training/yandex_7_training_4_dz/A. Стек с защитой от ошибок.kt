package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val stack = mutableListOf<Int>()
    while(true){
        val command = reader.readLine().trim().split(" ")
        when(command[0]){
            "push" -> {
                stack.add(command[1].toInt())
                println("ok")
            }
            "pop" -> {
                if (stack.isEmpty()){
                    println("error")
                } else {
                    println(stack.removeLast())
                }
            }
            "back" -> {
                if (stack.isEmpty()){
                    println("error")
                } else {
                    println(stack.last())
                }
            }
            "size" -> {
                println(stack.size)
            }
            "clear" -> {
                while(stack.isNotEmpty()){
                    stack.removeLast()
                }
                println("ok")
            }
            "exit" -> {
                println("bye")
                break
            }
        }
    }
}