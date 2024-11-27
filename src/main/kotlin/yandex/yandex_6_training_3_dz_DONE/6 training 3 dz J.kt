package yandex.yandex_6_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.util.*


fun main() {
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val (n, h) = bufferedReader.readLine().split(" ").map { it.toLong() }
    val heights = bufferedReader.readLine().split(" ").map { it.toLong() }
    val widths = bufferedReader.readLine().split(" ").map { it.toLong() }

    if (n == 1L) {
        outputWriter.println(0)
        return
    }
    for (width in widths) {
        if (width >= h) {
            outputWriter.println(0)
            return
        }
    }

    val pairs = heights.zip(widths)
    val sortedPairs = pairs.sortedBy { it.first }
    val sortedHeights = sortedPairs.map { it.first }
    val sortedWidths = sortedPairs.map { it.second }

    val deque: Deque<Long> = LinkedList()
    var left = 0
    var curWidth = 0L
    curWidth += sortedWidths[0]
    var finalRaznost = Long.MAX_VALUE
    for (right in 1 until n.toInt()) {
        //добавляю в сумму это точно
        curWidth += sortedWidths[right]
        //убираю всех кто ниже чем текущая разница из дека
        while (deque.isNotEmpty() && deque.peekLast() < sortedHeights[right] - sortedHeights[right - 1]) {
            deque.pollLast()
        }
        //добавляю максимум в дек
        // в деке таким образом будет порядок на уменьшение
        val maximusLast = sortedHeights[right] - sortedHeights[right - 1]
        deque.addLast(maximusLast)


        // сейчас в деке хранятся максимумы этого отрезка.
        // смотрю на сумму width и если оно больше начинаю двигать left и выталкивать из queue если
        // сходятся в разнице
        while (left <= right && curWidth >= h) {
            val maximus = sortedHeights[left + 1] - sortedHeights[left]
            // в данный момент самый большой находится на peek() и отвечает условиям >= h
            //поэтому он может идти в final
            curWidth -= sortedWidths[left]
            if (deque.isNotEmpty()) {
                finalRaznost = minOf(finalRaznost, deque.peekFirst())
            }
            if (maximus == deque.peekFirst()) {
                deque.removeFirst()
            }
            left++
        }
    }

    outputWriter.println(finalRaznost)

}

//может быть момент когда максимальные большие для начала и под конец и когда левый уходит, то
// забирает с собой максимальное который в конце.- исправил
