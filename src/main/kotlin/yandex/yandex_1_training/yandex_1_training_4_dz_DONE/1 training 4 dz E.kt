package yandex.yandex_1_training.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while(true){
        val n = bufferedReader.readLine()?.toInt() ?: break
        val map = mutableMapOf<Long, Long>()
        repeat(n){
            val (height, weight) = bufferedReader.readLine().trim().split(" ").map{it.toLong()}

            map[height] = maxOf(map.getOrDefault(height, 0), weight)
        }

        outputWriter.println(map.values.sum())
    }

    outputWriter.close()
    bufferedReader.close()
}


