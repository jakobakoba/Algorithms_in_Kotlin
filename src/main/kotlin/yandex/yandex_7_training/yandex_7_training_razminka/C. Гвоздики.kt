package yandex.yandex_7_training.yandex_7_training_razminka

fun main() {
    val n = readln().toInt()
    val nums = readln().trim().split(" ").map { it.toInt() }.toIntArray()
    nums.sort()

    val dp = IntArray(n)
    dp[0] = Int.MAX_VALUE / 2
    dp[1] = nums[1] - nums[0]

    for (i in 2 until n) {
        dp[i] = minOf(
            dp[i - 1] + (nums[i] - nums[i - 1]),
            dp[i - 2] + (nums[i] - nums[i - 1])
        )
    }

    println(dp[n - 1])
}
