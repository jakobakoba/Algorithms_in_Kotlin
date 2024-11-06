package yandex_1_training_5_dz


import java.io.File
import java.io.PrintWriter
import java.lang.Math.abs

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while (true) {
        val n = bufferedReader.readLine()?.toInt() ?: break
        val s1 = bufferedReader.readLine().split(" ").map { it.toInt() }
        val m = bufferedReader.readLine().toInt()
        val s2 = bufferedReader.readLine().split(" ").map { it.toInt() }

        var pointer1 = 0
        var pointer2 = 0

        var left = 0
        var right = 0

        var min = Int.MAX_VALUE

        while (pointer1 < n && pointer2 < m) {
            if (abs(s1[pointer1] - s2[pointer2]) < min) {
                min = abs(s1[pointer1] - s2[pointer2])
                left = s1[pointer1]
                right = s2[pointer2]
            }
            if (s1[pointer1] < s2[pointer2]) {
                pointer1++
            } else {
                pointer2++
            }
        }
        outputWriter.println("$left $right")
    }





    outputWriter.close()
    bufferedReader.close()
}



