package yandex.yandex_6_training.yandex_6_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    while (true) {
        val (n, c) = bufferedReader.readLine()?.split(" ")?.map { it.toLong() } ?: break
        val s = bufferedReader.readLine()

        var left = 0
        var max = 0L
        var countA = 0L
        var countB = 0L
        var total = 0L
        var dlina = 0L



        for (right in 0 until s.length) {
            when (s[right]) {
                'a' -> {
                    countA++
                    dlina++
                }
                'b' -> {
                    dlina++
                    countB++
                    if (countA != 0L){
                        total += countA
                    }
                } else ->{
                    dlina++
                }
            }

            while (total > c) {
                when (s[left]) {
                    'a' -> {
                        countA--
                        if (countB != 0L){
                            total -= countB
                        }
                        dlina -= 1
                    }

                    'b' -> {
                        countB -= 1

                        dlina -= 1
                    } else ->  {
                        dlina -= 1
                    }
                }
                left++
            }

                max = maxOf(max, dlina)

        }

        outputWriter.println(max)
    }

    outputWriter.close()
    bufferedReader.close()
}
