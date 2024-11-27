package yandex.yandex_3_training_b_division

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val stack = Stack<Int>()

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while(true){
        val s = bufferedReader.readLine().split(" ") ?: break

        when(s.size){
            1 -> {
                when(s[0]){
                    "pop" -> {
                        if (stack.isNotEmpty()){
                            outputWriter.println(stack.pop())
                        } else {
                            outputWriter.println("error")
                        }
                    }
                    "back" -> {
                        if (stack.isNotEmpty()){
                            outputWriter.println(stack.peek())
                        } else {
                            outputWriter.println("error")
                        }
                    }
                    "size" -> {
                        outputWriter.println(stack.size)
                    }
                    "clear" -> {
                        while(stack.isNotEmpty()){
                            stack.pop()
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
                stack.add(s[1].toInt())
                outputWriter.println("ok")
            }
        }
    }
}