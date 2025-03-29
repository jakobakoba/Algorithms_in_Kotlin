package postupashki.list.`Longest Substring with At Most Two Distinct Characters`

fun main(){
    fun findLength(s: String): Int {
        val map = mutableMapOf<Char, Int>()

        var left = 0
        var max = 0

        for (right in 0 until s.length){
            val char = s[right]
            map[char] = map.getOrDefault(char, 0) + 1

            while(map.size > 2){
                val leftChar = s[left]
                map[leftChar] = map[leftChar]!! - 1
                if (map[leftChar]!! == 0){
                    map.remove(leftChar)
                }
                left++
            }
            max = maxOf(max, right - left + 1)
        }
        return max
    }

    println(findLength("eceba")) // 3
    println(findLength("aaa")) // 3
}