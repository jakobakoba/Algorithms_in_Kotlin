package yandex.yandex_3_training_b_division

import java.io.File
import java.io.PrintWriter
import java.util.Deque
import java.util.LinkedList

fun main(){
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    val deque: Deque<Int> = LinkedList()

    while(true){
        val s = bufferedReader.readLine().split(" ")
        when(s.size){
            1 -> {
                when(s[0]){
                    "pop_front" ->{
                        if (deque.isNotEmpty()){
                            outputWriter.println(deque.pollFirst())
                        } else {
                            outputWriter.println("error")
                        }
                    }
                    "pop_back" -> {
                        if (deque.isNotEmpty()){
                            outputWriter.println(deque.pollLast())
                        } else {
                            outputWriter.println("error")
                        }
                    }
                    "front" -> {
                        if(deque.isNotEmpty()){
                            outputWriter.println(deque.peekFirst())
                        } else {
                            outputWriter.println("error")
                        }
                    }
                    "back" -> {
                        if (deque.isNotEmpty()){
                            outputWriter.println(deque.peekLast())
                        } else {
                            outputWriter.println("error")
                        }
                    }
                    "size" -> {
                        outputWriter.println(deque.size)
                    }
                    "clear" -> {
                        while(deque.isNotEmpty()){
                            deque.poll()
                        }
                        outputWriter.println("ok")
                    }
                    "exit" -> {
                        outputWriter.println("bye")
                        break
                    }
                }
            }
            2 -> {
                when(s[0]){
                    "push_front" -> {
                        deque.addFirst(s[1].toInt())
                        outputWriter.println("ok")
                    }
                    "push_back" -> {
                        deque.addLast(s[1].toInt())
                        outputWriter.println("ok")
                    }
                }
            }
        }
    }



}