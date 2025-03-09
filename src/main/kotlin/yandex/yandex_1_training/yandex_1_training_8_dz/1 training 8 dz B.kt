package yandex.yandex_1_training.yandex_1_training_8_dz

import java.io.File
import java.io.PrintWriter



fun main () {

    class TreeNode(var value: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null

        fun insert(newValue: Int, level: Int, ans: MutableList<Int>){

            if (newValue == 0) return
            if (newValue < value){
                if (left == null){
                    left = TreeNode(newValue)
                    ans.add(level)
                } else {
                    left!!.insert(newValue, level + 1, ans)
                }
            } else if (newValue > value){
                if (right == null){
                    right = TreeNode(newValue)
                    ans.add(level)
                } else {
                    right!!.insert(newValue, level + 1, ans)
                }
            }
        }
    }



    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val nums = bufferedReader.readLine().split(" ").map { it.toInt() }

    val levels = mutableListOf<Int>()
    val node = TreeNode(nums[0])

    levels.add(1)

    for (i in 1 until nums.size){
        node.insert(nums[i], 2, levels)
    }

    outputWriter.println(levels.joinToString(" "))


}
