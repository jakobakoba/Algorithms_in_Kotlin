package yandex_6_training_1_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val x1= bufferedReader.readLine()?.toInt() ?: break
        val y1= bufferedReader.readLine().toInt()
        val x2= bufferedReader.readLine().toInt()
        val y2= bufferedReader.readLine().toInt()
        val x= bufferedReader.readLine().toInt()
        val y= bufferedReader.readLine().toInt()
        var ans = ""

        if (x < x1 && y > y2){
            ans = "NW"
        } else if (x1 < x  && x < x2 && y > y2){
            ans = "N"
        } else if (x > x2 && y > y2){
            ans = "NE"
        } else if (x > x2 && y1 < y && y < y2){
            ans = "E"
        } else if (x > x2 && y < y2){
            ans = "SE"
        } else if (x1 < x && x < x2 && y < y1){
            ans = "S"
        } else if (x < x1 && y < y1){
            ans = "SW"
        } else {
            ans = "W"
        }

        outputWriter.println(ans)







    }

    outputWriter.close()
    bufferedReader.close()
}


