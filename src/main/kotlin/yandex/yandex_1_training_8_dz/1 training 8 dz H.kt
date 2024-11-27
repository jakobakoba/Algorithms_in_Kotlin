package yandex.yandex_1_training_8_dz

import java.io.File
import java.io.PrintWriter
import kotlin.math.abs


fun main(){

    data class TreeNode(val value: Int){
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

        fun isBalanced(): Pair<Boolean, Int>{
            val (leftBalanced, leftHeight) = left?.isBalanced() ?: Pair(true, 0)
            val (rightBalanced, rightHeight) = right?.isBalanced() ?: Pair(true, 0)

            val balanced = leftBalanced && rightBalanced && abs(leftHeight - rightHeight) <= 1
            val height = maxOf(leftHeight, rightHeight) + 1

            return Pair(balanced, height)


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

    val (isBalanced, _) =  node.isBalanced()
    outputWriter.println(if (isBalanced) "YES" else "NO")

}