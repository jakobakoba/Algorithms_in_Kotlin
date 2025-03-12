package yandex.yandex_7_training.yandex_7_training_razminka

fun main(){
    val (n, m) = readln().split(" ").map{it.toInt()}

    val input = mutableListOf<List<Int>>()

    repeat(n){
        input.add(readln().trim().split(" ").map{it.toInt()})
    }

    val dp = Array(n){IntArray(m){0} }
    dp[0][0] = input[0][0]

    for (i in 1 until m){
        dp[0][i] = dp[0][i - 1] + input[0][i]
    }

    for (i in 1 until n){
        dp[i][0] = dp[i - 1][0] + input[i][0]
    }

    for (i in 1 until n){
        for (j in 1 until m){
            dp[i][j] = input[i][j] + maxOf(dp[i-1][j], dp[i][j - 1])
        }
    }
    val max = dp[n-1][m-1]

    val path = mutableListOf<Char>()
    var i = n - 1
    var j = m - 1

    while(i > 0 || j > 0){
        if (i == 0){
            path.add('R')
            j--
        } else if (j == 0){
            path.add('D')
            i--
        } else {
            if (dp[i-1][j] > dp[i][j-1]){
                path.add('D')
                i--
            } else {
                path.add('R')
                j--
            }
        }
    }
    val route = path.reversed().joinToString(" ")
    println(max)
    println(route)
}

