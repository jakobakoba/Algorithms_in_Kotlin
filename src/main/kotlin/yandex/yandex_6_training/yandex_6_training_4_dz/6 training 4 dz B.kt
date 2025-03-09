package yandex.yandex_6_training.yandex_6_training_4_dz

import java.io.File
import java.io.PrintWriter

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)

    val s = bufferedReader.lineSequence().toList()

    val n = s[0].toInt()

    val children = mutableMapOf<String, MutableList<String>>()
    val count = mutableMapOf<String, Int>()

    s.subList(1,n).forEach { line ->
        val (child, parent) = line.split(" ")
        children.getOrPut(parent){ mutableListOf() }.add(child)
        count[child] = -1
        count[parent] = -1
    }
    fun calculateCount(name: String): Int {
        if (count[name] == -1){
            count[name] = 0
            if (name in children){
                for(child in children[name]!!){
                    count[name] = count[name]!! + calculateCount(child) + 1
                }
            }
        }
        return count[name]!!
    }
    for (name in children.keys){
        calculateCount(name)
    }

    val sortedCount = count.toSortedMap()

    sortedCount.forEach{(key, value) ->
        outputWriter.println("$key $value")
    }

}

