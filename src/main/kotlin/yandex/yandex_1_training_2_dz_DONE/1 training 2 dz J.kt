package yandex.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter
import kotlin.math.abs
import kotlin.math.pow

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val n = bufferedReader.readLine()?.toInt() ?: break
        var left = 30.0
        var right = 4000.0
        var prev = bufferedReader.readLine().toFloat()
        for(i in 0 until n - 1){
            val (f, s) = bufferedReader.readLine().split(" ")
            val now = f.toFloat()
            if(abs(now - prev) < 10.0.pow(-6)){
                continue
            }

            if( s == "closer"){
                if (now > prev){
                    left = maxOf(left, (now + prev) / 2.0)
                } else {
                    right = minOf(right, (now + prev) / 2.0)
                }
            } else {
                if (now < prev){
                    left = maxOf(left, (now + prev)/ 2.0)
                } else {
                    right = minOf(right, (now + prev)/ 2.0)
                }
            }
            prev = now
        }

        outputWriter.println("$left $right")

    }

    outputWriter.close()
    bufferedReader.close()
}


