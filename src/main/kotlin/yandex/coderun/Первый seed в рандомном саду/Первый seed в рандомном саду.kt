package yandex.coderun.`Первый seed в рандомном саду`

fun main(){



    val MOD = 1_000_000_000L - 7538L
    val memo = mutableMapOf<Long, Long>()

    fun power(base: Long, exp: Long, mod: Long): Long {
        var res = 1L
        var b = base % mod
        var e = exp

        if (b < 0) b += mod

        while (e > 0) {
            if (e % 2 == 1L) {
                res = (res * b) % mod
            }
            b = (b * b) % mod
            e /= 2
        }
        return res
    }

    fun solution(n: Long): Long {
        if (n == 0L) {
            return 1L
        }

        if (memo.containsKey(n)) {
            return memo[n]!!
        }

        val an2 = solution(n / 2)
        val an3 = solution(n / 3)
        val an4 = solution(n / 4)

        val term1 = power(an2, an3, MOD)
        val term2 = (5L * an4) % MOD

        var result = (term1 + term2 + n % MOD) % MOD

        if (result < 0) {
            result += MOD
        }

        memo[n] = result

        return result
    }


    println(solution(1))
    println(solution(5))
    println(solution(100))
}