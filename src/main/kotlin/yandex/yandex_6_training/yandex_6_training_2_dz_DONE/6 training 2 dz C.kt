package yandex.yandex_6_training.yandex_6_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val (n, r) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val s = bufferedReader.readLine().split(" ").map { it.toLong() }

    var counter = 0L
    var right = 0

    for (i in s){
        while(right < s.size && s[right] - i <= r){
            right++
        }
        counter += s.size  - right
    }

    outputWriter.println(if (counter < 0) 0 else counter)




    outputWriter.close()
    bufferedReader.close()
}



