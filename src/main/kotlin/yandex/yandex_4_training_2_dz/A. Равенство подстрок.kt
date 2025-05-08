package yandex.yandex_4_training_2_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val origstr = reader.readLine()
    val length = origstr.length
    val q = reader.readLine().toInt()
    val p = 1_000_000_007L
    val x_ = 257L
    val str  = " $origstr"

    val h = LongArray(length + 1)
    val x = LongArray(length + 1)
    x[0] = 1L
    for (i in 1 .. length){
        x[i] = (x[i - 1] * x_) % p
    }

    h[0] = 0L
    for (i in 1 .. length){
        h[i] = (h[i - 1] * x_ + str[i].code) % p
    }

    fun isEqual(l: Int, a: Int, b: Int): Boolean {
        val from1 = a + 1
        val from2 = b + 1

        val slen = l
        val hash1 = (h[from1 + slen - 1] + h[from2 - 1] * x[slen]) % p
        val hash2 = (h[from2 + slen - 1] + h[from1 - 1] * x[slen]) % p

        return hash1 == hash2
    }
    val result = StringBuilder()
    repeat(q){
        val (l, a, b) = reader.readLine().trim().split(" ").map{it.toInt()}

        if (isEqual(l, a, b)){
            result.append("yes").append("\n")
        } else {
            result.append("no").append("\n")
        }
    }
    println(result.toString())
}