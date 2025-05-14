package tinkoff.`стажировка 2025`.`4 задание`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val nums = reader.readLine().trim().split(" ").map { it.toInt() }

    var count = 0L

    for (i in 1 until n - 1) {
        if (nums[i - 1] + nums[i + 1] == 2 * nums[i]) {
            val leftOptions = i
            val rightOptions = n - (i + 1)
            count += leftOptions.toLong() * rightOptions.toLong()
        }
    }

    println(count)
}