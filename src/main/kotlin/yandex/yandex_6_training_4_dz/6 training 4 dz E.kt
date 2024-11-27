package yandex.yandex_6_training_4_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val lines = bufferedReader.lineSequence().toList()

    val n = lines.first().toInt()

    val map = mutableMapOf<Int, MutableList<Int>>()
    val children = Array(n + 1){-1}

    lines.subList(1, n).forEach { line ->
        val (a, b) = line.split(" ").map { it.toInt() }
        map.getOrPut(a){ mutableListOf() }.add(b)
        map.getOrPut(b){ mutableListOf() }.add(a)
    }
    fun countDesc(num: Int): Int {
        children[num] = 1
        for (child in map[num]!!){
            if (children[child] == -1){
                children[num] = children[num] + countDesc(child)
            }
        }
        return children[num]
    }

    countDesc(1)

    val ans = StringBuilder()
    for(i in 1 until children.size){
        ans.append("${children[i]} ")
    }
    outputWriter.println(ans.trim().toString())

}