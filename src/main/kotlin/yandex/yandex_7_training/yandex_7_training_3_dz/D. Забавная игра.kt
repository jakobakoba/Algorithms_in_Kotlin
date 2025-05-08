package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    if (n == 0){
        println(0)
        return
    }

    var bitCount = 0
    var temp = n

    while(temp > 0){
        temp = temp shr 1
        bitCount++
    }

    val l = bitCount

    var max = n
    var cur = n

    for (i in 1 until l){
        val last = cur and 1
        val rest = cur shr 1

        val shifted = rest or (last shl (l - 1))

        if (shifted > max){
            max = shifted
        }
        cur = shifted
    }

    println(max)

}