package yandex.yandex_1_training.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val map = mutableMapOf<String, Int>()

    val ans = mutableListOf<String>()


    while(true){
        val line = bufferedReader.readLine()

        if (line.isNullOrEmpty()){
            break
        }
        val s = line.trim().split(" ")

        for (str in s){
            map[str] = map.getOrDefault(str, 0) + 1
        }

    }
    var max = Int.MIN_VALUE

    for ((key, value) in map){
        if (value > max){
            max = value
        }
    }

    for ((key, value) in map){
        if (value == max){
            ans.add(key)
        }
    }
    val sortedAns = ans.sorted()

    outputWriter.println(sortedAns[0])

    outputWriter.close()
    bufferedReader.close()
}


