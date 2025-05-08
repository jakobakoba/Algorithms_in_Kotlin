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

    val nums = reader.readLine().trim().split(" ").map { it.toInt() }

    val p = reader.readLine().toInt()

    val derevo = Array(treeSize){0}
    for (i in 0 until n){
        if (nums[i] == 0){
            derevo[padded + i] = 1
        }
    }

    for (i in padded - 1 downTo 1){
        derevo[i] = derevo[2 * i] + derevo[2 * i + 1]
    }
    val result = StringBuilder()

    fun queryZerosInternal(l: Int, r: Int): Int {
        if (l > r) return 0
        var left = l + padded
        var right = r + padded

        var sum = 0
        while(left <= right){
            if (left % 2 == 1){
                sum += derevo[left]
                left++
            }
            if (right % 2 == 0){
                sum += derevo[right]
                right--
            }
            left /= 2
            right /= 2
        }
        return sum
    }

    fun queryZeros(l: Int, r: Int): Int {
        val queryL = maxOf(1, l)
        val queryR = minOf(n, r)

        if (queryL > queryR){
            return 0
        }
        return queryZerosInternal(queryL - 1, queryR - 1)
    }

    fun findKRecursive(v: Int, tl: Int, tr: Int, k: Int): Int {
        if (tl == tr){
            return if (derevo[v] == 1 && k == 1 && tl < n){
                tl
            } else {
                -1
            }
        }

        val tm = tl + (tr - tl) / 2
        val leftChild = 2 * v
        val zerosInLeft = derevo[leftChild]

        return if (k <= zerosInLeft){
            findKRecursive(leftChild, tl, tm, k)
        } else {
            findKRecursive(leftChild + 1, tm + 1, tr, k - zerosInLeft)
        }
    }

    fun findK(k: Int): Int {
        if (k > derevo[1]){
            return -1
        }

        val index0 = findKRecursive(1, 0, padded - 1, k)
        return if (index0 != -1) index0 + 1 else -1
    }


    fun update(index: Int, newValue: Int){
        var curIdx = index - 1 + padded

        derevo[curIdx] = if (newValue == 0) 1 else 0

        while(curIdx > 1){
            curIdx /= 2

            derevo[curIdx] = derevo[curIdx * 2] + derevo[curIdx * 2 + 1]
        }
    }

    repeat(p){
        val str = reader.readLine().trim().split(" ")
        val command = str[0][0]

        when (command){
            's' -> {
                val left = str[1].toInt()
                val right = str[2].toInt()
                val k = str[3].toInt()

                val zerosBeforeL = queryZeros(1, left - 1)
                val totalZeros = queryZeros(left, right)

                if (k > totalZeros){
                    result.append("-1 ")
                } else {
                    val globalK = zerosBeforeL + k
                    val index = findK(globalK)
                    result.append("$index ")
                }
            }
            'u' -> {
                val index = str[1].toInt()
                val newValue = str[2].toInt()
                update(index, newValue)
            }
        }
    }
    println(result.toString().trim())
}