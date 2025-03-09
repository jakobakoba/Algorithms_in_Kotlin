package yandex.yandex_1_training.yandex_1_training_2_dz_DONE

import java.io.File
import java.io.PrintWriter

fun main(){

    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)




    val n = bufferedReader.readLine().toInt()
    val s = bufferedReader.readLine().trim().split(" ").map{it.toInt()}

    val result = symmetricSequence(s)

    outputWriter.println(result.size)
    if (result.isNotEmpty()){
        outputWriter.println(result.joinToString(" "))
    }


    outputWriter.close()
    bufferedReader.close()
}

fun symmetricSequence(nums: List<Int>): List<Int> {
    for (i in nums.indices){
        if (isSymmetric(nums.subList(i, nums.size))){
            return nums.subList(0, i).reversed()
        }
    }
    return emptyList()

}

fun isSymmetric(nums: List<Int>): Boolean {
    for (i in 0 until nums.size / 2){
        if (nums[i] != nums[nums.size-1-i]){
            return false
        }
    }
    return true
}
