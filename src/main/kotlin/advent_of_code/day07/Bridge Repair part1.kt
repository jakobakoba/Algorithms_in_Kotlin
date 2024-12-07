package advent_of_code.day07

import java.io.File


fun main(){
    fun checkLegit(nums: List<Int>, target: Long): Boolean {
        fun backtrack(index: Int, cur: Long) : Boolean {
            if (index == nums.size){
                return cur == target
            }

            val add = backtrack(index + 1, cur + nums[index])
            val multiply = backtrack(index + 1, cur * nums[index])

            return add || multiply
        }
        return backtrack(1, nums[0].toLong())
    }

    val s = File("input.txt").readLines()
    var ans = 0L
    for (line in s){
        val (tempTarget, tempNums) = line.split(":")

        val target = tempTarget.toLong()
        val nums = tempNums.split(" ").filter { it.isNotBlank() }.map{it.toInt()}

        val result = checkLegit(nums, target)
        if (result){
            ans += target
        }
    }
    println(ans)
}

