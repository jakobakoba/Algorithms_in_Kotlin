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
        val stack = Stack<Char>()
        val map = mapOf(']' to '[', '}' to '{', ')' to '(')
        var ans = "yes"
        for (i in bufferedReader.readLine() ?: break){
            if (i in map.values){
                stack.add(i)
            } else {
                if (stack.isEmpty()){
                    ans = "no"
                    break
                } else if (stack.isNotEmpty() && stack.pop() != map[i]){
                    ans = "no"
                    break
                }
            }
        }
        if (stack.isNotEmpty()) ans = "no"
        outputWriter.println(ans)


    }


}