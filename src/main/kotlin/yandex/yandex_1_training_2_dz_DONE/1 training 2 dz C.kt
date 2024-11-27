package yandex.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter
import kotlin.math.abs

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val s = mutableListOf<Int>()

    bufferedReader.use{ reader ->
        while(true){
            val n = reader.readLine()?.toInt() ?: break
            val s = reader.readLine().split(" ").map { it.toInt() }
            val target = reader.readLine().toInt()

            var min = Int.MAX_VALUE
            var x = -1

            for (num in s){
                if (abs(target - num) < min){
                    min = abs(target - num)
                    x = num
                }
            }
            outputWriter.println(x)
        }
    }

    outputWriter.close()
    bufferedReader.close()
}