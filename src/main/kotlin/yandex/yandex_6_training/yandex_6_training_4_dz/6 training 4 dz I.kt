import java.io.File
import java.io.PrintWriter

fun main() {
    val bufferedReader = File("input.txt").bufferedReader()
    val outputWriter = PrintWriter(File("output.txt").outputStream(), true)

    val s = bufferedReader.lineSequence().toList()
    val n = s[0].toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (i in 1 until s.size) {
        val (a, b) = s[i].split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

}
