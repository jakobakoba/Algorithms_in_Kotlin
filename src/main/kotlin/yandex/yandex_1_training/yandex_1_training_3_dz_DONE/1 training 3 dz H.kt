package yandex.yandex_1_training.yandex_1_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter


fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)




    while(true){
        val set = mutableSetOf<Int>()
        val n = bufferedReader.readLine()?.toInt() ?: break
        repeat(n){
            val (a, b) = bufferedReader.readLine().split(" ").map { it.toInt() }
            set.add(a)
        }
        outputWriter.println(set.size)




    }


    outputWriter.close()
    bufferedReader.close()


}