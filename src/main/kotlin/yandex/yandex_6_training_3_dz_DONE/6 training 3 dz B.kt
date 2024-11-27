package yandex.yandex_6_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while(true){
        val n = bufferedReader.readLine()?.toInt() ?: break
        val s = bufferedReader.readLine().split(" ").map { it.toInt() }

        val stack = Stack<Pair<Int,Int>>()

        val ans = IntArray(n)

        for (i in s.indices){
            if (i == 0){
                stack.push(Pair(s[i], i))
            } else {
                while(stack.isNotEmpty() && stack.peek().first > s[i]){
                    val index = stack.pop().second
                    ans[index] = i
                }
                stack.push(Pair(s[i], i))
            }
        }
        while (stack.isNotEmpty()){
            val i = stack.pop().second
            ans[i] = -1
        }

        outputWriter.println(ans.joinToString(" "))

    }
}