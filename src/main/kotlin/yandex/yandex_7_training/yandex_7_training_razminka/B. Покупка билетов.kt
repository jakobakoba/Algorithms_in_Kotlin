package yandex.yandex_7_training.yandex_7_training_razminka

//B. Покупка билетов

fun main(){
    val n = readln().toInt()
    val a = IntArray(n + 1)
    val b = IntArray(n + 1)
    val c = IntArray(n + 1)

    for (i in 1 .. n){
        val (ai, bi, ci) = readln().trim().split(" ").map{it.toInt()}
        a[i] = ai
        b[i] = bi
        c[i] = ci
    }

    val dp = LongArray(n + 1){Long.MAX_VALUE}
    dp[0] = 0

    for (i in 1 .. n){
        dp[i] = dp[i-1] + a[i]

        if (i >= 2){
            dp[i] = minOf(dp[i], dp[i-2] + b[i-1])
        }
        if (i >= 3){
            dp[i] = minOf(dp[i], dp[i-3] + c[i-2])
        }
    }
    println(dp[n])
}