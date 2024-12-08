import java.io.File

fun main() {
    val matrix = File("input.txt").readLines().map { it.toList() }
    val rows = matrix.size
    val cols = matrix[0].size

    val antinodes = mutableSetOf<Pair<Int, Int>>()

    for (r1 in 0 until rows) {
        for (c1 in 0 until cols) {
            val freq1 = matrix[r1][c1]
            if (freq1 == '.') continue

            for (r2 in 0 until rows) {
                for (c2 in 0 until cols) {
                    val freq2 = matrix[r2][c2]
                    if (freq1 != freq2 || (r1 == r2 && c1 == c2)) continue

                    val dr = r2 - r1
                    val dc = c2 - c1

                    val antinode1 = Pair(r1 - dr, c1 - dc)
                    val antinode2 = Pair(r2 + dr, c2 + dc)

                    if (antinode1.first in 0 until rows && antinode1.second in 0 until cols) antinodes.add(antinode1)
                    if (antinode2.first in 0 until rows && antinode2.second in 0 until cols) antinodes.add(antinode2)
                }
            }
        }
    }

    // Вывод результата
    println("${antinodes.size}")
}
