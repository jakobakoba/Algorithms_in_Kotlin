package yandex.yandex_6_training.yandex_6_training_4_dz

import java.io.File
import java.io.PrintWriter

fun main() {
    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)

    val s = bufferedReader.lineSequence().toList()

    val tree = mutableListOf<Any>()

    fun add(tree: MutableList<Any>, param: Int): Boolean {
        var subtree = tree
        while (subtree.isNotEmpty()) {
            val value = subtree[0] as Int
            if (param == value) return false
            subtree = if (param < value) {
                subtree[1] as MutableList<Any>
            } else {
                subtree[2] as MutableList<Any>
            }
        }
        subtree.add(param)
        subtree.add(mutableListOf<Any>())
        subtree.add(mutableListOf<Any>())
        return true
    }

    fun search(tree: MutableList<Any>, param: Int): Boolean {
        var subtree = tree
        while (subtree.isNotEmpty()) {
            val value = subtree[0] as Int
            if (param == value) return true
            subtree = if (param < value) {
                subtree[1] as MutableList<Any>
            } else {
                subtree[2] as MutableList<Any>
            }
        }
        return false
    }

    fun printTree(tree: MutableList<Any>, depth: Int) {
        if (tree.isNotEmpty()) {
            printTree(tree[1] as MutableList<Any>, depth + 1)
            outputWriter.println(".".repeat(depth) + (tree[0] as Int))
            printTree(tree[2] as MutableList<Any>, depth + 1)
        }
    }

    s.forEach { line ->
        if (line == "PRINTTREE") {
            printTree(tree, 0)
        } else {
            val (command, param) = line.split(" ")
            val parameter = param.toInt()

            when (command) {
                "ADD" -> {
                    if (add(tree, parameter)) {
                        outputWriter.println("DONE")
                    } else {
                        outputWriter.println("ALREADY")
                    }
                }
                "SEARCH" -> {
                    if (search(tree, parameter)) {
                        outputWriter.println("YES")
                    } else {
                        outputWriter.println("NO")
                    }
                }
            }
        }
    }
}
