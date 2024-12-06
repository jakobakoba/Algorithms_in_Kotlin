package advent_of_code.day06

import java.io.File

fun main() {

    val matrix = File("input.txt").readLines().map { it.toMutableList() }
    val (rows, cols) = listOf(matrix.size, matrix[0].size)

    var guard = IntArray(2)
    var found = false
    var initialPosition = IntArray(2)
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (matrix[i][j] == '^') {
                guard = intArrayOf(i, j)
                initialPosition = intArrayOf(i,j)
                found = true
                break
            }
        }
        if (found) break
    }
    var dirIndex = 0


    val directions = listOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))
    val visited = mutableSetOf<Pair<Int, Int>>()
    while (guard[0] in 0 until rows && guard[1] in 0 until cols) {
        val i = guard[0]
        val j = guard[1]

        visited.add(Pair(i, j))

        val (di, dj) = directions[dirIndex]
        val nextI = i + di
        val nextJ = j + dj

        if (nextI !in 0 until rows || nextJ !in 0 until cols) {
            break
        } else if (matrix[nextI][nextJ] == '#') {
            dirIndex = (dirIndex + 1) % 4
        } else {
            guard[0] = nextI
            guard[1] = nextJ
        }
    }
//    println(visited.size)

    var cycleCount = 0

    for (position in visited){
        val i = position.first
        val j = position.second
        if ( i == initialPosition[0] && j == initialPosition[1]) continue
        matrix[i][j] = '#'
        if(hasCycle(matrix, initialPosition[0], initialPosition[1])){
            cycleCount++
        }
        matrix[i][j] = '.'
    }
    println(cycleCount)
}

fun hasCycle(matrix: List<MutableList<Char>>, i: Int, j: Int): Boolean {
    val visited = mutableMapOf<Pair<Int, Int>, Pair<Int, Int>>()

    val directions = listOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))

    val rows = matrix.size
    val cols = matrix[0].size

    var at = Pair(i,j)
    var facing = 0

    while(at.first in 0 until rows && at.second in 0 until cols){
        if (visited[at] == directions[facing]) return true

        visited[at] = directions[facing]

        if (matrix[at.first][at.second] == '#') {
            at = Pair(at.first - directions[facing].first, at.second - directions[facing].second)
            facing = (facing + 1) % directions.size
            continue
        }

        matrix[at.first][at.second] = 'X'
        at = Pair(at.first + directions[facing].first, at.second + directions[facing].second)
    }
    return false
}
