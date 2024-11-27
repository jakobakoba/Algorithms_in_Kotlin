package yandex.yandex_1_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val (n, m) = bufferedReader.readLine()?.trim()?.split(" ")?.map { it.toInt() } ?: break

        val anya = mutableSetOf<Int>()

        for(i in 0 until n){
            anya.add(bufferedReader.readLine().toInt())
        }

        val borya = mutableSetOf<Int>()

        for(i in 0 until m){
            borya.add(bufferedReader.readLine().toInt())
        }


        val both = anya.intersect(borya).toMutableList()
        val anyaOnly = anya.subtract(both).toMutableList()
        val boryaOnly = borya.subtract(both).toMutableList()

        outputWriter.println(both.size)
        outputWriter.println(both.sorted().joinToString(" "))
        outputWriter.println(anyaOnly.size)
        outputWriter.println(anyaOnly.sorted().joinToString(" "))
        outputWriter.println(boryaOnly.size)
        outputWriter.println(boryaOnly.sorted().joinToString(" "))



    }

    outputWriter.close()
    bufferedReader.close()
}


