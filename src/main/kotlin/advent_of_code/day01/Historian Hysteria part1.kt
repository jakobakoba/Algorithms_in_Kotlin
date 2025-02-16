package advent_of_code.day01

import java.io.File
import java.io.PrintWriter

import kotlin.math.abs

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)

    val first = mutableListOf<Int>()
    val second = mutableListOf<Int>()

    val s = bufferedReader.lineSequence().toList()

    val differences = mutableListOf<Int>()

    for (i in 0 until s.size){
        if (s[i].isBlank()){
            break
        }
        val (a, b) = s[i].split(" ").filter{it.isNotBlank()}.map { it.toInt() }

        first.add(a)
        second.add(b)
    }
    first.sort()
    second.sort()

    for (i in 0 until first.size){
        differences.add(abs(first[i] - second[i]))
    }
    println(differences.sum())


}