package advent_of_code.day05

import java.io.File

fun main(){
    val bufferedReader = File("input.txt").bufferedReader()
    var next = false

    val s = bufferedReader.lineSequence().toList()

    val map = mutableMapOf<Int, MutableSet<Int>>()
    var answer = 0
    for (i in 0 until s.size){
        if (s[i].isBlank()){
            next = true
            continue
        }
        if(!next){
            val(a, b) = s[i].split("|").map{it.toInt()}
            map.computeIfAbsent(b){ mutableSetOf() }.add(a)
        }  else {
            var good = true
            val arr = s[i].split(",").map { it.toInt() }
            val seen = mutableSetOf<Int>()
            for (i in arr.size - 1 downTo 0){
                if (seen.isNotEmpty()){
                    if (map.contains(arr[i])){
                        for (num in map[arr[i]]!!){
                            if (num in seen){
                                good = false
                                break
                            }
                        }
                    }

                }

                if (good == false) break
                seen.add(arr[i])
            }
            if (good){
                answer += arr[arr.size / 2]
            }
        }
    }
    println(answer)

}