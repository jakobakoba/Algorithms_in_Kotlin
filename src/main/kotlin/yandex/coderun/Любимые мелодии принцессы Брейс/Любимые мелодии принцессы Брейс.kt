package yandex.coderun.`Любимые мелодии принцессы Брейс`

fun main(){
    fun solution(n: Int, q: Int, a: LongArray, queries: Array<IntArray>): Long {
        val diff = LongArray(n + 2)
        for (query in queries) {
            val l = query[0] - 1
            val r = query[1]
            diff[l] += 1L
            diff[r] -= 1L
        }
        val freq = LongArray(n)
        var current = 0L
        for (i in 0 until n) {
            current += diff[i]
            freq[i] = current
        }
        freq.sortDescending()
        a.sortDescending()
        var sum = 0L
        for (i in 0 until n) {
            sum += freq[i] * a[i]
        }
        return sum
    }

    println(solution(3, 4, longArrayOf(7,3,1), arrayOf(intArrayOf(1,3), intArrayOf(2,3), intArrayOf(3,3), intArrayOf(2,2))))
    println(solution(4, 4, longArrayOf(1, 100, 10000, 10101010), arrayOf(intArrayOf(1,4), intArrayOf(2,3), intArrayOf(2,2), intArrayOf(1,2))))
}