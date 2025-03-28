package yandex.yandex_7_training.yandex_7_training_razminka

//A. Три единицы подряд
//fun main(){
//    val n = readln().toInt()
//    val dp = Array(n + 1){IntArray(3)}
//
//    dp[1][0] = 1
//    dp[1][1] = 1
//    dp[1][2] = 0
//
//    for (i in 2 .. n){
//        dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
//        dp[i][1] = dp[i-1][0]
//        dp[i][2] = dp[i-1][1]
//    }
//
//    val result = dp[n][0] + dp[n][1] + dp[n][2]
//    println(result)
//}

fun main() {
    val n = readln().toInt()

    if (n == 0) {
        println(1)
        return
    }

    var dp0 = 1
    var dp1 = 1
    var dp2 = 0

    for (i in 2..n) {
        val newDp0 = dp0 + dp1 + dp2
        val newDp1 = dp0
        val newDp2 = dp1
        dp0 = newDp0
        dp1 = newDp1
        dp2 = newDp2
    }

    println(dp0 + dp1 + dp2)
}