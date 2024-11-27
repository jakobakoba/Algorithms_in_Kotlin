package yandex.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    val map = mutableMapOf<String, Int>()
    while(true){
        val line = bufferedReader.readLine()?.trim()?.split(" ") ?: break
        when (line[0]){
            "DEPOSIT" -> {
                map[line[1]] = map.getOrPut(line[1]){0}  + line[2].toInt()
            }
            "INCOME" -> {
                for ((key, value) in map){
                    if (value > 0){
                        map[key] = map[key]!! + (map[key]!! * line[1].toInt()/100)
                    }
                }
            }
            "TRANSFER" -> {
                map[line[1]] = map.getOrPut(line[1]){0} - line[3].toInt()
                map[line[2]] = map.getOrPut(line[2]){0} + line[3].toInt()
            }
            "WITHDRAW" -> {
                map[line[1]] = map.getOrPut(line[1]){0} - line[2].toInt()
            }
            "BALANCE" -> {
                if (map.containsKey(line[1])){
                    outputWriter.println(map[line[1]])
                } else {
                    outputWriter.println("ERROR")
                }
            }
        }
    }


    outputWriter.close()
    bufferedReader.close()
}


