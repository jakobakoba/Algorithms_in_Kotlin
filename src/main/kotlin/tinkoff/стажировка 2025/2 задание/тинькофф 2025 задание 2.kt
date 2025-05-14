package tinkoff.`стажировка 2025`.`2 задание`

import java.io.BufferedReader
import java.io.InputStreamReader

//ЕГОР ГУЛЯЛ

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()

    val trains = mutableListOf<Int>()
    val intervals = mutableListOf<Int>()

    repeat(n){
        val (a, b) = reader.readLine().trim().split(" ").map{it.toInt()}
        trains.add(a)
        intervals.add(b)
    }

    val q = reader.readLine().toInt()
    repeat(q){
        val (place, time) = reader.readLine().trim().split(" ").map{it.toInt()}
        val a = trains[place - 1]
        val b = intervals[place - 1]

        val next = if (time <= a){
            a
        } else {
            val diff = (time - a) % b
            if (diff == 0){
                time
            } else {
                time + (b - diff)
            }
        }
        println(next)

    }
}