package tinkoff.`стажировка 2025`.`7 задание`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.*

const val MOD = 998244353

fun main() {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    // Генерирует пары (p, q) такие, что p*q = a и gcd(p, q) = 1
    fun getValidPairs(a: Int): List<Pair<Int, Int>> {
        val pairs = mutableListOf<Pair<Int, Int>>()
        for (d in 1..sqrt(a.toDouble()).toInt()) {
            if (a % d == 0) {
                val p = d
                val q = a / d
                if (gcd(p, q) == 1) {
                    pairs.add(p to q)
                    if (p != q) pairs.add(q to p)
                }
            }
        }
        return pairs
    }

    // Возвращает битовую маску для простых множителей числа
    fun getPrimeMask(x: Int, primes: List<Int>): Int {
        var mask = 0
        var num = x
        for ((i, p) in primes.withIndex()) {
            if (num % p == 0) {
                mask = mask or (1 shl i)
                while (num % p == 0) num /= p
            }
        }
        return mask
    }

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()
    val a = reader.readLine().trim().split(" ").map { it.toInt() }

    // Получаем все уникальные простые множители из всех a_i
    val primes = mutableSetOf<Int>()
    for (num in a) {
        var x = num
        for (i in 2..sqrt(x.toDouble()).toInt()) {
            if (x % i == 0) {
                primes.add(i)
                while (x % i == 0) x /= i
            }
        }
        if (x > 1) primes.add(x)
    }
    val primeList = primes.toList()
    val m = primeList.size

    // dp[mask][prod] — количество способов с текущей маской и произведением
    var dp = Array(1 shl m) { mutableMapOf<Int, Long>() }
    dp[0][1] = 1L

    for (num in a) {
        val pairs = getValidPairs(num)
        val newDp = Array(1 shl m) { mutableMapOf<Int, Long>() }

        for (mask in 0 until (1 shl m)) {
            for ((prod, cnt) in dp[mask]) {
                for ((p, q) in pairs) {
                    val newMask = mask or (getPrimeMask(p, primeList) or getPrimeMask(q, primeList))
                    val newProd = (prod.toLong() * p % MOD * q % MOD).toInt()
                    newDp[newMask][newProd] = (newDp[newMask].getOrDefault(newProd, 0L) + cnt) % MOD
                }
            }
        }
        dp = newDp
    }

    var total = 0L
    for ((prod, cnt) in dp[(1 shl m) - 1]) {
        total = (total + cnt) % MOD
    }

    println(total)
}

