package yandex.yandex_1_training.yandex_1_training_8_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    class TreeNode(var value: Int){
        var left: TreeNode? = null
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
    }
    val leaves = mutableListOf<Int>()
    fun findLeaves(node: TreeNode?, leaves: MutableList<Int>){
        if (node == null) return

        if (node.left == null && node.right == null){
            leaves.add(node.value)
            return
        }

        findLeaves(node.left, leaves)
        findLeaves(node.right, leaves)



    }

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val nums = bufferedReader.readLine().split(" ").map { it.toInt() }

    val node = TreeNode(nums[0])

    for (i in 1 until nums.size){
        node.insert(nums[i])
    }
    findLeaves(node, leaves)
    outputWriter.println(leaves.joinToString(" "))


}