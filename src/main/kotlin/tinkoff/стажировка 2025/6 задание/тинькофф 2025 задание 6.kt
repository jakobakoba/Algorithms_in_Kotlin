package tinkoff.`стажировка 2025`.`6 задание`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val a = reader.readLine().trim().split(" ").map { it.toInt() }.sorted()

    var sum = 0L
    for (i in 0 until n / 2) {
        sum += a[n - 1 - i] - a[i]
    }

    println(sum)
}