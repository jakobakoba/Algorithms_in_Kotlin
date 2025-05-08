package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    val a = IntArray(n + 1)
    for (i in 1 .. n){
        a[i] = reader.readLine().toInt()
    }

    val visited = BooleanArray(n + 1)
    var count = 0

    for (i in 1 .. n){
        if (!visited[i]){
            val path = mutableListOf<Int>()
            val indexMap = mutableMapOf<Int,Int>()
            var current = i
            while(true){
                if (visited[current]){
                    val cycle = indexMap[current]
                    if (cycle != null){
                        count++
                        for (j in cycle until path.size){
                            visited[path[j]] = true
                        }
                    }
                    break
                }
                visited[current] = true
                indexMap[current] = path.size
                path.add(current)
                current = a[current]
            }
        }
    }
    println(count)
}