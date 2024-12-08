package leetcode.contests.weekly427

fun main(){
    class Solution {
        fun maxRectangleArea(points: Array<IntArray>): Int {

            val pointSet = mutableSetOf<Pair<Int, Int>>()
            for ((x, y) in points) {
                pointSet.add(Pair(x, y))
            }

            var maxArea = -1


            for (i in points.indices) {
                for (j in i + 1 until points.size) {
                    val (x1, y1) = points[i]
                    val (x2, y2) = points[j]


                    if (x1 != x2 && y1 != y2) {

                        if (Pair(x1, y2) in pointSet && Pair(x2, y1) in pointSet) {

                            var isValid = true
                            for (x in minOf(x1, x2) .. maxOf(x1, x2)) {
                                for (y in minOf(y1, y2) .. maxOf(y1, y2)) {
                                    if (Pair(x, y) in pointSet && Pair(x,y) != Pair(x1,y1) &&
                                        Pair(x,y) != Pair(x1,y2) &&
                                        Pair(x,y) != Pair(x2, y1) &&
                                        Pair(x,y) != Pair(x2,y2)) {
                                        isValid = false
                                        break
                                    }
                                }
                                if (!isValid) break
                            }


                            if (isValid) {
                                val area = kotlin.math.abs(x2 - x1) * kotlin.math.abs(y2 - y1)
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