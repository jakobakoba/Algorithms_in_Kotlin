package leetcode.contests.weekly432


fun main(){
    class Solution {
        fun zigzagTraversal(grid: Array<IntArray>): List<Int> {
            val (n, m) = listOf(grid.size, grid[0].size)
            var flag = true
            val ans = mutableListOf<Int>()
            for (i in 0 until n){
                if (i % 2 == 0){
                    for (j in 0 until m step 2){
                        ans.add(grid[i][j])
                    }
                } else {
                    val edge = m % 2 == 0
                    val start = if(edge) m - 1 else m - 2
                    for (j in start downTo 0 step 2){
                        ans.add(grid[i][j])
                    }
                }
            }
            return ans
        }
    }
}