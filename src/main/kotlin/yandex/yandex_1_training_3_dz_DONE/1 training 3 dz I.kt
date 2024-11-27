package yandex.yandex_1_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter


fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)




        val map = mutableMapOf<String, Int>()
        val n = bufferedReader.readLine().toInt()
        repeat (n){
            val m = bufferedReader.readLine().toInt()
            repeat(m){
                val language = bufferedReader.readLine()
                map[language] = map.getOrDefault(language, 0) + 1
            }
        }
        val all = mutableListOf<String>()
        val single = mutableListOf<String>()
        for ((language, num) in map){
            if (num == n){
                all.add(language)
                single.add(language)
            } else {
                single.add(language)
            }
        }

        if (all.isNotEmpty()){
            outputWriter.println(all.size)
        } else if (all.isEmpty()){
            outputWriter.println(0)
        }
        for (i in 0 until all.size){
            outputWriter.println(all[i])
        }
        if (single.isNotEmpty()){
            outputWriter.println(single.size)
        }
        for (i in  0 until single.size){
            outputWriter.println(single[i])
        }




    outputWriter.close()
    bufferedReader.close()


}