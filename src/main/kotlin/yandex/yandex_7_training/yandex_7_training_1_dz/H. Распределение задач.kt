package yandex.yandex_7_training.yandex_7_training_1_dz

import java.io.BufferedReader
import java.io.InputStreamReader

data class OddOrderInfo(val sv: Long, val sm: Long, val diff: Long)
data class EvenOrderInfo(val sv: Long, val sm: Long)

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val oddOrders = mutableListOf<OddOrderInfo>()
    val evenOrders = mutableListOf<EvenOrderInfo>()

    repeat(n) {
        val s = reader.readLine()
        var sv = 0L
        var sm = 0L

        for (i in s.indices) {
            if (s[i] == 'S') {
                if (i % 2 == 0) {
                    sv++
                } else {
                    sm++
                }
            }
        }

        if (s.length % 2 == 0) {
            evenOrders.add(EvenOrderInfo(sv, sm))
        } else {
            oddOrders.add(OddOrderInfo(sv, sm, sv - sm))
        }
    }

    if (oddOrders.isEmpty()) {
        var totalSvEven = 0L
        for (evenOrder in evenOrders) {
            totalSvEven += evenOrder.sv
        }
        println(totalSvEven)

    } else {
        var sumMaxEvenContribution: Long = 0L
        for (evenOrder in evenOrders) {
            sumMaxEvenContribution += maxOf(evenOrder.sv, evenOrder.sm)
        }

        oddOrders.sortByDescending { it.diff }

        var optimalOddContribution: Long = 0L
        val m = oddOrders.size
        val numOddSlots = (m + 1) / 2

        for (i in 0 until numOddSlots) {
            optimalOddContribution += oddOrders[i].sv
        }
        for (i in numOddSlots until m) {
            optimalOddContribution += oddOrders[i].sm
        }

        val totalMaxSv = optimalOddContribution + sumMaxEvenContribution
        println(totalMaxSv)
    }
}