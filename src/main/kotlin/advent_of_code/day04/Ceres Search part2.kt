package advent_of_code.day04

import java.io.File

fun main(){
//    val bufferedReader = File("testInput.txt").bufferedReader()

//    var rows = 140

//    val s = bufferedReader.lineSequence().toList()

    val matrix = File("input.txt").readLines().map { it.toList() }

//    for (i in 0 until s.size){
//        for (j in 0 until s[i].length){
//            matrix[i].add(s[i][j])
//        }
//    }


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


    val target1 = listOf('M', 'S')
    val target2 = listOf('S', 'M')

    val rows = matrix.size
    val cols = matrix[0].size

    fun search(x: Int, y: Int) : Int {
        val (x1, x2, y1, y2) = intArrayOf(x - 1, x + 1, y - 1, y + 1)
        if (x1 in 0 until rows && x2 in 0 until rows && y1 in 0 until cols && y2 in 0 until cols){
            val firstDiagonale = listOf(matrix[x1][y2], matrix[x2][y1])
            val secondDiagonale = listOf(matrix[x1][y1], matrix[x2][y2])

            if ((firstDiagonale == target1 || firstDiagonale == target2) &&
                (secondDiagonale == target1 || secondDiagonale == target2)){
              return 1
            }
        }
        return 0
    }

    var answer = 0

    for (i in 0 until matrix.size){
        for (j in 0 until matrix[0].size){
            if (matrix[i][j] == 'A'){
                answer += search(i, j)
            }
        }
    }
    println(answer)
}