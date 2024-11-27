package yandex.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val map = mutableMapOf<String, Int>()
    val ans = mutableListOf<Int>()
    while(true){
        val line = bufferedReader.readLine()
        if (line.isNullOrEmpty()){
            break
        }
        val s = line.trim().split(" ")
        for (str in s){
            if (map.containsKey(str)){
                ans.add(map[str]!!)
                map[str] = map[str]!! + 1
            } else {
                ans.add(0)
                map[str] = 1
            }
        }
    }
    outputWriter.println(ans.joinToString(" "))

    outputWriter.close()
    bufferedReader.close()
}


