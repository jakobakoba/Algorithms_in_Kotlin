package yandex.yandex_3_training_b_division

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(){
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while(true){
        val stack = Stack<Int>()
        val n = bufferedReader.readLine()?.toInt() ?: break
        val s = bufferedReader.readLine().split(" ").map{it.toInt()}

        var counter = 1
        for (i in 0 until s.size){
            if (i == 0){
                stack.add(s[i])
            } else {
                if(stack.isEmpty() || stack.peek() != counter){
                    stack.add(s[i])
                }
            }
            while (stack.isNotEmpty() && stack.peek() == counter){
                stack.pop()
                counter++
            }
        }
        outputWriter.println(if (stack.isEmpty()) "YES" else "NO")
    }
}

