package yandex.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val s = mutableListOf<Int>()

    bufferedReader.use{ reader ->
        while(true){
            val s = reader.readLine()?.split(" ")?.map { it.toInt() } ?: break
            var counter = 0
            for (i in 1 until s.size - 1){
                if (s[i] > s[i-1] && s[i] > s[i+1]){
                    counter++
                }
            }
            outputWriter.println(counter)
        }
    }



    outputWriter.close()
    bufferedReader.close()
}