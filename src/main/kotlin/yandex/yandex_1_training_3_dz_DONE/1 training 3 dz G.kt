package yandex.yandex_1_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter


fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val n = bufferedReader.readLine()?.toInt() ?: break
        val set = mutableSetOf<Int>()
        repeat(n){
            val (a, b) = bufferedReader.readLine().split(" ").map { it.toInt() }

            if (a >= 0 && b >= 0 && a + b == n - 1 && a !in set){
                set.add(a)
            }
        }
        outputWriter.println(set.size)
        break

    }


    outputWriter.close()
    bufferedReader.close()


}