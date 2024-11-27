package yandex.yandex_6_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.util.*


fun main() {
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val n = bufferedReader.readLine().toInt()

    val prefix = mutableListOf<Long>()

    val stack = Stack<Long>()

    repeat(n){
        val command = bufferedReader.readLine()
        when {
            command[0] == '+' -> {
                val num = command.substring(1).trim().toLong()
                if (prefix.isEmpty()){
                    prefix.add(num)
                } else {
                    prefix.add(num + prefix.last())
                }
                    stack.add(num)
            }
            command[0] == '-' -> {
                outputWriter.println(stack.pop())
                prefix.removeLast()
            }
            command[0] == '?' -> {
                val k = command.substring(1).toInt()
                val last = prefix.last()
                val early = if (prefix.size - k - 1 < 0 ) 0 else prefix[prefix.size - k - 1]
                outputWriter.println(last - early)
            }

        }
    }
    outputWriter.close()

}