package yandex.yandex_6_training_4_dz

import java.io.File
import java.io.PrintWriter

fun main() {
    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)

    val s = bufferedReader.lineSequence().toList()

    val n = s[0].toInt()

    val parents = mutableMapOf<String, String>()
    val distance = mutableMapOf<String, Int>()

    s.subList(1, n).forEach { line ->
        val (child, parent) = line.split(" ")

        parents[child] = parent
        distance[child] = -1
        distance[parent] = -1
    }

    fun getDistance(name: String): Int {
        if (distance[name] == -1) {
            if (name !in parents) {
                distance[name] = 0
            } else {
                distance[name] = getDistance(parents[name]!!) + 1
            }
        }
        return distance[name]!!
    }

    for ((name, value) in distance) {
        getDistance((name))
    }

    val sortedDistance = distance.toSortedMap()

    for ((value, key) in sortedDistance) {
        outputWriter.println("$value $key")
    }
}

