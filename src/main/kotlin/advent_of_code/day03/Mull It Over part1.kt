package advent_of_code.day03

import java.io.File
import java.io.PrintWriter

import kotlin.math.abs

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()

    val s = bufferedReader.lineSequence().toList()


    var answer = 0L
    // () is used for grouping in regex
    // \(  and \) are literal parentheses
    // \d matches any digit 0-9
    // {1,3} matches 1 to 3 repetitions of the precending pattern
    val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

    for (i in 0 until s.size){
        if (s[i].isBlank()){
            break
        }

        val matches = regex.findAll(s[i])
        for(match in matches){
            val x = match.groupValues[1].toLong()
            val y = match.groupValues[2].toLong()
            answer += x * y
        }
    }
    println(answer)
}