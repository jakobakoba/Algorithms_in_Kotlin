package yandex.yandex_7_training.yandex_7_training_2_dz

import java.io.BufferedReader
import java.io.InputStreamReader



fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    var padded = 1
    while(padded < n){
        padded *= 2
    }
    val treeSize = padded * 2

    val nums = reader.readLine().trim().split(" ").map { it.toInt() }

    val k = reader.readLine().toInt()

    val derevo = Array(treeSize){Int.MIN_VALUE}
    for (i in 0 until n){
        derevo[padded + i] = nums[i]
    }

    for (i in padded - 1 downTo 1){
        derevo[i] = maxOf(derevo[2 * i], derevo[2 * i + 1])
    }
    val result = StringBuilder()

    fun findMax(left: Int, right: Int): Int{
        var l = left - 1 + padded
        var r = right -1 + padded

        var cur = Int.MIN_VALUE

        while(l <= r ){
            if (l % 2 == 1){
                cur = maxOf(cur, derevo[l])
                l++
            }
            if (r % 2 == 0){
                cur = maxOf(cur, derevo[r])
                r--
            }
            l /= 2
            r /= 2
        }
        return cur
    }
    fun update(index: Int, newValue: Int){
        var curIdx = index - 1 + padded

        derevo[curIdx] = newValue

        while(curIdx > 1){
            curIdx /= 2

            derevo[curIdx] = maxOf(derevo[curIdx * 2], derevo[curIdx * 2 + 1])
        }
    }

    repeat(k){
        val str = reader.readLine().trim().split(" ")
        val command = str[0][0]
        val first = str[1].toInt()
        val second = str[2].toInt()

        when (command){
            's' -> {
                val left = first
                val right = second
                val maxVal = findMax(left, right)

                result.append(maxVal).append(" ")
            }
            'u' -> {
                val index = first
                val newValue = second
                update(index, newValue)
            }
        }
    }
    println(result.toString().trim())
}