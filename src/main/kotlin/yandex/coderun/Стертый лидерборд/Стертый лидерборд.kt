package yandex.coderun.`Стертый лидерборд`

fun main(){
    fun solution(n: Int, m: Int, p: IntArray): IntArray {
        val prefix = IntArray(n + 1)
        prefix[0] = 0

        for (i in 1..n) {
            if (p[i - 1] != -1) {
                if (p[i - 1] < prefix[i - 1] + m) {
                    return intArrayOf(-1)
                } else {
                    prefix[i] = p[i - 1]
                }
            } else {
                prefix[i] = prefix[i - 1] + m
            }
        }

        val ans = IntArray(n)
        for (i in 0 until n) {
            ans[i] = prefix[i + 1] - prefix[i]
        }
        return ans
    }
}