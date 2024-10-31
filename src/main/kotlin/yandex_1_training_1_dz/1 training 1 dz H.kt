package yandex_1_training_1_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    bufferedReader.use { reader ->
        while(true){
            val a = reader.readLine()?.toInt() ?: break
            val b = reader.readLine().toInt()
            val c = reader.readLine().toInt()
            val d = reader.readLine().toInt()

            val min1 = (c-1) * (a + 1) + 1
            val min2 = (d - 1) * (b + 1) + 1

            val max1 = (c-1) * (a + 1) + 1 + 2 * a
            val max2 = (d - 1) * (b + 1) + 1 + 2 * b

            val left = maxOf(min1, min2)
            val right = minOf(max1, max2)

            if (right < left){
                outputWriter.println("-1")
            } else {
                outputWriter.println("$left $right")
            }
        }
    }
    outputWriter.close()
    bufferedReader.close()
}