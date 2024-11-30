package leetcode.problems.graph_tree_grid.Minimum_Time_to_Visit_a_Cell_In_a_Grid

import java.util.*
import kotlin.math.abs
class Solution {
    fun minimumTime(grid: Array<IntArray>): Int {
        val pq = PriorityQueue<Triple<Int,Int,Int>>(compareBy{it.first}) // value of cur, r, c

        val (rows, cols) = intArrayOf(grid.size, grid[0].size)

        if(minOf(grid[0][1], grid[1][0]) > 1) return -1

        pq.add(Triple(0,0,0))

        val visited = mutableSetOf<Pair<Int,Int>>()

        while(pq.isNotEmpty()){
            val (t, r, c) = pq.poll()

            if (r == rows - 1 && c == cols - 1) return t

            val neighbors = listOf(intArrayOf(r + 1, c), intArrayOf(r -1 , c), intArrayOf(r, c + 1),
                intArrayOf(r, c -1))

            for((nr, nc) in neighbors){
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || Pair(nr, nc) in visited){
                    continue
                }
                var wait = 0
                if (abs(grid[nr][nc] - t) % 2 == 0){
                    wait = 1
                }
                val nTime = maxOf(grid[nr][nc] + wait, t + 1)
                pq.add(Triple( nTime, nr, nc))
                visited.add(Pair(nr,nc))
            }
        }
        throw IllegalStateException(" ")
    }
}


fun main(){
    println(Solution().minimumTime(arrayOf(intArrayOf(0,1,3,2), intArrayOf(5,1,2,5), intArrayOf(4,3,8,6))))
}