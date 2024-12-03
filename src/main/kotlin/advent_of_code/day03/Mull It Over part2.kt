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
    val mul = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
    // \b to ensure we don't catch other words like undo()
    val doRegex = Regex("""\bdo\(\)""")
    val dontRegex = Regex("""\bdon't\(\)""")

    //greenlight should be outside of for loop, because it's all is one input
    var greenLight = true
    for (i in 0 until s.size){
        if (s[i].isBlank()){
            break
        }

        var cur = 0
        while( cur < s[i].length) {
            val doMatch = doRegex.find(s[i], cur)
            val dontMatch = dontRegex.find(s[i], cur)
            val mulMatch = mul.find(s[i], cur)

            // get the closest
            val nextMatch = listOfNotNull(doMatch, dontMatch, mulMatch).minByOrNull { it.range.first }

            if (nextMatch != null){
                when {
                    nextMatch == doMatch -> {
                        greenLight = true
                        cur = nextMatch.range.last + 1
                    }
                    nextMatch == dontMatch -> {
                        greenLight = false
                        cur = nextMatch.range.last + 1
                    }
                    nextMatch == mulMatch -> {
                        if (greenLight){

                            val x = nextMatch.groupValues[1].toLong()
                            val y = nextMatch.groupValues[2].toLong()
                            answer += x * y
                        }
                        cur = nextMatch.range.last + 1
                    }
                }
            }  else {
                break
            }
        }
    }
    println(answer)
}