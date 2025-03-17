package yandex.yandex_7_training.yandex_7_training_razminka

import java.io.File
import java.io.PrintWriter

fun main(){
    data class TreeNode(var value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)

    var root: TreeNode? = null


    fun printTree(node: TreeNode?, depth: Int) {
        if (node != null){
            printTree(node.left, depth + 1)
            outputWriter.println(".".repeat(depth) + node.value)
            printTree(node.right, depth + 1)
        }
    }

    fun add(node: TreeNode?, param: Int) : TreeNode {
        if (node == null) return TreeNode(param)

        when {
            param < node.value -> node.left  = add(node.left, param)
            param > node.value -> node.right = add(node.right, param)
        }
        return node
    }

    fun search(node: TreeNode?, param: Int): Boolean {
        return when {
            node == null -> false
            param == node.value -> true
            param < node.value -> search(node.left, param)
            else -> search(node.right, param)
        }
    }


    bufferedReader.lineSequence().forEach{line ->
        if (line == "PRINTTREE"){
            printTree(root, 0)
        } else {
            val (command, param) = line.split(" ")
            val parameter = param.toInt()

            when(command) {
                "ADD" -> {
                    if(!search(root, parameter)){
                        root = add(root, parameter)
                        outputWriter.println("DONE")
                    } else {
                        outputWriter.println("ALREADY")
                    }
                }
                "SEARCH" -> {
                    if(search(root, parameter)){
                        outputWriter.println("YES")
                    } else {
                        outputWriter.println("NO")
                    }
                }
            }
        }
    }
}
