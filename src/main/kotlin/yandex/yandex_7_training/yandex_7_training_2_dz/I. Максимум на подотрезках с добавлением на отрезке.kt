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

    val nums = reader.readLine().trim().split(" ").map{it.toInt()}

    val maxTree = LongArray(treeSize){Long.MIN_VALUE}
    for (i in 0 until n){
        maxTree[padded + i] = nums[i].toLong()
    }
    for (i in padded - 1 downTo 1){
        maxTree[i] = maxOf(maxTree[2 * i], maxTree[2 * i + 1])
    }

    val lazyTree = LongArray(treeSize){0L}

    fun push (v: Int){
        if (lazyTree[v] == 0L || v >= padded) return

        val delta = lazyTree[v]
        val leftChild = 2 * v
        val rightChild = 2 * v + 1

        if (leftChild < treeSize){
            lazyTree[leftChild] += delta
            maxTree[leftChild] += delta
        }
        if( rightChild < treeSize){
            lazyTree[rightChild] += delta
            maxTree[rightChild] += delta
        }
        lazyTree[v] = 0L
    }

    fun addRange(v: Int, tl: Int, tr: Int, l: Int, r: Int, value: Long){
        if (tl > r || tr < l){
            return
        }
        if (tl >= l && tr <= r){
            maxTree[v] += value
            lazyTree[v] += value
            return
        }
        push(v)

        val tm = tl + (tr - tl) / 2
        addRange(2 * v, tl, tm, l, r, value)
        addRange(2 * v + 1, tm + 1, tr, l, r, value)

        maxTree[v] = maxOf(maxTree[2 * v], maxTree[2 * v + 1])
    }

    fun find(v: Int, tl: Int, tr: Int, l: Int, r:Int): Long {
        if (tl > r || tr < l){
            return Long.MIN_VALUE
        }

        if (tl >= l && tr <= r){
            return maxTree[v]
        }
        push(v)

        val tm = tl + (tr - tl) / 2
        val leftMax = find(2 * v, tl, tm, l, r)
        val rightMax = find(2 * v + 1, tm + 1, tr, l, r)

        return maxOf(leftMax, rightMax)
    }


    val result = StringBuilder()
    val m = reader.readLine().toInt()
    repeat(m){
        val str = reader.readLine().split(" ")
        when(str[0][0]){
            'm' -> {
                val left = str[1].toInt()
                val right = str[2].toInt()
                val maxVal = find(1, 0, padded - 1, left - 1, right - 1)
                result.append(maxVal).append(" ")
            }
            'a' -> {
                val left = str[1].toInt()
                val right = str[2].toInt()
                val number = str[3].toLong()
                addRange(1, 0, padded- 1, left - 1, right - 1, number)
            }
        }
    }
    println(result.toString().trim())
}