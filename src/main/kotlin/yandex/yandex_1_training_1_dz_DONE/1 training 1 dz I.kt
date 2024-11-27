package yandex.yandex_1_training_1_dz_DONE

import java.io.File
import java.io.PrintWriter
import java.util.PriorityQueue

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    bufferedReader.use { reader ->
        while(true){
            val a = reader.readLine()?.toInt() ?: break
            val b = reader.readLine().toInt()
            val c = reader.readLine().toInt()
            val d = reader.readLine().toInt()
            val e = reader.readLine().toInt()

            val queue = PriorityQueue<Int>()

            queue.offer(a)
            queue.offer(b)
            queue.offer(c)

            val smallest = queue.poll()
            val medium = queue.poll()

            val smallestWall = if (d > e) e else d
            val biggerWall = if (d > e) d else e

            if (smallest <= smallestWall && medium <= biggerWall){
                outputWriter.println("YES")
            } else {
                outputWriter.println("NO")
            }
        }
    }
    outputWriter.close()
    bufferedReader.close()
}