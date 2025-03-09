package yandex.yandex_6_training.yandex_6_training_4_dz

import java.io.File
import java.io.PrintWriter

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)

    val s = bufferedReader.lineSequence().toList()

    val n = s[0].toInt()

    val parents = mutableMapOf<String, String>()

    s.subList(1, n).forEach { line ->
        val (child, parent) = line.split(" ")
        parents[child] = parent
    }

    s.subList(n, s.size).forEach { line ->
        var (name1, name2) = line.split(" ")
        val ancestors = mutableSetOf(name1)
        while(name1 in parents){
            name1 = parents[name1]!!
            ancestors.add(name1)
        }
        while(name2 !in ancestors){
            name2 = parents[name2]!!
        }
        outputWriter.println(name2)
    }
    outputWriter.close()
}