package yandex.yandex_3_training_b_division

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(){
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    val queue: Queue<Int> = LinkedList()

    while(true){
        val s = bufferedReader.readLine().split(" ")

        when(s.size){
            1 -> {
                when(s[0]){
                    "pop" -> {
                        if (queue.isNotEmpty()){
                            outputWriter.println(queue.poll())
                        } else {
                            outputWriter.println("error")
                        }
                    }
                    "front" -> {
                        if (queue.isNotEmpty()){
                            outputWriter.println(queue.peek())
                        } else {
                            outputWriter.println("error")
                        }
                    }
                    "size" -> {
                        outputWriter.println(queue.size)
                    }
                    "clear" -> {
                        while(queue.isNotEmpty()){
                            queue.poll()
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
                queue.add(s[1].toInt())
                outputWriter.println("ok")
            }
        }
    }
}