package yandex_1_training_5_dz

import java.io.File
import java.io.PrintWriter

fun main() {

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while (true) {
        val n = bufferedReader.readLine()?.toInt() ?: break
        val points = mutableListOf<IntArray>()
        repeat(n){
            val (a,b) = bufferedReader.readLine().trim().split(" ").map { it.toInt() }
            points.add(intArrayOf(a,b))

        }

        val m = bufferedReader.readLine().toInt()

        val tracks = mutableListOf<IntArray>()
        repeat(m){
            val(a,b ) = bufferedReader.readLine().trim().split(" ").map { it.toInt() }
            tracks.add(intArrayOf(a,b))
        }

        val results = helper(points, tracks)

        for (result in results){
            outputWriter.println(result)
        }



    }


    outputWriter.close()
    bufferedReader.close()
}

fun helper(points: List<IntArray>, tracks: List<IntArray>): List<Int>{
    val prefixLeft = IntArray(points.size + 1)
    prefixLeft[0] = 0


    val prefixRight = IntArray(points.size + 1)
    prefixRight[points.size] = 0

    val n = points.size
    for (i in 1 until n){
        prefixLeft[i] = prefixLeft[i-1] + maxOf((points[i][1] - points[i - 1][1]), 0)
        prefixRight[n - i - 1] = prefixRight[n-i] + maxOf(points[n - i - 1][1] - points[n - i ][1] , 0)
    }

    val results = mutableListOf<Int>()

    for (track in tracks){
        if (track[0] < track[1]){
            results.add(prefixLeft[track[1] - 1] - prefixLeft[track[0] - 1])
        } else {
            results.add(prefixRight[track[1] - 1] - prefixRight[track[0] - 1])
        }
    }
    return results
}



