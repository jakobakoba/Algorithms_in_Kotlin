package yandex.yandex_1_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val n = bufferedReader.readLine()?.split(" ")?.map { it.toInt() } ?: break

        val set = mutableSetOf<Int>()

        for(num in n){
            set.add(num)
        }
        outputWriter.println(set.size)


    }

    outputWriter.close()
    bufferedReader.close()
}


