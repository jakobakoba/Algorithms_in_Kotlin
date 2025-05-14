package tinkoff.`стажировка 2025`.` 1 задание `
//ПОЧТИ ПАЛИНДРОМ

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val str = reader.readLine()

    var found = "NO"

    for (i in  0 until str.length){
        val temp = str.removeRange(i, i + 1)
        if (temp == temp.reversed()){
            found = "YES"
            break
        }
    }
    println(found)
}