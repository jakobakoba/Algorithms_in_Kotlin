package yandex.yandex_1_training.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val s = mutableListOf<Int>()

    bufferedReader.lineSequence().forEach { line ->
        if (line.toInt() != -2000000000){
            s.add (line.toInt())
        }
    }
    var constant = true
    var ascending = true
    var weakascending = true
    var descending = true
    var weakdescending = true



    var cur = s[0]
    for (i in 1 until s.size){
        if (s[i] != cur){
            constant = false
        }
        if (cur >= s[i]){
            ascending = false
        }
        if (cur > s[i]){
            weakascending = false
        }
        if (cur <= s[i]){
            descending = false
        }
        if (cur < s[i]){
            weakdescending = false
        }



        cur = s[i]
    }

    when {
        constant -> outputWriter.println("CONSTANT")
        ascending -> outputWriter.println("ASCENDING")
        weakascending -> outputWriter.println("WEAKLY ASCENDING")
        descending -> outputWriter.println("DESCENDING")
        weakdescending -> outputWriter.println("WEAKLY DESCENDING")
        else -> outputWriter.println("RANDOM")
    }


    outputWriter.close()
    bufferedReader.close()
}