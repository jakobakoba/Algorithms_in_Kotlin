package yandex.yandex_6_training.yandex_6_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val (n, k) = bufferedReader.readLine().trim().split(" ").map { it.toInt() }
    val s = bufferedReader.readLine().trim().split(" ").map { it.toInt() }

    val deque: Deque<Int> = LinkedList()

    val result = mutableListOf<Int>()

    for (i in 0 until n){
        // удаляем самый левый который выходит за рамки
        if (deque.isNotEmpty() && deque.first == i - k){
            deque.removeFirst()
        }
        // сзади убираем тех кто больше чем s[i]
        while(deque.isNotEmpty() && s[deque.last] >= s[i]){
            deque.removeLast()
        }
        //добавляем
        deque.addLast(i)


        if (i >= k - 1){
            result.add(s[deque.first])
        }
    }
    result.forEach{outputWriter.println(it)}

}