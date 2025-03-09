package yandex.yandex_1_training.yandex_1_training_8_dz

import java.io.File
import java.io.PrintWriter


fun main(){


    data class TreeNode(var value: Int){
        var left : TreeNode? = null
        var right: TreeNode? = null

        fun insert(newValue: Int){
            if (newValue == 0) return

            if (newValue < value){
                if (left == null){
                    left = TreeNode(newValue)
                } else {
                    left!!.insert(newValue)
                }
            } else if (newValue > value){
                if (right == null){
                    right = TreeNode(newValue)
                } else {
                    right!!.insert(newValue)
                }
            }
        }

        fun traverse(list: MutableList<Int>){
            left?.traverse(list)

            if ((left != null && right == null) || (left == null && right != null)){
                list.add(value)
            }

            right?.traverse(list)
        }


    }

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val s = bufferedReader.readLine().split(" ").map { it.toInt() }

    val node = TreeNode(s[0])

    for (i in 1 until s.size){
        node.insert(s[i])
    }
    val ans = mutableListOf<Int>()

    node.traverse( ans)

    ans.forEach { outputWriter.println(it)}

}