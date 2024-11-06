package yandex_6_training_2_dz

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while(true) {

        val (n, k) = bufferedReader.readLine()?.split(" ")?.map { it.toInt() } ?: break
        val s = bufferedReader.readLine().split(" ").map { it.toInt() }


        val sorty = s.sorted()

        var left = 0

        var right = 1

        while(right < n){
            while(right < n && sorty[right] - sorty[left] <= k){
                right++
            }
            left++
            right++
        }
        outputWriter.println(right - left)







    }

    outputWriter.close()
    bufferedReader.close()
}




