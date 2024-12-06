package advent_of_code.day06

import java.io.File

fun main(){

    val matrix = File("input.txt").readLines().map{it.toList()}
    val (rows, cols) = listOf(matrix.size, matrix[0].size)

    var guard = IntArray(2)
    var found = false
    for (i in 0 until rows){
        for (j in 0 until cols){
            if (matrix[i][j] == '^'){
                guard = intArrayOf(i, j)
                found = true
                break
            }
        }
        if (found) break
    }
    var dirIndex = 0

    val fakeMatrix = Array(matrix.size){IntArray(matrix[0].size){0} }

    val directions = listOf(Pair(-1,0), Pair(0, 1), Pair(1,0), Pair(0, -1))
    val visited = mutableSetOf<Pair<Int,Int>>()
    while(guard[0] in 0 until rows && guard[1] in 0 until cols){
        val i = guard[0]
        val j = guard[1]

        visited.add(Pair(i, j))
        fakeMatrix[i][j] = 1

        val (di, dj) = directions[dirIndex]
        val nextI = i + di
        val nextJ = j + dj

        if (nextI !in 0 until rows || nextJ !in 0 until cols){
            break
        } else if ( matrix[nextI][nextJ] == '#'){
            dirIndex = (dirIndex + 1) % 4
        } else {
            guard[0] = nextI
            guard[1] = nextJ
        }
    }
        println( visited.size)
}