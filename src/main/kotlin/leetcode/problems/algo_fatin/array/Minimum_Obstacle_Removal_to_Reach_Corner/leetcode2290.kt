package leetcode.problems.algo_fatin.array.Minimum_Obstacle_Removal_to_Reach_Corner

import java.util.*

class Solution{
    fun minimumObstacles(grid: Array<IntArray>): Int {
        val (ROWS, COLS) = intArrayOf(grid.size, grid[0].size)

        val deque: Deque<Triple<Int,Int,Int>> = LinkedList()
        deque.addFirst(Triple(0,0,0))

        val visited = mutableSetOf<Pair<Int,Int>>()

        while(deque.isNotEmpty()){

            val (obstacles, r, c) = deque.poll()

            if (r == ROWS - 1 && c == COLS - 1) {
                return obstacles
            }

            val neighbors = listOf(intArrayOf(r - 1, c), intArrayOf(r + 1, c), intArrayOf(r, c - 1), intArrayOf(r, c + 1))

            for ((nr, nc) in neighbors){
                if ( Pair(nr, nc) in visited || nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS ){
                    continue
                }
                if (grid[nr][nc] == 0){
                    deque.addFirst(Triple(obstacles, nr, nc))
                } else if (grid[nr][nc] == 1){
                    deque.addLast(Triple(obstacles + 1, nr, nc))
                }

                visited.add(Pair(nr, nc))
            }
        }
        throw IllegalStateException(" ")
    }
}

