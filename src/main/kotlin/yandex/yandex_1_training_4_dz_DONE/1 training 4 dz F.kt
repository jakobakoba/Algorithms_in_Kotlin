package yandex.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.lang.StringBuilder

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    val map = mutableMapOf<String, MutableMap<String, Long>>()
    while(true){
        val (buyer, item, quantity) = bufferedReader.readLine()?.trim()?.split(" ") ?: break

        val itemQuantity = quantity.toLong()

        val itemsMap = map.getOrPut(buyer){ mutableMapOf() }
        itemsMap[item] = itemsMap.getOrDefault(item, 0) + itemQuantity
    }

    val outputBuilder = StringBuilder()

    map.toSortedMap().forEach { (buyer, itemsMap) ->
        outputBuilder.append("$buyer:\n")
        itemsMap.toSortedMap().forEach{(item, quantity) ->
            outputBuilder.append("$item $quantity\n")
        }
    }

    outputWriter.print(outputBuilder.toString())


    outputWriter.close()
    bufferedReader.close()
}


