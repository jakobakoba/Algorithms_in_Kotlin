import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)


    while (true) {

        val n = bufferedReader.readLine()?.toInt() ?: break
        var prefix = 0
        val ans = mutableListOf<Int>()
        val s = bufferedReader.readLine().split(" ").map { it.toInt() }
        for (i in s){
            prefix += i
            ans.add(prefix)
        }
        outputWriter.println(ans.joinToString(" "))

    }

    outputWriter.close()
    bufferedReader.close()
}
