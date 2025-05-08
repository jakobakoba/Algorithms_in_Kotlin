package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val total  = LongArray(n + 1)
    val top     = LongArray(n + 1)
    val parent = IntArray(n + 1)

    total[0]  = 0L
    top[0]    = 0L
    parent[0] = -1

    for (i in 1..n) {
        val (t, m) = reader.readLine().split(" ").map { it.toInt() }
        if (m != 0) {
            total[i]  = total[t] + m.toLong()
            top[i]    = m.toLong()
            parent[i] = t
        } else {
            val p = parent[t]
            total[i]  = total[t] - top[t]
            top[i]    = if (p != -1) top[p] else 0L
            parent[i] = if (p != -1) parent[p] else -1
        }
    }

    var sum = 0L
    for (i in 1..n) {
        sum += total[i]
    }

    println(sum)
}
