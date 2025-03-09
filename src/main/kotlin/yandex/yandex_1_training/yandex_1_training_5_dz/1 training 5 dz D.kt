package yandex.yandex_1_training.yandex_1_training_5_dz

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val (n, r) = bufferedReader.readLine().split(" ").map{it.toInt()}
    val s = bufferedReader.readLine().split(" ").map { it.toInt() }

    var right = 0
    var counter = 0
    for (i in s){
        while(right < n && s[right] - i <= r){
            right++
        }
        counter += n - right
    }

    outputWriter.println(counter)


    outputWriter.close()
    bufferedReader.close()
}

