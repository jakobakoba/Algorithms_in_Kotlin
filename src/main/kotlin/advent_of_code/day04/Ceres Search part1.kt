package advent_of_code.day04

import java.io.File

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()

//    var rows = 140

    val s = bufferedReader.lineSequence().toList()

    val matrix = File("input.txt").readLines().map { it.toList() }

//    for (i in 0 until s.size){
//        for (j in 0 until s[i].length){
//            matrix[i].add(s[i][j])
//        }
//    }

    val target = listOf('M', 'A', 'S')

    val directions = listOf(
        intArrayOf(-1, 0),
        intArrayOf(-1, 1),
        intArrayOf(0, 1),
        intArrayOf(1,1),
        intArrayOf(1,0),
        intArrayOf(1, -1),
        intArrayOf(0, - 1),
        intArrayOf(-1, -1)
    )



    fun search(x: Int, y: Int) : Int {
        var count = 0

        for (dir in directions){
            val chars = mutableListOf<Char>()
            var nx = x
            var ny = y

            for (step in 0 until 3){
                nx += dir[0]
                ny += dir[1]
                if (nx < 0 || ny <0 || nx >= matrix.size || ny >= matrix[0].size) break
                chars.add(matrix[nx][ny])

            }

            if (chars == target){
                count++
            }
        }
        return count
    }

    var answer = 0

    for (i in 0 until matrix.size){
        for (j in 0 until matrix[0].size){
            if (matrix[i][j] == 'X'){
                answer += search(i, j)
            }
        }
    }
    println(answer)
}