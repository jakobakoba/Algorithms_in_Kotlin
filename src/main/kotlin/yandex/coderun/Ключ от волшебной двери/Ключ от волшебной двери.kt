package yandex.coderun.`Ключ от волшебной двери`

fun main(){

    fun solution(n: Int): Long {
        fun sieve(n: Int): List<Int> {
            if (n < 2) return emptyList()
            val isPrime = BooleanArray(n + 1) { true }
            isPrime[0] = false
            isPrime[1] = false
            var i = 2
            while (i * i <= n) {
                if (isPrime[i]) {
                    var j = i * i
                    while (j <= n) {
                        isPrime[j] = false
                        j += i
                    }
                }
                i++
            }
            return (2..n).filter { isPrime[it] }
        }
        if (n < 5) return 0
        val primes = sieve(n)
        var count1 = 0L
        var count3 = 0L
        for (p in primes) {
            if (p == 2) continue
            when (p % 4) {
                1 -> count1++
                3 -> count3++
            }
        }
        return count1 * count3
    }



    println(solution(3))
    println(solution(5))
    println(solution(7))
}