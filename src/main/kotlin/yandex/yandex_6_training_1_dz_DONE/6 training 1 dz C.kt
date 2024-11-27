package yandex.yandex_6_training_1_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while (true) {
        val n = bufferedReader.readLine()?.toInt() ?: break
        val matrix = Array(n) { bufferedReader.readLine().toCharArray() }


        var x1 = Int.MAX_VALUE
        var y1 = Int.MAX_VALUE
        var x2 = Int.MIN_VALUE
        var y2 = Int.MIN_VALUE

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[i][j] == '#') {
                    x1 = minOf(x1, i)
                    y1 = minOf(y1, j)
                    x2 = maxOf(x2, i)
                    y2 = maxOf(y2, j)
                }
            }
        }
        if (x1 == Int.MAX_VALUE && y1 == Int.MAX_VALUE && x2 == Int.MIN_VALUE && y2 == Int.MIN_VALUE) {
            outputWriter.println("X")
        } else {
            val newMatrix = Array(x2 - x1 + 1) { i ->
                matrix[x1 + i].sliceArray(y1..y2)
            }

            fun line(s: CharArray): Pair<String, MutableList<Int>> {
                val second = mutableListOf<Int>()
                var first = when {
                    s.all { it == '#' } -> {
                        second.add(s.size)
                        "all"
                    }

                    s.first() == '#' && s.last() == '#' -> {
                        var prev = s[0]
                        var counter = 1
                        for (i in 1 until s.size) {
                            if (s[i] == prev) {
                                counter++
                            } else {
                                second.add(counter)
                                counter = 1
                                prev = s[i]
                            }
                        }
                        second.add(counter)
                        "edge"

                    }

                    s.first() == '#' -> {
                        var prev = s[0]
                        var counter = 1
                        for (i in 1 until s.size) {
                            if (s[i] == prev) {
                                counter++
                            } else {
                                second.add(counter)
                                counter = 1
                                prev = s[i]
                            }
                        }
                        second.add(counter)
                        "left"
                    }

                    s.last() == '.' -> {
                        var prev = s[0]
                        var counter = 1
                        for (i in 1 until s.size) {
                            if (s[i] == prev) {
                                counter++
                            } else {
                                second.add(counter)
                                counter = 1
                                prev = s[i]
                            }
                        }
                        second.add(counter)
                        "right"
                    }

                    else -> "X"
                }
                return Pair(first, second)
            }

            val stack = mutableListOf<Pair<String, MutableList<Int>>>()

            for (s in newMatrix) {
                val x = line(s)

                if (stack.isEmpty() || (stack.last() != x)) {
                    stack.add(x)
                }
            }

            var ans = when (stack.map { it.first }) {
                listOf("all") -> "I"
                listOf("all", "edge", "all") -> "O"
                listOf("all", "left", "all") -> "C"
                listOf("left", "all") -> "L"
                listOf("edge", "all", "edge") -> "H"
                listOf("all", "edge", "all", "left") -> "P"
                else -> "X"
            }
            if (ans == "H") {
                val temp = mutableListOf<CharArray>()
                for (step in newMatrix) {
                    if (!step.all { it == '#' }) {
                        if (temp.isEmpty()) {
                            temp.add(step)
                        } else {
                            if (!temp.last().contentEquals(step)) {
                                ans = 'X'.toString()
                                break
                            }
                        }
                    }
                }
            }
            if (ans == "P") {
                var firstIndex = -1
                for (step in newMatrix) {
                    if (!step.all { it == '#' }) {
                        if (firstIndex == -1) {
                            firstIndex = step.indexOf('.')
                        } else {
                            val tempIndex = step.indexOf('.')
                            if (firstIndex != tempIndex) {
                                ans = "X"
                                break
                            }
                        }
                    }
                }
            }
            outputWriter.println(ans)
        }
    }
    outputWriter.close()
    bufferedReader.close()
}
