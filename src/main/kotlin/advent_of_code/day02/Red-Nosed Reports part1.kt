package advent_of_code.day02

import java.io.File
import java.io.PrintWriter

import kotlin.math.abs

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)



    val s = bufferedReader.lineSequence().toList()

    val differences = mutableListOf<Int>()

    var safe = 0

    for (i in 0 until s.size){
        if (s[i].isBlank()){
            break
        }
        val report = s[i].split(" ").filter{it.isNotBlank()}.map { it.toInt() }
        var increasing = true
        var decreasing = true
        for (j in 1 until report.size){
            if (abs(report[j-1] - report[j]) !in 1..3){
                increasing = false
                decreasing = false
                break
            }
            if (report[j-1] == report[j]){
                increasing = false
                decreasing = false
                break
            }
            if (report[j-1] > report[j]){
                // this is decreasing s
                increasing = false
            }
            if (report[j-1] < report[j]){
                // this is increasing s
                decreasing = false
            }
        }
        if (increasing || decreasing) {
            safe++
        }
    }


    println(safe)


}