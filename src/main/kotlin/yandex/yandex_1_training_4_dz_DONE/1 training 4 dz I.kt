package yandex.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter
@kotlin.ExperimentalStdlibApi
fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val n = bufferedReader.readLine().toInt()
    val map = mutableMapOf<String, MutableSet<String>>()
    repeat(n) {
        val word = bufferedReader.readLine().trim()
        val lowerWord = word.lowercase()
        map.getOrPut(lowerWord) { mutableSetOf() }.add(word)
    }
    val s = bufferedReader.readLine().trim().split(" ")
    if (s[0] == ""){
        outputWriter.println(0)
    } else {
        var ans = 0
        for (word in s) {
            if (!map.containsKey(word.lowercase())) {
                var udarenie = 0
                for (char in word) {
                    if (char.isUpperCase()) udarenie += 1
                    if (udarenie > 1) {
                        break
                    }
                }
                if (udarenie == 0 || udarenie > 1) {
                    ans += 1
                }

            } else if (map.containsKey(word.lowercase())) {
                var found = map[word.lowercase()]!!.contains(word)
                if (!found) {
                    ans += 1
                }
            }

        }

        outputWriter.println(ans)
    }





    outputWriter.close()
    bufferedReader.close()
}


