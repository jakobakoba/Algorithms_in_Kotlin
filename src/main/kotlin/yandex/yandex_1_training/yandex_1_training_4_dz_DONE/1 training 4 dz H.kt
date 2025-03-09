package yandex.yandex_1_training.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    while(true){
        val (n, m) = bufferedReader.readLine()?.trim()?.split(" ")?.map{it.toInt()} ?: break

        val target = bufferedReader.readLine()
        val s = bufferedReader.readLine()

        val first = mutableMapOf<Char, Int>()
        for(char in target){
            first[char] = first.getOrDefault(char, 0) + 1
        }

        val second = mutableMapOf<Char, Int>()
        for (i in 0 until target.length){
            second[s[i]] = second.getOrDefault(s[i], 0) + 1
        }
        var ans = 0
        if (first == second){
            ans++
        }

        for (i in target.length until s.length){
            second[s[i]] = second.getOrDefault(s[i], 0) + 1
            second[s[i - target.length]] = second.getOrDefault(s[i - target.length], 0) - 1
            if (second[s[i - target.length]] == 0){
                second.remove(s[i - target.length] )
            }
            if (first == second) ans++
        }
        outputWriter.println(ans)


    }


    outputWriter.close()
    bufferedReader.close()
}


