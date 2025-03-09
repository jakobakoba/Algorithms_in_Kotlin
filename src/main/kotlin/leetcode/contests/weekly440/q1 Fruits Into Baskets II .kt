package leetcode.contests.weekly440

//Fruits Into Baskets II

fun main(){
    class Solution {
        fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
            val n = fruits.size
            val m = baskets.size
            val done = BooleanArray(m)
            var count = 0
            for (i in 0 until n){
                var placed = false
                for (j in 0 until m){
                    if (done[j] == false && fruits[i] <= baskets[j]){
                        placed = true
                        done[j] = true
                        break
                    }
                }
                if (placed) count++
            }
            return n - count
        }
    }
}