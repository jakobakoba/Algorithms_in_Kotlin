package advent_of_code.day02

import java.io.File
import kotlin.math.abs

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()

    val s = bufferedReader.lineSequence().toList()

    var safe = 0

    for (i in 0 until s.size){
        if (s[i].isBlank()){
            break
        }
        val report = s[i].split(" ").filter{it.isNotBlank()}.map { it.toInt() }
        var (increasing, decreasing) = check(report)
        if (increasing || decreasing) {
            safe++
        } else {
            for (i in 0 until report.size){
                var report2 = report.toMutableList()
                report2.removeAt(i)
                var (increasing2, decreasing2) = check(report2)
                if (increasing2 || decreasing2) {
                    safe++
                    break
                }
            }
        }
    }
    println(safe)
}

private fun check(report: List<Int>): Pair<Boolean, Boolean> {
    var increasing = true
    var decreasing = true
    for (j in 1 until report.size) {
        if (abs(report[j - 1] - report[j]) !in 1..3) {
            increasing = false
            decreasing = false
            break
        }
        if (report[j - 1] == report[j]) {
            increasing = false
            decreasing = false
            break
        }
        if (report[j - 1] > report[j]) {
            // this is decreasing s
            increasing = false
        }
        if (report[j - 1] < report[j]) {
            // this is increasing s
            decreasing = false
        }
    }
    return Pair(increasing, decreasing)
}