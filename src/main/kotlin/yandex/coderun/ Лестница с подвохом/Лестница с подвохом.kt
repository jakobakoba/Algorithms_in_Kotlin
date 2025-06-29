package yandex.coderun.` Лестница с подвохом`

fun main(){
    fun solution(n: Int, a: IntArray): IntArray {
        val result = IntArray(n + 1)

        val dp = Array(n) { BooleanArray(2) }
        val parent = Array(n) { IntArray(2) { -1 } }

        dp[0][0] = true
        dp[0][1] = true

        for (i in 1 until n) {
            for (sign in 0..1) {
                val currentValue = if (sign == 0) a[i] else -a[i]
                dp[i][sign] = false

                if (dp[i - 1][0] && a[i - 1] <= currentValue) {
                    dp[i][sign] = true
                    parent[i][sign] = 0
                }
                if (!dp[i][sign] && dp[i - 1][1] && -a[i - 1] <= currentValue) {
                    dp[i][sign] = true
                    parent[i][sign] = 1
                }
            }
        }

        val lastSign = when {
            dp[n - 1][0] -> 0
            dp[n - 1][1] -> 1
            else -> -1
        }

        if (lastSign == -1) {
            result[0] = 0
            return result
        }

        result[0] = 1

        val signs = IntArray(n)
        var currentIndex = n - 1
        var currentSign = lastSign
        while (currentIndex >= 0) {
            signs[currentIndex] = currentSign
            if (currentIndex == 0) break
            currentSign = parent[currentIndex][currentSign]
            currentIndex--
        }

        for (i in 0 until n) {
            result[i + 1] = if (signs[i] == 0) a[i] else -a[i]
        }

        return result
    }
}