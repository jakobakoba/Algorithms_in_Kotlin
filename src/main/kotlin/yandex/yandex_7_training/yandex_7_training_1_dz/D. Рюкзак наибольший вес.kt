package yandex.yandex_7_training.yandex_7_training_1_dz

fun main(){
    val (n, m) = readln().trim().split(" ").map{it.toInt()}
    val slitki = readln().trim().split(" ").map{it.toInt()}

    val dp = BooleanArray(m + 1)
    dp[0] = true

    for (num in slitki){
        for (i in dp.size - 1 downTo 0){
            if (dp[i] && i + num <= m){
                dp[i + num] = true
            }
        }
    }
    for (i in dp.size - 1 downTo 0){
        if (dp[i]){
            println(i)
            break
        }
    }
}