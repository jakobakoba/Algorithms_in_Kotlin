package yandex.yandex_1_training.yandex_1_training_8_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    class TreeNode(val value: Int){
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

        fun findSecond(): Int {

            var cur: TreeNode? = this
            var parent: TreeNode? = null

            while(cur?.right != null){
                parent = cur
                cur = cur.right
            }

            if (cur?.left != null){
                var secondLargest = cur.left
                while(secondLargest?.right != null){
                    secondLargest = secondLargest.right
                }
                return secondLargest!!.value
            }
            return parent!!.value
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

    outputWriter.println(node.findSecond())



}