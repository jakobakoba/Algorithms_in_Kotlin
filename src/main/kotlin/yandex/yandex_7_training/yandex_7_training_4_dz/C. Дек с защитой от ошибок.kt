package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val deque = mutableListOf<Int>()

    while(true){
        val command = reader.readLine().trim().split(" ")

        when(command[0]){
            "push_front" -> {
                deque.addFirst(command[1].toInt())
                println("ok")

            }
            "push_back" -> {
                deque.addLast(command[1].toInt())
                println("ok")
            }
            "pop_front" -> {
                if(deque.isEmpty()){
                    println("error")
                } else {
                    println(deque.removeFirst())
                }
            }
            "pop_back" -> {
                if(deque.isEmpty()){
                    println("error")
                } else {
                    println(deque.removeLast())
                }
            }
            "front" -> {
                if(deque.isEmpty()){
                    println("error")
                } else {
                    println(deque.first())
                }
            }
            "back" -> {
                if(deque.isEmpty()){
                    println("error")
                } else {
                    println(deque.last())
                }
            }
            "size" -> {
                println(deque.size)
            }
            "clear" -> {
                while(deque.isNotEmpty()){
                    deque.removeLast()
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