package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val players = reader.readLine().trim().split(" ").map{it.toInt()}
    val ans = IntArray(n)

    if (n == 2){
        println(ans.joinToString(" "))
        return
    }
    var active = n

    val prev = IntArray(n){(it - 1 + n) % n }
    val next = IntArray(n){(it + 1) % n}


    val queue: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 0 until n){
        if (players[i] < players[prev[i]] && players[i] < players[next[i]]){
            queue.add(Pair(i, 1))
            ans[i] = 1
        }
    }

    while(queue.isNotEmpty()){
        val(i, round) = queue.poll()
        if (ans[i] != round) continue
        ans[i] = round
        active--
        if (active <= 2) break

        val L = prev[i]
        val R = next[i]
        next[L] = R
        prev[R] = L
        if (ans[L] == 0){
            if (players[L] < players[prev[L]] && players[L] < players[next[L]]){
                ans[L] = round + 1
                queue.add(Pair(L, round + 1))
            }
        }
        if (ans[R] == 0){
            if (players[R] < players[prev[R]] && players[R] < players[next[R]]) {
                ans[R] = round + 1
                queue.add(Pair(R, round + 1))
            }
        }
    }
    println(ans.joinToString(" "))
}