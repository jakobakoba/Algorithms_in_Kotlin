package yandex_1_training_5_dz

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    while(true){
        val (n, k) = bufferedReader.readLine()?.split(" ")?.map { it.toInt() } ?: break

        val s = bufferedReader.readLine().split(" ").map { it.toInt() }

        val set = mutableSetOf<Int>()

        var left = 0
        var min = Int.MAX_VALUE
        var ans = intArrayOf(0,0)

        var uniqueTypes = 0

        val map = mutableMapOf<Int, Int>()

        for (right in 0 until n){
            val rightType = s[right]

            map[rightType] = map.getOrDefault(rightType, 0) + 1

            if (map[rightType] == 1) uniqueTypes += 1

            while(uniqueTypes == k){
                if (right - left + 1 < min) {
                    min = right - left + 1
                    ans[0] = left + 1
                    ans[1] = right + 1
                }
                val leftType = s[left]
                map[leftType]  = map[leftType]!! - 1

                if (map[leftType] == 0) uniqueTypes -= 1

                left++
            }
        }
        outputWriter.println("${ans[0]} ${ans[1]}")
    }

    outputWriter.close()
    bufferedReader.close()
}

