package yandex.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    bufferedReader.lineSequence().forEach { line ->
        val s = line.split(" ").map { it.toInt() }

        var ans = "YES"

        var cur = s[0]
        for(i in 1 until s.size){
            if (s[i] <= cur){
                ans = "NO"
            }
            cur = s[i]
        }
        outputWriter.println(ans)

    }
    outputWriter.close()
    bufferedReader.close()
}