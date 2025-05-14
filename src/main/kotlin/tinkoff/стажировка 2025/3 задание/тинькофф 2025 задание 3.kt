package tinkoff.`стажировка 2025`.`3 задание`
// ПЕТЯ НАШЕЛ В СУНДУКЕ

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    fun generateChain(a: Int): List<Int> {
        val chain = mutableListOf<Int>()
        chain.add(a)
        var current = a / 2
        while (current > 0) {
            chain.add(current)
            current /= 2
        }
        chain.add(0)
        return chain
    }

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val nums = reader.readLine().trim().split(" ").map { it.toInt() }

    val sortedNums = nums.sortedDescending()

    val used = mutableSetOf<Int>()
    var count = 0

    for (num in sortedNums) {
        val chain = generateChain(num)
        for (v in chain) {
            if (!used.contains(v)) {
                used.add(v)
                count++
                break
            }
        }
    }

    println(count)
}

