package yandex.yandex_7_training.yandex_7_training_2_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    var padded = 1
    while(padded < n){
        padded *= 2
    }
    val treeSize = padded * 2

    val nums = reader.readLine().split(" ").map{it.toInt()}
    val m = reader.readLine().toInt()

    val tree = Array(treeSize){0L}

    fun push (v: Int) {
        if (tree[v] == 0L) return

        if (2 * v < treeSize){
            tree[2 * v] += tree[v]
        }
        if (2 * v + 1 < treeSize){
            tree[2 * v + 1] += tree[v]
        }
        tree[v] = 0L
    }

    fun getValue(v: Int, tl: Int, tr: Int, target: Int): Long {
        if (tl == tr){
            if (tl < n){
                return nums[tl].toLong() + tree[v]
            } else {
                return tree[v]
            }
        }
        push(v)

        val tm = tl + (tr - tl )  / 2
        return if (target <= tm){
            getValue(2 * v, tl, tm, target)
        } else {
            getValue(2 * v + 1, tm + 1, tr, target)
        }
    }
    fun addRange(v: Int, tl: Int, tr: Int, l: Int, r: Int, value: Long){
        if (tl > r || tr < l){
            return
        }
        if (tl >= l && tr <= r){
            tree[v] += value
            return
        }
        push(v)

        val tm = tl + (tr - tl) / 2
        addRange(2 * v, tl, tm, l, r, value)
        addRange(2 * v + 1, tm + 1, tr, l, r, value)
    }

    val result = StringBuilder()

    repeat(m){
        val str = reader.readLine().split(" ")
        when(str[0][0]){
            'g' -> {
                val index = str[1].toInt()
                val value = getValue(1, 0, padded - 1, index - 1)
                result.append(value).append("\n")
            }
            'a' -> {
                val left = str[1].toInt()
                val right = str[2].toInt()
                val number = str[3].toLong()

                addRange(1, 0, padded - 1, left - 1, right - 1, number)
            }
        }
    }
    println(result.toString())
}