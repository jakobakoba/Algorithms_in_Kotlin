package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    var num = reader.readLine().toLong()

    var count = 0

    while(num > 0){
        if((num and 1L) == 1L){
            count++
        }

        num = num ushr 1
    }
    println(count)
}