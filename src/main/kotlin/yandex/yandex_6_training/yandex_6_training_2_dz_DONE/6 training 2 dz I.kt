package yandex.yandex_6_training.yandex_6_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.util.*


fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    while (true) {
        val n = bufferedReader.readLine()?.toInt() ?: break
        val a = bufferedReader.readLine().split(" ").map { it.toLong() }
        val b = bufferedReader.readLine().split(" ").map { it.toLong() }
        val p = bufferedReader.readLine().split(" ").map { it.toInt() }

        val aStack = Stack<Int>()
        val bStack = Stack<Int>()

        val aSorted = (0 until n).sortedWith(compareBy<Int>{a[it]}.thenBy { b[it] }.thenByDescending { it })
        val bSorted = (0 until n).sortedWith(compareBy<Int> { b[it] }.thenBy { a[it] }.thenByDescending { it })

        aStack.addAll(aSorted)
        bStack.addAll(bSorted)

        val result = IntArray(n)
        val set = mutableSetOf<Int>()
        val ans = StringBuilder()

        for (i in 0 until n){
            result[i] = if (p[i] == 1){
                while(bStack.peek() in set){
                    bStack.pop()
                }
                val value = bStack.pop()
                set.add(value)
                value
            } else {
                while(aStack.peek() in set){
                    aStack.pop()
                }
                val value = aStack.pop()
                set.add(value)
                value
            } + 1
            if (i == n - 1){
                ans.append("${result[i]}")
            } else {
                ans.append("${result[i]} ")
            }
        }
        outputWriter.println(ans.toString())
    }

    outputWriter.close()
    bufferedReader.close()
}
