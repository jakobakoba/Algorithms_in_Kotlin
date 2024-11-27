package yandex.yandex_3_training_b_division

import java.io.File
import java.io.PrintWriter
import kotlin.math.floor

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while(true){
        val n = bufferedReader.readLine()?.toInt() ?: break
        val heap = mutableListOf<Int>()
        repeat(n){
            val command = bufferedReader.readLine().split(" ")
            when(command.size){
                //extract
                1 -> {
                    val ans = heap[0]
                    heap[0] = heap.last()
                    var position = 0
                    // пока есть 2 детей
                    while((position * 2 + 2)  < heap.size){
                        // левый ребенок это position * 2 + 1
                        // правый ребенок это position * 2 + 2
                        var min_son_index = position * 2  + 1
                        if (heap[position * 2 + 2] < heap[min_son_index]){
                            min_son_index = position * 2 + 2
                        }
                        if (heap[position] < heap[min_son_index]){
                            val temp = heap[position]
                            heap[position] = heap[min_son_index]
                            heap[min_son_index] = temp
                            position = min_son_index
                        } else {
                            break
                        }
                    }
                    heap.removeLast()
                    outputWriter.println(ans)
                }
                //insert
                2 -> {
                    heap.add(command[1].toInt())
                    var position = heap.size - 1
                    //просеивание вверх
                    // 0 это будет корень, у корня нет предков
                    // (position - 1) / 2 это предок
                    // если наш элемент больше свеого предка мы их свопаем
                    // по условию b) Extract достать из Heap наибольшее число (удалив его при этом).
                    while(position > 0 && heap[position] > heap[floor((position - 1) / 2.0).toInt()]){
                        val temp = heap[position]
                        heap[position] = heap[floor((position - 1) / 2.0).toInt()]
                        heap[floor((position - 1 ) / 2.0).toInt()] =  temp
                        position = floor((position - 1) / 2.0).toInt()
                    }
                }
            }
        }

    }
}