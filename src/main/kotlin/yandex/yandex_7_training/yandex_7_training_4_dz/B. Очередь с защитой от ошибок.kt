package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val queue1 = mutableListOf<Int>()
    val queue2 = mutableListOf<Int>()

    val reader = BufferedReader(InputStreamReader(System.`in`))

    while(true){
        val command = reader.readLine().trim().split(" ")

        when(command[0]){
            "push" -> {
                queue1.add(command[1].toInt())
                println("ok")
            }
            "pop" -> {
                if (queue1.isEmpty() && queue2.isEmpty()){
                    println("error")
                } else if (queue2.isEmpty()){
                    while(queue1.isNotEmpty()){
                        queue2.add(queue1.removeLast())
                    }
                    println(queue2.removeLast())
                } else {
                    println(queue2.removeLast())
                }
            }
            "front" -> {
                if (queue1.isEmpty() && queue2.isEmpty()){
                    println("error")
                } else if (queue2.isEmpty()){
                    while(queue1.isNotEmpty()){
                        queue2.add(queue1.removeLast())
                    }
                    println(queue2.last())
                } else {
                    println(queue2.last())
                }
            }
            "size" -> {
                println(queue1.size + queue2.size)
            }
            "clear" -> {
                while(queue1.isNotEmpty()){
                    queue1.removeLast()
                }
                while(queue2.isNotEmpty()){
                    queue2.removeLast()
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