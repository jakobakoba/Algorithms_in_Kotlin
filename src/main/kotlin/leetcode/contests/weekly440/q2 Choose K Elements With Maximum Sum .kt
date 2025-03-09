package leetcode.contests.weekly440
import java.util.PriorityQueue

//Choose K Elements With Maximum Sum
fun main(){

    class Solution {
        fun findMaxSum(nums1: IntArray, nums2: IntArray, k: Int): LongArray {
            val n = nums1.size
            val pairs = Array(n) { i -> Triple(nums1[i], nums2[i], i) }
            pairs.sortBy { it.first }

            val heap = PriorityQueue<Int>(compareBy { it })
            val prefixSums = LongArray(n + 1) { 0L }
            var sum = 0L

            for (i in 0 until n) {
                heap.add(pairs[i].second)
                sum += pairs[i].second
                if (heap.size > k) {
                    sum -= heap.poll()
                }

                prefixSums[i + 1] = sum
            }

            val answer = LongArray(n)
            for (i in 0 until n) {
                val target = nums1[i]
                var left = 0
                var right = n - 1
                while (left <= right) {
                    val mid = left + (right - left) / 2
                    if (pairs[mid].first < target) {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
                answer[i] = if (right >= 0) prefixSums[right + 1] else 0L
            }

            return answer
        }
    }
}