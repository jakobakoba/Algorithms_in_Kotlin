package yandex.yandex_7_training.yandex_7_training_1_dz

fun main(){
    val (n, m) = readln().trim().split(" ").map{it.toInt()}

    val weights = readln().trim().split(" ").map{it.toInt()}
    val costs = readln().trim().split(" ").map{it.toInt()}

    val dp = IntArray(m + 1){-1}
    dp[0] = 0

    for (i in 0 until n){
        val weight = weights[i]
        val cost = costs[i]
        for (j in m downTo weight){
            if (dp[j - weight] != -1){
                dp[j] = maxOf(dp[j], dp[j - weight] + cost)
            }
        }
    }

    println(dp.max())
}