package yandex.yandex_1_training.yandex_1_training_8_dz

import java.io.File
import java.io.PrintWriter

fun main() {
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val n = bufferedReader.readLine().toInt()

    val map = mutableMapOf<String, MutableList<String>>()

    repeat(n - 1) {
        val (child, parent) = bufferedReader.readLine().split(" ")
        map.computeIfAbsent(parent) { mutableListOf() }.add(child)
    }

    val cache = mutableMapOf<String, Int>()

    fun count(node: String): Int {
        if (cache.containsKey(node)) return cache[node]!!

        val children = map[node] ?: emptyList()

        val total = children.sumOf { count(it) } + children.size

        cache[node] = total
        return total
    }

    val allNodes = (map.keys + map.values.flatten()).toSortedSet()
    for (node in allNodes){
        count(node)
    }

    for (node in allNodes){
        outputWriter.println("$node ${cache[node] ?: 0}")
    }

}
