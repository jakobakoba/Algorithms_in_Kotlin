package yandex.yandex_7_training.yandex_7_training_2_dz

import java.io.BufferedReader
import java.io.InputStreamReader



fun main(){

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = reader.readLine().trim().split(" ").map{it.toInt()}

    var padded = 1
    while(padded < n){
        padded *= 2
    }
    val treeSize = padded * 2

    val nums = reader.readLine().trim().split(" ").map { it.toInt() }

    val derevo = Array(treeSize){Int.MIN_VALUE}
    for (i in 0 until n){
        derevo[padded + i] = nums[i]
    }

    for (i in padded - 1 downTo 1){
        derevo[i] = maxOf(derevo[2 * i], derevo[2 * i + 1])
    }
    val result = StringBuilder()

    fun update(index: Int, newValue: Int){
        var curIdx = index - 1 + padded

        derevo[curIdx] = newValue

        while(curIdx > 1){
            curIdx /= 2

            derevo[curIdx] = maxOf(derevo[curIdx * 2], derevo[curIdx * 2 + 1])
        }
    }

    fun find(v: Int, tl: Int, tr: Int, queryIdx: Int, x: Int): Int {
        if (derevo[v] < x){
            return -1
        }

        if (tr < queryIdx){
            return -1
        }

        if (tl == tr){
            return tl
        }

        val tm = tl + (tr - tl) / 2
        val leftResult = find(2 * v, tl, tm, queryIdx, x)
        if (leftResult != -1){
            return leftResult
        }

        val rightResult = find(2 * v + 1, tm + 1, tr, queryIdx, x)
        return rightResult
    }

    repeat(m){
        val str = reader.readLine().trim().split(" ")
        val command = str[0][0].toString().toInt()
        val first = str[1].toInt()
        val second = str[2].toInt()

        when (command){
            0 -> {
                val index = first
                val newValue = second
                update(index, newValue)
            }
            1 -> {
                val queryIndex1 = first
                val threshold = second

                val query0 = queryIndex1 - 1
                val found = find(1, 0, padded - 1, query0, threshold)

                val output = if(found != -1){
                    found + 1
                } else {
                    -1
                }
                result.append(output).append("\n")
            }
        }
    }
    println(result.toString().trim())
}