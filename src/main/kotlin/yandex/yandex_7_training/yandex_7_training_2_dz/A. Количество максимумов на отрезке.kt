package yandex.yandex_7_training.yandex_7_training_2_dz

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(){
    fun combine(a: Pair<Int,Int>, b: Pair<Int,Int>): Pair<Int,Int>{
        return when {
            a.first > b.first -> a
            a.first < b.first -> b
            else -> Pair(a.first, a.second + b.second)
        }
    }

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    var padded = 1
    while(padded < n){
        padded *= 2
    }
    val treeSize = padded * 2

    val nums = reader.readLine().trim().split(" ").map { it.toInt() }

    val k = reader.readLine().toInt()

    val derevo = Array(treeSize){Pair(Int.MIN_VALUE, 0)}
    for (i in 0 until n){
        derevo[padded + i] = Pair(nums[i], 1)
    }

    for (i in padded - 1 downTo 1){
        derevo[i] = combine(derevo[2 * i], derevo[2 * i + 1])
    }
    val result = StringBuilder()

    repeat(k){
        val (left, right) = reader.readLine().trim().split(" ").map{it.toInt()}


        var l = left - 1 + padded
        var r = right - 1 + padded

        var cur = Pair(Int.MIN_VALUE, 0)

        while(l <= r){
            if (l % 2 == 1){
                cur = combine(cur, derevo[l])
                l++
            }
            if (r % 2 == 0){
                cur = combine(cur, derevo[r])
                r--
            }
            l /= 2
            r /= 2
        }
        result.append("${cur.first} ${cur.second}\n")
    }
    println(result.toString())
}