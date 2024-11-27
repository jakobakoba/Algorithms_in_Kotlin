package yandex.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val n = bufferedReader.readLine().toInt()
    val buttons = mutableMapOf<Int, Int>()
    bufferedReader.readLine().trim().split(" ").forEachIndexed { index, presses ->
        buttons[index + 1] = presses.toInt()
    }

    val pressesNum = bufferedReader.readLine().toInt()

    bufferedReader.readLine().trim().split(" ").forEach {
        buttons[it.toInt()] = buttons[it.toInt()]!! - 1
    }

    for (i in 0 until n){
        if (buttons[i + 1]!! >= 0){
            outputWriter.println("NO")
        } else {
            outputWriter.println("YES")
        }
    }

    outputWriter.close()
    bufferedReader.close()
}


