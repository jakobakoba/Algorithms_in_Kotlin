package yandex.yandex_6_training.yandex_6_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter

//Очередь в ПВЗ

fun main(){
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val (n, b) = bufferedReader.readLine().split(" ").map { it.toLong() }

    val clients = bufferedReader.readLine().trim().split(" ").map { it.toLong() }

    var time = 0L
    var leftovers = 0L

    for (i in clients){
        var all = i + leftovers
        leftovers = 0
        time += all
        if (all - b >= 0) {
            all -= b
        } else {
            all = 0
        }
        leftovers += all
    }
    time += leftovers

    outputWriter.println(time)


}