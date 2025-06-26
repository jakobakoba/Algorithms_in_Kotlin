package yandex.coderun.`Добро пожаловать в мир CodeRun`
fun main(){

    fun solve(n: Int, m: Int): Int {
        // your code here

        var left = 1
        var right = 1000000000

        fun helper(k: Int): Boolean {

            val total = k.toLong() * k.toLong()

            if (k % 2 == 0){
                return total / 2 <= n && total / 2 <= m
            } else {
                val white1 = (total + 1) / 2
                val black1 = total / 2
                val white2 = black1
                val black2 = white1
                return (white1 <= n && black1 <= m) || (white2 <= n && black2 <= m)
            }
        }

        while(left < right){
            val mid = left + (right - left + 1) / 2

            if (helper(mid)){
                left = mid
            } else {
                right = mid - 1
            }
        }
        return left
    }
}