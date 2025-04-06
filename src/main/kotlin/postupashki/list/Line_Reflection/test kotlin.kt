package postupashki.list.Line_Reflection


fun main() {
    class Solution {
        fun isReflected(points: List<IntArray>): Boolean {
            val pointSet = mutableSetOf<Pair<Int,Int>>()
            var minX = Int.MAX_VALUE
            var maxX = Int.MIN_VALUE

            for (point in points) {
                minX = minOf(minX, point[0])
                maxX = maxOf(maxX, point[0])
                pointSet.add(Pair(point[0], point[1]))
            }

            val mid = minX + maxX
            for (point in points) {
                if (Pair(mid - point[0], point[1]) !in pointSet){
                    return false
                }
            }
            return true
        }
    }

    println(Solution().isReflected(listOf(intArrayOf(1,1), intArrayOf(-1,1))))
    println(Solution().isReflected(listOf(intArrayOf(1,1), intArrayOf(-1,-1))))

}

/*
intarray ищет по референсу и поэтому получаю неправильный ответ
надо использовать Pair, он ищет value based и поэтому найдет
 */