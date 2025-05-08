package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(" ").map{it.toInt()}

    val rooks = mutableListOf<Triple<Int,Int,Int>>()

    repeat(k){
        val (x,y,z) = reader.readLine().trim().split(" ").map{it.toInt()}
        rooks.add(Triple(x,y,z))
    }


}