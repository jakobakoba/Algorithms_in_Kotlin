package yandex.yandex_6_training.yandex_6_training_4_dz

import java.io.File
import java.io.PrintWriter


fun main() {

    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)

    val s = bufferedReader.lineSequence().toList()

    val n = s[0].toInt()

    val bosses = s[1].split(" ").map { it.toInt() }

    val children = Array(n){ mutableListOf<Int>() }

    val ans = Array(n){0L}

    for (i in 0 until n - 1){
        children[bosses[i] - 1].add(i + 1)
    }

    fun countMoney(num: Int): Pair<Long, Long>{
        var size = 1L
        for(child in children[num]!!){
            val (cMoney, cSize) = countMoney(child)
            ans[num] += cMoney + cSize
            size += cSize
        }
        ans[num] += 1L
        return Pair(ans[num], size)
    }
    countMoney(0)

    val answer = StringBuilder()
    ans.forEach {
        answer.append("$it ")
    }
    outputWriter.println(answer.trim().toString())
}
