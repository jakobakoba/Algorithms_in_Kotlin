package leetcode.problems.daily.year_2025_3_March.Minimum_Operations_to_Make_a_Uni_Value_Grid

class Solution {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val (m,n) = listOf(grid.size, grid[0].size)

        val nums = mutableListOf<Int>()

        for (i in 0 until m){
            for (j in 0 until n){
                if (grid[i][j] % x != grid[0][0] % x ){
                    return -1
                }
                nums.add(grid[i][j])
            }
        }
        nums.sort()

        var prefix = 0
        val total = nums.sum()
        var res = Int.MAX_VALUE

        for (i in 0 until nums.size){
            val costLeft = nums[i] * i - prefix
            val costRight = total - prefix - (nums[i] * (nums.size - i) )
            val operations = (costLeft + costRight) / x
            res = minOf(res, operations)
            prefix += nums[i]
        }
        return res
    }
}

fun main(){
    println(Solution().minOperations(arrayOf(intArrayOf(146)), 86))
}