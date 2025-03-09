package yandex.yandex_1_training.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val s = mutableListOf<Int>()


    bufferedReader.use{ reader ->
        while(true){
            val n = reader.readLine()?.toInt() ?: break
            val s = reader.readLine().split(" ").map { it.toInt() }


            var maxIndex = 0

            for (i in 0 until s.size){
                if (s[maxIndex] < s[i]){
                    maxIndex = i
                }
            }


            var maxValue = -1
            var found = false
            for (i in maxIndex + 1 until s.size - 1){
                if (s[i] % 10 == 5 && s[i] > s[i + 1]){
                    var temp = 1

                    maxValue = maxOf(maxValue, s[i])
                    found = true
                }
            }
            if(!found){
                outputWriter.println(0)
            } else {
                var ans = 1
                for (i in 0 until s.size){
                    if (s[i] > maxValue){
                        ans += 1
                    }
                }
                outputWriter.println(ans)
            }

        }
    }



    outputWriter.close()
    bufferedReader.close()
}