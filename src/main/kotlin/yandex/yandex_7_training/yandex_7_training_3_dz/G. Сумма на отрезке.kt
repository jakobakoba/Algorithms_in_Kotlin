package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = reader.readLine().trim().split(" ").map{it.toInt()}

    val size = n
    val bit = LongArray(n + 1)

    fun update(index: Int, delta: Long) {
        var i = index
        while( i <= size){
            bit[i] += delta
            i += i and -i
        }
    }

    fun query(index: Int): Long {
        var i = index
        var sum = 0L
        while(i > 0){
            sum += bit[i]
            i -= i and -i
        }
        return sum
    }
    val actual = LongArray(n + 1)
    val ans = StringBuilder()

    repeat(k){
        val (command, first, second) = reader.readLine().trim().split(" ")

        when(command){
            "A" -> {
                val position = first.toInt()
                val num = second.toLong()

                val delta = num - actual[position]
                update(position, delta)
                actual[position] = num
            }
            "Q" -> {
                val left = first.toInt()
                val right = second.toInt()

                val sum = query(right) - query(left  - 1)
                ans.append("$sum\n")
            }
        }
    }
    println(ans)
}