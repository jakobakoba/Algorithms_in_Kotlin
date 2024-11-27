package yandex.yandex_3_training_b_division

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main(){
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

        val a = bufferedReader.readLine().trim().split(" ").map { it.toInt() }
        val b = bufferedReader.readLine().trim().split(" ").map { it.toInt() }

        val firstQueue: Queue<Int> = LinkedList()
        val secondQueue: Queue<Int> = LinkedList()

        firstQueue.addAll(a)
        secondQueue.addAll(b)

        var counter = 0
        while(firstQueue.isNotEmpty() && secondQueue.isNotEmpty() && counter <= 1000000){
            val first = firstQueue.poll()
            val second = secondQueue.poll()
            if (first == 9 && second == 0){
                secondQueue.add(first)
                secondQueue.add(second)
            } else if (first == 0 && second == 9){
                firstQueue.add(first)
                firstQueue.add(second)
            } else {
                if (first > second){
                    firstQueue.add(first)
                    firstQueue.add(second)
                } else {
                    secondQueue.add(first)
                    secondQueue.add(second)
                }
            }
            counter++
        }

        if (counter > 1000000){
            outputWriter.println("botva")
        } else if (firstQueue.isNotEmpty()){
            outputWriter.println("first $counter")
        } else {
            outputWriter.println("second $counter")
        }

        outputWriter.close()
        bufferedReader.close()
}