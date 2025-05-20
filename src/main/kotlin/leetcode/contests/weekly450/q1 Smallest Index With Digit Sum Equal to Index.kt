package leetcode.contests.weekly450

fun main(){
    class Solution {
        fun smallestIndex(nums: IntArray): Int {
            for (i in 0 until nums.size){
                var cur = nums[i]
                var temp = 0
                while(cur > 0){
                    temp += cur % 10
                    cur = cur / 10
                }
                if (temp == i){
                    return i
                }
            }
            return -1
        }
    }
}