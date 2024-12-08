import java.io.File
import kotlin.math.abs

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
                    val gcd = gcd(abs(dr), abs(dc))
                    val stepR = dr / gcd
                    val stepC = dc / gcd

                    var r = r1
                    var c = c1
                    while (r in 0 until rows && c in 0 until cols) {
                        antinodes.add(Pair(r, c))
                        r -= stepR
                        c -= stepC
                    }

                    r = r2
                    c = c2
                    while (r in 0 until rows && c in 0 until cols) {
                        antinodes.add(Pair(r, c))
                        r += stepR
                        c += stepC
                    }
                }
            }
        }
    }

    println("${antinodes.size}")
}

fun gcd(a: Int, b: Int): Int{
    return if (b == 0) a else gcd(b, a % b)
}

