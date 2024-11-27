package yandex.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)



    while(true){
        val s = bufferedReader.readLine()?.trim()?.split(" ")?.map{it.toLong()}?.toMutableList() ?: break

        rearrange(s, 0 ,s.size, (s.size - 1.toLong()))
        rearrange(s, 0, s.size - 1, (s.size-2).toLong())
        rearrange(s, 0, s.size - 3, 2)

        if ((s.last() * s[s.size - 2] * s[s.size - 3]) >= (s.last() * s[0] * s[1])){
            outputWriter.println("${s[s.size - 1]} ${s[s.size - 2]} ${s[s.size - 3]}")
        } else {
            outputWriter.println("${s[s.size - 1]} ${s[0]} ${s[1]}")
        }
    }


    outputWriter.close()
    bufferedReader.close()
}

fun rearrange(seq: MutableList<Long>, left: Int, right: Int, k: Long) {
    var left = 0
    var  right= seq.size - 1

    while(left < right){
        val pivot = seq[(right + left) / 2]

        var eqxfirst = left
        var gtxfirst = left

        for (i in left until right + 1){
            var now = seq[i]
            if(now == pivot){
                seq[i] = seq[gtxfirst]
                seq[gtxfirst] = now
                gtxfirst += 1
            } else if (now < pivot){
                seq[i] = seq[gtxfirst]
                seq[gtxfirst] = seq[eqxfirst]
                seq[eqxfirst] = now
                gtxfirst += 1
                eqxfirst += 1

            }
        }

        if (k < eqxfirst){
            right = eqxfirst - 1
        } else if (k >= gtxfirst){
            left = gtxfirst
        } else {
            return
        }
    }
}


