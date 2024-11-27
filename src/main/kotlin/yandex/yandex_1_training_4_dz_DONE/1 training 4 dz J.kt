package yandex.yandex_1_training_4_dz_DONE

import java.io.File
import java.io.PrintWriter
@kotlin.ExperimentalStdlibApi
fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    var (nInput, sensitivityInput, digitInput) = bufferedReader.readLine().trim().split(" ")
    val n = nInput.toInt()
    val sensitivity = sensitivityInput == "yes"
    val digit = digitInput == "yes"

    val set = mutableSetOf<String>()
    for (i in 0 until n) {
        var s = bufferedReader.readLine().trim()
        if (!sensitivity) {
            s = s.lowercase()
        }
        set.add(s)
    }

    val count = mutableMapOf<String, IntArray>()
    var wordNum = 0

    for (line in bufferedReader.readLines()) {
        val newLine = onlyLetterDigitsAndUnderscore(line.trim())
        val words = newLine.split(" ")

        for (word in words) {
            var curWord = word
            if (!sensitivity) {
                curWord = word.lowercase()
            }
            if (curWord in set) {
                continue
            }
            if (isCorrect(curWord, digit)) {
                wordNum += 1
                if (curWord !in count) {
                    count[curWord] = intArrayOf(0, wordNum)
                }
                count[curWord]!![0] += 1
            }
        }
    }

    var bestWord = ""
    var maxCount = intArrayOf(0, 0)

    for ((key, value) in count) {
        if (value[0] > maxCount[0]) {
            maxCount = value
            bestWord = key
        }
        if (value[0] == maxCount[0] && value[1] < maxCount[1]) {
            maxCount = value
            bestWord = key
        }
    }

    outputWriter.println(bestWord)






    outputWriter.close()
    bufferedReader.close()
}

fun isCorrect(curWord: String, digit: Boolean): Boolean {
    if (curWord.all { it.isDigit() }) return false

    if (!curWord[0].isDigit() || digit) {
        return true
    }

    return false
}

fun onlyLetterDigitsAndUnderscore(line: String): String {
    val ans = mutableListOf<Char>()
    for (c in line) {
        if (c.isLetterOrDigit() || c == '_') {
            ans.add(c)
        } else {
            ans.add(' ')
        }
    }
    return ans.joinToString("")
}


