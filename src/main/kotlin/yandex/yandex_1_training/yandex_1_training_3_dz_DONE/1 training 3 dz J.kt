package yandex.yandex_1_training.yandex_1_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter


fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    while (true) {

        val (t, d, n) = bufferedReader.readLine()?.split(" ")?.map { it.toInt() } ?: break
        var postRect = intArrayOf(0, 0, 0, 0)
        repeat(n) {
            postRect = extend(postRect, t)
            val (navX, navY) = bufferedReader.readLine().split(" ").map { it.toInt() }
            val navRect = extend(intArrayOf(navX + navY, navX + navY, navX - navY, navX - navY), d)
            postRect = intersect(postRect, navRect)
        }


        val points = mutableListOf<Pair<Int, Int>>()

        for (xPlusY in postRect[0] until postRect[1] + 1) {
            for (xMinusY in postRect[2] until postRect[3] + 1) {
                if ((xPlusY + xMinusY) % 2 == 0) {
                    val x = (xPlusY + xMinusY) / 2
                    val y = xPlusY - x
                    points.add(Pair(x, y))
                }
            }
        }
        outputWriter.println(points.size)
        for (coordinate in points) {
            val (first, second) = coordinate
            outputWriter.println("$first $second")
        }

    }
    outputWriter.close()
    bufferedReader.close()

}

fun intersect(first: IntArray, second: IntArray): IntArray {
    val ans = intArrayOf(
        maxOf(first[0], second[0]),
        minOf(first[1], second[1]),
        maxOf(first[2], second[2]),
        minOf(first[3], second[3])
    )
    return ans
}

fun extend(postRec: IntArray, d: Int): IntArray {
    val (minPlus, maxPlus, minMinus, maxMinus) = postRec
    return intArrayOf(minPlus - d, maxPlus + d, minMinus - d, maxMinus + d)
}
