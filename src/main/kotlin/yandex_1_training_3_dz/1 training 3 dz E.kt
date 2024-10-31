package yandex_1_training_3_dz

import java.io.File
import java.io.PrintWriter


fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val (x, y, z) = bufferedReader.readLine()?.split(" ") ?: break
        val set = listOf<String>(x,y,z).toSet()
        val seen = mutableSetOf<Char>()
        val s = bufferedReader.readLine()
        var counter = 0
        for (i in s){
            if (i.toString() !in set && i !in seen){
                counter += 1
                seen.add(i)

            }
        }
        outputWriter.println(counter)
    }


    outputWriter.close()
    bufferedReader.close()


}