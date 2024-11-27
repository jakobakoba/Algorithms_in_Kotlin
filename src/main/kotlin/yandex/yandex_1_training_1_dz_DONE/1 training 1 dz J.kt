import java.io.File
import java.io.PrintWriter
import java.text.DecimalFormat

fun systemOfEquations(a: Double, b: Double, c: Double, d: Double, e: Double, f: Double): String {
    val df = DecimalFormat("#.#####")
    val determinant = a * d - b * c
    if (determinant == 0.0) {
        if (a == 0.0 && c == 0.0) {
            if (b == 0.0 && d == 0.0) {
                return if (e == 0.0 && f == 0.0) "5" else "0"
            }
            return if (e * d != f * b) "0" else listOf("4", df.format(if (b != 0.0) e / b else f / d)).joinToString(" ")
        }

        if (b == 0.0 && d == 0.0) {
            return if (e * c != f * a) "0" else listOf("3", df.format(if (a != 0.0) e / a else f / c)).joinToString(" ")
        }

        if (a != 0.0) {
            val coefficient = c / a
            val newD = d - coefficient * b
            val newF = f - coefficient * e
            if (newD == 0.0 && newF == 0.0) {
                return listOf("1", df.format(-a / b), df.format(e / b)).joinToString(" ")
            }
        } else {
            val coefficient = a / c
            val newB = b - coefficient * d
            val newE = e - coefficient * f
            if (newB == 0.0 && newE == 0.0) {
                return listOf("1", df.format(-c / d), df.format(f / d)).joinToString(" ")
            }
        }

        return "0"
    } else {
        return if (d != 0.0) {
            val x = (e - b * f / d) / (a - b * c / d)
            val y = (f - c * x) / d
            listOf("2", df.format(x), df.format(y)).joinToString(" ")
        } else {
            val x = (f - d * e / b) / (c - d * a / b)
            val y = (e - a * x) / b
            listOf("2", df.format(x), df.format(y)).joinToString(" ")
        }
    }
}

fun main() {
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()
    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)
    val inputNumbers = mutableListOf<Double>()
    repeat(6) {
        inputNumbers.add(bufferedReader.readLine().toDouble())
    }
    val a = inputNumbers[0]
    val b = inputNumbers[1]
    val c = inputNumbers[2]
    val d = inputNumbers[3]
    val e = inputNumbers[4]
    val f = inputNumbers[5]

    outputWriter.println(systemOfEquations(a, b, c, d, e, f))
}
