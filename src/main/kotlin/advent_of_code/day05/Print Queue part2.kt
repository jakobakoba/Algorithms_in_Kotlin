package advent_of_code.day05

import java.io.File

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()
    var next = false

    val s = bufferedReader.lineSequence().toList()
    val map = mutableMapOf<Int, MutableSet<Int>>()
    val errors = mutableListOf<Pair<Int,Int>>()
    var answer = 0
    val main = mutableListOf<IntArray>()
    for (i in 0 until s.size){
        if (s[i].isBlank()){
            next = true
            continue
        }
        if(!next){
            val(a, b) = s[i].split("|").map{it.toInt()}
            map.computeIfAbsent(b){ mutableSetOf() }.add(a)
            errors.add(Pair(a,b))
        }  else {
            val arr = s[i].split(",").map { it.toInt() }.toIntArray()
            val seen = mutableSetOf<Int>()
            var found = false
            for (i in arr.size - 1 downTo 0){
                if (seen.isNotEmpty()){
                    if (map.contains(arr[i])){
                        for (num in map[arr[i]]!!){
                            if (num in seen){
                                main.add(arr)
                                found = true
                                break
                            }
                        }
                        if (found) break
                    }
                }
                seen.add(arr[i])
            }

        }
    }

    for (arr in main){
        var sorted = false
        while(!sorted){
            sorted = true
            for ((a, b) in errors){
                val idxA = arr.indexOf(a)
                val idxB = arr.indexOf(b)
                if (idxA > idxB && idxA != -1 && idxB != -1){
                    arr[idxA] = arr[idxB].also{arr[idxB] = arr[idxA]}
                    sorted = false
                }
            }
        }
    }
    for (arr in main){
        answer += arr[arr.size / 2]
    }


    println(answer)

}