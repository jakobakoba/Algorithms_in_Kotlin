package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    val apps = mutableListOf<String>()
    repeat(n){
        val str = reader.readLine()
        when(str.substring(0,3)){
            "Run" -> {
                val app = str.trim().split(" ").drop(1).joinToString(" ")
                apps.addFirst(app)
                println(app)
            }
            "Alt" -> {
                val steps = str.trim().split("+").drop(1).size
                val index = steps % apps.size
                val selected = apps.removeAt(index)
                apps.addFirst(selected)
                println(selected)
            }
        }
    }
}