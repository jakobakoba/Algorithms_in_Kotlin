package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (x1, y) = reader.readLine().trim().split(" ").map{it.toLong()}
    val res1 = x1 xor y
    println(res1)

    val (x2, c) = reader.readLine().trim().split(" ").map{it.toLong()}
    val res2 = x2 xor c
    println(res2)


}