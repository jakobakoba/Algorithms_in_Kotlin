package leetcode.contests.weekly443
//Longest Palindrome After Substring Concatenation I


fun main(){
        class Solution {
            fun longestPalindrome(s: String, t: String): Int {
                var max = 1
                val n = s.length
                val m = t.length

                for (i in 0..n) {
                    for (j in i..n) {
                        val first = s.substring(i, j)

                        for (x in 0..m) {
                            for (y in x..m) {
                                val second = t.substring(x, y)
                                val combined = first + second

                                if (combined.isEmpty()) continue

                                var left = 0
                                var right = combined.length - 1
                                var isPalindrome = true
                                while (left < right) {
                                    if (combined[left] != combined[right]) {
                                        isPalindrome = false
                                        break
                                    }
                                    left++
                                    right--
                                }
                                if (isPalindrome) {
                                    max = maxOf(max, combined.length)
                                }
                            }
                        }
                    }
                }
            return max
        }
    }
}
