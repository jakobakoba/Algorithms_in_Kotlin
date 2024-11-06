package yandex_6_training_2_dz

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val n = bufferedReader.readLine().toInt()
    val s = bufferedReader.readLine().split(" ").map{it.toInt()}

    val sortedS = s.sorted()

    val ans = mutableListOf<Int>()

    var last = ""
    var k = n

    var left = 0
    var right = 0

    if (n % 2 == 0){
        left = n / 2 - 1
        right = n / 2
    } else {
        left = n / 2
        right = n / 2
    }

    while(left >= 0 && right < n){
        if (k % 2 != 0){
            when(last){
                "" -> {
                    ans.add(sortedS[left])
                    left--
                    right++
                    k -= 1
                }
                "left" -> {
                    ans.add(sortedS[right])
                    right++
                    k -= 1
                }
                "right" -> {
                    ans.add(sortedS[left])
                    left--
                    k -= 1
                }
            }
        } else {
            if (sortedS[left] < sortedS[right]){
                ans.add(sortedS[left])
                left--
                last = "left"
                k -= 1
            } else {
                ans.add(sortedS[right])
                right++
                last = "right"
                k -= 1
            }
        }
    }
    while (left >= 0){
        ans.add(sortedS[left])
        left--
    }
    while (right < n){
        ans.add(sortedS[right])
        right++
    }

    outputWriter.println(ans.joinToString(" "))


    outputWriter.close()
    bufferedReader.close()
}



