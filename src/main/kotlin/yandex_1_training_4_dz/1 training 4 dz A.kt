package yandex_1_training_4_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val n = bufferedReader.readLine()?.toInt() ?: break
        val map = mutableMapOf<String, String>()
        repeat(n){
            val (a, b) = bufferedReader.readLine().split(" ")
            map[a] = b
            map[b] = a
        }
        outputWriter.println(map[bufferedReader.readLine()])

    }

    outputWriter.close()
    bufferedReader.close()
}


