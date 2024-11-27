package yandex.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val s = bufferedReader.readLine()?.trim()?.split(" ")?.map{it.toInt()} ?: break
        if(s.size == 2){
            outputWriter.println(s.sorted().joinToString(" "))
        } else {
            var highPositive: Long? = null
            var lowPositive: Long? = null
            var highNegative: Long? = null
            var lowNegative: Long? = null

            for (num in s) {
                if (num < 0) {
                    if (highNegative == null || num < highNegative) {
                        lowNegative = highNegative
                        highNegative = num.toLong()
                    } else if (lowNegative == null || num < lowNegative) {
                        lowNegative = num.toLong()
                    }
                } else {
                    if (highPositive == null || num > highPositive) {
                        lowPositive = highPositive
                        highPositive = num.toLong()
                    } else if (lowPositive == null || num > lowPositive) {
                        lowPositive = num.toLong()
                    }
                }
            }

            val positiveProduct = if (highPositive != null && lowPositive != null) highPositive * lowPositive else Long.MIN_VALUE
            val negativeProduct = if (highNegative != null && lowNegative != null) highNegative * lowNegative else Long.MIN_VALUE

            if (positiveProduct > negativeProduct) {
                outputWriter.println("$lowPositive $highPositive")
            } else {
                outputWriter.println("$highNegative $lowNegative")
            }
        }


    }






    outputWriter.close()
    bufferedReader.close()
}


