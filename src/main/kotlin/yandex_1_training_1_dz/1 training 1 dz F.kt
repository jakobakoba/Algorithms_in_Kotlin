package yandex_1_training_1_dz

import java.io.File
import java.io.PrintWriter
import java.util.Scanner

fun main(){

//    val INPUT = File("input.txt").inputStream()
//    val OUTPUT = File("output.txt").outputStream()

//    val bufferedReader = INPUT.bufferedReader()
//    val outputWriter = PrintWriter(OUTPUT, true)


    val scanner = Scanner(System.`in`)
    val (a, b, c, d) = scanner.nextLine().split(" ").map { it.toInt() }

    val combinations = listOf<IntArray>(
        intArrayOf(a + c, maxOf(b, d)),
        intArrayOf(b + d, maxOf(a ,c)),
        intArrayOf(a + d, maxOf(b, c)),
        intArrayOf(b + c, maxOf(a, d))
    )

    val ans = combinations.minBy { it[0] * it[1] }

    if (ans != null){
        println("${ans[0]} ${ans[1]}")
    } else {
        println("")
    }

}