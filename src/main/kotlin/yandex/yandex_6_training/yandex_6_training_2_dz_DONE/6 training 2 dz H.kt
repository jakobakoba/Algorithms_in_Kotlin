package yandex.yandex_6_training.yandex_6_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter
import kotlin.math.abs

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    while (true) {
        val n = bufferedReader.readLine()?.toInt() ?: break
        val s = bufferedReader.readLine().split(" ").map { it.toLong() }

        var totalEmployees = s.sum()


        var curEmployees = 0L
        var index = 0

        for (i in 0 until n){
            curEmployees += s[i]
            if (curEmployees >= (totalEmployees + 1) / 2){
                index = i
                break
            }
        }

        var minMoves = 0L
        for (i in 0 until n){
            if (i != index){
                minMoves += s[i] * abs(i - index)
            }
        }

        outputWriter.println(minMoves)



    }

    outputWriter.close()
    bufferedReader.close()
}
