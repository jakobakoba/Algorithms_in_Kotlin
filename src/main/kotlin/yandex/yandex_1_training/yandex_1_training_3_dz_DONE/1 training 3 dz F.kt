package yandex.yandex_1_training.yandex_1_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter


fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val first = bufferedReader.readLine() ?: break
        val second = bufferedReader.readLine()

        val map = mutableMapOf<String, Int>()
        for (i in 0 until first.length - 1){
            val x = first.substring(i,i + 2)
            map[x] = map.getOrDefault(x, 0) + 1
        }
        var counter = 0
        val added = mutableSetOf<String>()

        for (i in 0 until second.length - 1){
            val y = second.substring(i, i + 2)
            if (map.containsKey(y) && y !in added){
                counter += map[y]!!
                added.add(y)

            }
        }
        outputWriter.println(counter)

    }


    outputWriter.close()
    bufferedReader.close()


}