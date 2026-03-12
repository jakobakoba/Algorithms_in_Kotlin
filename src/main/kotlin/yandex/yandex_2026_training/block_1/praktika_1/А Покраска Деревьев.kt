package main.kotlin.yandex.yandex_2026_training.block_1.praktika_1

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    /*
    Пример ввода и вывода числа n, где -10^9 < n < 10^9:
    val n = readln().toInt()
    println(n)
    */

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (p, v) = reader.readLine().trim().split(" ").map{it.toInt()}
    val (q, m) = reader.readLine().trim().split(" ").map{it.toInt()}

    val interval1 = Pair(p - v, p + v)
    val interval2 = Pair(q - m, q + m)

    val list = mutableListOf<Pair<Int,Int>>()
    list.add(interval1)
    list.add(interval2)

    list.sortBy{it.first}
    var ans = 0
    for (i in 0 until 2 ){
        if (i == 0){
            ans += abs(list[i].second - list[i].first) + 1
        }
        if (i == 1){
            if (list[i].first <= list[0].second && list[i].second > list[0].second){
                ans += abs(list[i].second - list[0].second)
            } else if (list[0].second < list[i].first){
                ans += abs(list[i].second - list[i].first) + 1
            }
        }
    }
    println(ans)
}