package yandex.yandex_7_training.yandex_7_training_razminka

fun main() {
    val n = readln().toInt()
    val prices = List(n) { readln().toInt() }
    val INF = Int.MAX_VALUE / 2
    val dp = Array(n + 1) { IntArray(n + 1) { INF } }
    val coupons = Array(n + 1) { IntArray(n + 1) { 0 } }

    dp[0][0] = 0

    for (i in 1..n) {
        val price = prices[i - 1]
        for (j in n downTo 0) {
            if (dp[i - 1][j] == INF) continue

            if (price > 100) {
                if (j + 1 <= n) {
                    if (dp[i][j + 1] > dp[i - 1][j] + price) {
                        dp[i][j + 1] = dp[i - 1][j] + price
                        coupons[i][j + 1] = coupons[i - 1][j]
                    }
                }
            } else {
                if (dp[i][j] > dp[i - 1][j] + price) {
                    dp[i][j] = dp[i - 1][j] + price
                    coupons[i][j] = coupons[i - 1][j]
                }
            }

            if (j >= 1) {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    dp[i][j - 1] = dp[i - 1][j]
                    coupons[i][j - 1] = coupons[i - 1][j] + 1
                }
            }
        }
    }

    var minCost = INF
    var maxUnused = 0
    var used = 0
    var bestJ = 0

    for (j in 0..n) {
        if (dp[n][j] < minCost || (dp[n][j] == minCost && j > maxUnused)) {
            minCost = dp[n][j]
            maxUnused = j
            used = coupons[n][j]
            bestJ = j
        }
    }

    println(minCost)
    println("$maxUnused $used")

    val days = mutableListOf<Int>()
    var remaining = bestJ

    for (i in n downTo 1) {
        val currentJ = remaining
        val price = prices[i - 1]
        val possibleBeforeUse = currentJ + 1
        if (possibleBeforeUse <= n &&
            dp[i][currentJ] == dp[i - 1][possibleBeforeUse] &&
            coupons[i][currentJ] == coupons[i - 1][possibleBeforeUse] + 1) {
            days.add(i)
            remaining = possibleBeforeUse
        } else {
            remaining = if (price > 100 && currentJ > 0) currentJ - 1 else currentJ
        }
    }

    days.sort()
    days.forEach { println(it) }
}