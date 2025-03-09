package yandex.yandex_1_training.yandex_1_training_8_dz

import java.io.File
import java.io.PrintWriter

fun main(){
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val n = bufferedReader.readLine().toInt()
    val map = mutableMapOf<String, String>()
    repeat(n - 1){
        val (child, parent) = bufferedReader.readLine().split(" ")
        map[child] = parent
    }

    val cache = mutableMapOf<String, Int>()

    fun count(node: String): Int {

        if (node !in map) return 0

        if (cache.containsKey(node)){
            return cache[node]!!
        }

        val height = count(map[node]!!)  + 1
        cache[node] = height
        return height
    }

    val allElements = (map.keys + map.values).toSortedSet()
    for (element in allElements){
        count(element)
    }

    for (element in allElements){
        outputWriter.println("$element ${cache[element] ?: 0}")
    }

}