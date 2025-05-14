package tinkoff.`стажировка 2025`.`5 задание`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val (n, a, b) = reader.readLine().trim().split(" ").map { it.toInt() }
    val s = reader.readLine()

    val openCount = s.count { it == '(' }
    val openDiff = openCount - n
    val costReplace = Math.abs(openDiff) * b

    val replaced = mutableSetOf<Int>()

    when {
        openDiff > 0 -> {
            val openIndices = mutableListOf<Int>()
            s.indices.forEach { if (s[it] == '(') openIndices.add(it) }
            val start = openIndices.size - openDiff
            if (start >= 0) {
                (start until openIndices.size).forEach { replaced.add(openIndices[it]) }
            }
        }
        openDiff < 0 -> {
            val closeIndices = mutableListOf<Int>()
            s.indices.forEach { if (s[it] == ')') closeIndices.add(it) }
            val k = -openDiff
            (0 until k).forEach { if (it < closeIndices.size) replaced.add(closeIndices[it]) }
        }
    }

    var balance = 0
    var minBalance = 0
    s.indices.forEach { i ->
        val c = when {
            openDiff > 0 && i in replaced -> ')'
            openDiff < 0 && i in replaced -> '('
            else -> s[i]
        }
        if (c == '(') balance++ else balance--
        if (balance < minBalance) minBalance = balance
    }

    val d = -minBalance
    val swaps = if (d > 0) (d + 1) / 2 else 0
    val totalCost = costReplace + swaps * a

    println(totalCost)
}