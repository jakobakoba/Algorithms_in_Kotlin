package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    val matrix = Array(n){reader.readLine().trim().split(" ").map{it.toInt()}}

    val ans = IntArray(n)

    for (i in 0 until n){
        var cur = 0
        for (j in 0 until n){
            if (i != j){
                cur = cur or matrix[i][j]
            }
        }
        ans[i] = cur
    }

    println(ans.joinToString(" "))
}