package yandex_1_training_3_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val s = mutableListOf<List<String>>()

    while(true){
        val input = bufferedReader.readLine()?.trim()?.split(" ") ?: break
        s.add(input)
    }
    val seen = mutableSetOf<String>()
    var counter = 0
    for (i in s){
        for(word in i){
            if (word.isNotEmpty() && word !in seen){
                counter += 1
                seen.add(word)
            }
        }
    }

    outputWriter.println(counter)

    outputWriter.close()
    bufferedReader.close()


}