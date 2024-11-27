package yandex.yandex_6_training_3_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    val s = addZeros(bufferedReader.readLine().trim())

    val numStack = Stack<Long>()
    val opStack = Stack<Char>()

    val map = mapOf('+' to 1, '-' to 1, '*' to 2)

    var i = 0
    while (i < s.length) {
        when {
            s[i] == ' ' -> {
                i++
            }

            s[i].isDigit() -> {
                var num = 0L
                while (i < s.length && s[i].isDigit()) {
                    num = num * 10 + (s[i] - '0')
                    i++
                }
                numStack.push(num)
                continue
            }

            s[i] == '(' -> {
                opStack.push(s[i])
                i++
            }

            s[i] == ')' -> {
                while (opStack.isNotEmpty() && opStack.peek() != '(') {
                    if (!applyOperation(numStack, opStack)) {
                        outputWriter.println("WRONG")
                        return
                    }
                }
                if (opStack.isEmpty() || opStack.pop() != '(') {
                    outputWriter.println("WRONG")
                    return
                }
                i++
            }

            s[i] in map.keys -> {
                while (opStack.isNotEmpty() && opStack.peek() != '(' &&
                    map[s[i]]!! <= map[opStack.peek()]!!) {
                    if (!applyOperation(numStack, opStack)) {
                        outputWriter.println("WRONG")
                        return
                    }
                }
                opStack.push(s[i])
                i++
            }

            else -> {
                outputWriter.println("WRONG")
                return
            }
        }
    }


    while (opStack.isNotEmpty()) {
        if (!applyOperation(numStack, opStack)) {
            outputWriter.println("WRONG")
            return
        }
    }

    if (numStack.size == 1) {
        outputWriter.println(numStack.pop())
    } else {
        outputWriter.println("WRONG")
    }

    outputWriter.close()
    bufferedReader.close()
}


fun addZeros(expression: String): String {
    val result = StringBuilder()

    for (i in expression.indices) {
        if (expression[i] == '-' &&
            (i == 0 || expression[i - 1] == '(')) {
            result.append("0")
        }
        result.append(expression[i])
    }
    return result.toString()
}


fun applyOperation(numStack: Stack<Long>, opStack: Stack<Char>): Boolean {
    if (numStack.size < 2) return false

    val b = numStack.pop()
    val a = numStack.pop()
    val op = opStack.pop()

    val result = when (op) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        else -> return false
    }

    return try {
        numStack.push(result)
        true
    } catch (e: Exception) {
        false
    }
}
