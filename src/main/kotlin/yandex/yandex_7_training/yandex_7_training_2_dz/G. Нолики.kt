package yandex.yandex_7_training.yandex_7_training_2_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    data class Item(
        val total: Int,
        val prefix: Int,
        val suffix: Int,
        val len: Int,
    )
    val neutral = Item(0,0,0,0)

    fun combine(a: Item, b: Item) : Item {
        if (a == neutral) return b
        if (b == neutral) return a

        val total = maxOf(a.total, b.total, a.suffix + b.prefix)
        val prefix = if (a.prefix == a.len) a.len + b.prefix else a.prefix
        val suffix = if (b.suffix == b.len) a.suffix + b.len else b.suffix
        val len = a.len + b.len
        return Item(total, prefix, suffix, len)
    }

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    var padded = 1
    while(padded < n){
        padded *= 2
    }

    val treeSize = padded * 2
    val nums = reader.readLine().split(" ").map{it.toInt()}
    val tree = Array(treeSize){neutral}
    fun createLeaf(value: Int): Item {
        return if (value == 0){
            Item(total = 1, prefix = 1, suffix = 1, len = 1)
        } else {
            Item(total = 0, prefix = 0, suffix = 0, len = 1)
        }
    }

    fun update(index: Int, newValue: Int){
        var curIdx = index - 1 + padded

        tree[curIdx] = createLeaf(newValue)
        curIdx /= 2

        while(curIdx >= 1){
            tree[curIdx] = combine(tree[curIdx * 2], tree[curIdx * 2 + 1])
            curIdx /= 2
        }
    }
    fun query(left: Int, right: Int): Int {
        var l = left - 1 + padded
        var r = right - 1 + padded

        var leftResult = neutral
        var rightResult = neutral

        while(l <= r){
            if (l % 2 == 1){
                leftResult = combine(leftResult, tree[l])
                l++
            }
            if (r % 2 == 0){
                rightResult = combine(tree[r], rightResult)
                r--
            }
            l /= 2
            r /= 2
        }
        val final = combine(leftResult, rightResult)
        return final.total
    }

    for (i in 0 until n){
        tree[padded + i] = createLeaf(nums[i])
    }
    for (i in padded - 1 downTo 1){
        tree[i] = combine(tree[2*i], tree[2*i + 1])
    }

    val m = reader.readLine().toInt()

    val result = StringBuilder()

    repeat(m){
        val str = reader.readLine().trim().split(" ")
        val command = str[0]
        val first = str[1].toInt()
        val second = str[2].toInt()

        when(command){
            "QUERY" -> {
                val left = first
                val right = second
                val maxZeros = query(left, right)
                result.append(maxZeros).append("\n")

            }
            "UPDATE" -> {
                val index = first
                val newValue = second
                update(index, newValue)
            }
        }
    }
    println(result.toString().trim())

}