package leetcode.contests.weekly427

import kotlin.math.abs

fun main(){
    class Solution {
        fun maxRectangleArea(points: Array<IntArray>): Int {

            val pointSet = mutableSetOf<Pair<Int, Int>>()
            for ((x, y) in points) {
                pointSet.add(Pair(x, y))
            }

            var maxArea = -1

            val n = points.size
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    val (x1, y1) = points[i]
                    val (x2, y2) = points[j]

                    val edges = setOf(Pair(x1,y1), Pair(x1,y2), Pair(x2,y1), Pair(x2,y2))

                    if (x1 != x2 && y1 != y2) {

                        if (Pair(x1, y2) in pointSet && Pair(x2, y1) in pointSet) {

                            var isValid = true
                            for (x in minOf(x1, x2) .. maxOf(x1, x2)) {
                                for (y in minOf(y1, y2) .. maxOf(y1, y2)) {
                                    // if it's in pointSet and it's not my 4 edges then it's gg
                                    if (Pair(x, y) in pointSet
                                        && Pair(x,y) !in edges) {
                                        isValid = false
                                        break
                                    }
                                }
                                if (!isValid) break
                            }

                            if (isValid) {
                                val area = abs(x2 - x1) * abs(y2 - y1)
                                maxArea = maxOf(maxArea, area)
                            }
                        }
                    }
                }
            }
            return maxArea
        }
    }
}