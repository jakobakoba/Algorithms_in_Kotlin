package yandex.yandex_1_training_8_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null

        fun insert(newValue: Int){
            if (newValue == 0){
                return
            }
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

        fun findHeight(): Int{
            val left = left?.findHeight() ?: 0
            val right = right?.findHeight() ?: 0

            return 1 +  maxOf(left, right)
        }
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

    outputWriter.println(node.findHeight())


}
