package leetcode.contests.weekly450

fun main(){
    class Solution {
        fun minSwaps(nums: IntArray): Int {
            val n = nums.size

            fun findSum(x: Int): Int {
                var num = x
                var sum = 0
                while(num > 0){
                    sum += num % 10
                    num /= 10
                }
                return sum
            }

            val sorted = nums
                .map{Pair(it, findSum(it))}
                .sortedWith(compareBy({it.second}, {it.first}))
                .map{it.first}

            val map = sorted.mapIndexed{index, value ->
                Pair(value, index)
            }.toMap()

            var totalSwap = 0
            val visited = BooleanArray(n)
            for (i in 0 until n){
                if (visited[i] || map[nums[i]] == i) continue

                var swap = 0
                var j = i
                while(!visited[j]){
                    visited[j] = true
                    j = map[nums[j]]!!
                    swap += 1
                }
                totalSwap += swap - 1
            }
            return totalSwap
        }
    }
}