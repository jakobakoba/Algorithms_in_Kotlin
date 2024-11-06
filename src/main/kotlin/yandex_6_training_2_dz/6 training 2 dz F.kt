package yandex_6_training_2_dz

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val modulo = 1000000007

    while (true) {
        val n = bufferedReader.readLine()?.toInt() ?: break
        val s = bufferedReader.readLine().split(" ").map { it.toLong() }

        var sumTriples = 0L
        var sumPairs = 0L
        var prefixSum = 0L

        for (i in 0 until n) {
            val current = s[i]

            sumTriples = (sumTriples + current * sumPairs % modulo) % modulo

            sumPairs = (sumPairs + current * prefixSum % modulo) % modulo

            prefixSum = (prefixSum + current) % modulo
        }

        outputWriter.println(sumTriples)
    }

    outputWriter.close()
    bufferedReader.close()
}
