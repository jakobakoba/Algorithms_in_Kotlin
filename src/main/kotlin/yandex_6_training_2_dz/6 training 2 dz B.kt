package yandex_6_training_2_dz

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while (true) {
        val (n, k) = bufferedReader.readLine()?.split(" ")?.map { it.toInt() } ?: break
        val s = bufferedReader.readLine().trim().split(" ").map { it.toInt() }

        val map = mutableMapOf<Int, Int>()
        map[0] = 1


        var nowSum = 0
        var countRanges = 0

        for (num in s) {
            nowSum += num
            val requiredSum = nowSum - k
            if (map.containsKey(requiredSum)) {
                countRanges += map[requiredSum]!!
            }

            map[nowSum] = map.getOrDefault(nowSum, 0) + 1
        }

        outputWriter.println(countRanges)

    }


    outputWriter.close()
    bufferedReader.close()
}



