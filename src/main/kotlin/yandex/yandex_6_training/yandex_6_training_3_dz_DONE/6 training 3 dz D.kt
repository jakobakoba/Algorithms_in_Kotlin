package yandex.yandex_6_training.yandex_6_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(){
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val stack = Stack<Int>()

    val s = bufferedReader.readLine().split(" ")

    for (i in s){
        if (i.all{it.digitToIntOrNull() != null}){
            stack.add(i.toInt())
        } else {
            val second = stack.pop()
            val first = stack.pop()

            var ans = 0

            when (i){
                "+" -> {
                    ans = first + second
                }
                "-" -> {
                    ans = first - second
                }
                "/" -> {
                    ans = first / second
                }
                "*" -> {
                    ans = first * second
                }
            }
            stack.add(ans)
        }
    }
    outputWriter.println(stack.pop())
}