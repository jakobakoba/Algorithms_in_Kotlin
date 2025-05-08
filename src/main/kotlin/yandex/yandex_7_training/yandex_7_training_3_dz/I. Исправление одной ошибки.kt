package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val command = reader.readLine().toInt()
    val str = reader.readLine()

    when (command) {
        1 -> {
            val n = str.length
            var k = 0
            while ((1L shl k) < (n + k + 1)) {
                k++
            }
            val m = n + k

            val hammingCode = CharArray(m + 1)
            var dataIdx = 0

            for (i in 1..m) {
                if (isPowerOfTwo(i)) {
                    hammingCode[i] = '0'
                } else {
                    if (dataIdx < n) {
                        hammingCode[i] = str[dataIdx]
                        dataIdx++
                    } else {

                        hammingCode[i] = '0'
                    }
                }
            }

            for (i in 0 until k) {
                val checkPos = 1 shl i
                var xorSum = 0
                for (j in checkPos..m) {
                    if (((j shr i) and 1) == 1) {
                        if (hammingCode[j] == '1') {
                            xorSum = xorSum xor 1
                        }
                    }
                }
                if (xorSum == 1) {
                    hammingCode[checkPos] = '1'
                }

            }

            println(hammingCode.copyOfRange(1, m + 1).joinToString(""))
        }
        2 -> {
            val m = str.length
            val receivedCode = CharArray(m + 1)
            for (i in 0 until m) {
                receivedCode[i + 1] = str[i]
            }

            var errorPosition = 0
            var k_decode = 0

            while ((1L shl k_decode) <= m) {
                k_decode++
            }

            for (i in 0 until k_decode) {
                val checkPos = 1 shl i
                if (checkPos > m) continue

                var xorSum = 0
                for (j in checkPos..m) {
                    if (((j shr i) and 1) == 1) {
                        if (receivedCode[j] == '1') {
                            xorSum = xorSum xor 1
                        }
                    }
                }

                if (xorSum == 1) {
                    errorPosition += checkPos
                }
            }

            if (errorPosition > 0 && errorPosition <= m) {
                receivedCode[errorPosition] = if (receivedCode[errorPosition] == '0') '1' else '0'
            }

            val resultX = StringBuilder()
            for (i in 1..m) {
                if (!isPowerOfTwo(i)) {
                    resultX.append(receivedCode[i])
                }
            }

            println(resultX.toString())
        }
    }
}

fun isPowerOfTwo(n: Int): Boolean {
    return n > 0 && (n and (n - 1)) == 0
}