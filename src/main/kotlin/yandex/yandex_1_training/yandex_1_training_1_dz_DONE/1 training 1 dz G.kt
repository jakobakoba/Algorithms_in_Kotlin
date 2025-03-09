package yandex.yandex_1_training.yandex_1_training_1_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    bufferedReader.lineSequence().forEach { line ->

        val (N, K, M) = line.split(" ").map { it.toInt() }

        var models = 0

        var resource = N

        if (M <= K){
            while(resource >= K){
                val blanks = resource / K

                models += blanks * (K / M)

                resource = resource % K + blanks * (K % M)
            }
        }

        outputWriter.println(models)
    }

    outputWriter.close()
    bufferedReader.close()
}