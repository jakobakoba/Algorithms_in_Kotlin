package yandex_1_training_2_dz

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val (n, m , k) = bufferedReader.readLine()?.trim()?.split(" ")?.map { it.toInt() } ?: break
        val mines = mutableListOf<IntArray>()

        for (i in 0 until k){
            val (a, b) = bufferedReader.readLine().split(" ").map { it.toInt() }
            mines.add(intArrayOf(a,b))
        }

        val field = makeField(n, m, mines)

        for (i in 1 until n + 1){
            for (j in 1 until m + 1){
                outputWriter.print("${field[i][j]} ")
            }
            outputWriter.println()
        }
    }


    outputWriter.close()
    bufferedReader.close()
}

fun makeField(n: Int, m: Int, mines: MutableList<IntArray>): MutableList<MutableList<String>> {
    val dx = listOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = listOf(-1, 0, 1, -1, 1, -1, 0 , 1)

    val field = mutableListOf<MutableList<String>>()


    for (k in 0 until n + 2){
        field.add(MutableList(m + 2){"0"})
    }

    for ((bombI, bombJ) in mines){
        for (k in 0 until dx.size){
            val newX = bombI + dx[k]
            val newY = bombJ + dy[k]
            if (field[newX][newY] != "*"){
                field[newX][newY] = (field[newX][newY].toInt() + 1).toString()
            }
        }
    }

    for ((bombI, bombJ) in mines){
        field[bombI][bombJ] = "*"
    }

    return field

}

