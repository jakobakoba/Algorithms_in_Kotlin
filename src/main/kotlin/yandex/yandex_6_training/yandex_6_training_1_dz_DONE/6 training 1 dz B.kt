package yandex.yandex_6_training.yandex_6_training_1_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while(true){
        val blueShirts= bufferedReader.readLine()?.toLong() ?: break
        val redShirts = bufferedReader.readLine().toLong()
        val blueSocks = bufferedReader.readLine().toLong()
        val redSocks = bufferedReader.readLine().toLong()

        //если где то встречается ноль тогда выбирается другой цвет и потом на
    // анти стороне маек или носков перебивается тот цвет который выбрался из за 0.
    // Если нужен синий, то красный + 1, а если красный, то синий + 1


        if (blueShirts == 0L){
            outputWriter.println("1 ${blueSocks + 1}")
        } else if (blueSocks == 0L){
            outputWriter.println(("${blueShirts + 1} 1"))
        } else if (redShirts == 0L){
            outputWriter.println("1 ${redSocks + 1}")
        } else if (redSocks == 0L){
            outputWriter.println("${redShirts + 1} 1")
        } else {
            val part1 = maxOf(blueShirts, redShirts)
            val part2 = maxOf(blueSocks,redSocks)

            // суммирую майки и носки. Потом смотрю где меньше
            // там где меньше делаю maxOf(a,b) + 1
            // там где больше ответ 1
            // потому что там где меньше у меня будет 2 цвета

            // перебиваю minOf если оба мин

            val variant1 = if (part1 < part2){
                val first = maxOf(blueShirts, redShirts) + 1
                val second = 1
                first + second
            } else {
                val first = 1
                val second = maxOf(blueSocks, redSocks) + 1
                first + second
            }
            val variant2 = redShirts + 1 + redSocks + 1
            val variant3 = blueShirts + 1 + blueSocks + 1

            if (variant1 < variant2 && variant1 < variant3){
                outputWriter.println(if (part1 < part2){
                    val first = maxOf(blueShirts, redShirts) + 1
                    val second = 1
                    "$first $second"
                } else {
                    val first = 1
                    val second = maxOf(blueSocks, redSocks) + 1
                    "$first $second"
                })
            } else if(variant2 < variant1 && variant2 < variant3){
                outputWriter.println("${redShirts + 1} ${redSocks + 1}")
            } else {
                outputWriter.println("${blueShirts + 1} ${blueSocks + 1}")
            }
        }
    }
    outputWriter.close()
    bufferedReader.close()
}


