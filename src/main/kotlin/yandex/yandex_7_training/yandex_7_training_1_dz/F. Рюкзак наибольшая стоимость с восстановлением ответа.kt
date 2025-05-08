package yandex.yandex_7_training.yandex_7_training_1_dz

fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val weights = readln().trim().split(" ").map { it.toInt() }
    val costs = readln().trim().split(" ").map { it.toInt() }

    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in 1..n) {
        for (w in 0..m) {
            dp[i][w] = dp[i - 1][w]
            if (w >= weights[i - 1]) {
                dp[i][w] = maxOf(
                    dp[i][w],
                    dp[i - 1][w - weights[i - 1]] + costs[i - 1]
                )
            }
        }
    }

    var resWeight = m
    val result = mutableListOf<Int>()
    for (i in n downTo 1) {
        if (dp[i][resWeight] != dp[i - 1][resWeight]) {
            result.add(i)
            resWeight -= weights[i - 1]
        }
    }

    result.reverse()
    result.forEach { println(it) }
}