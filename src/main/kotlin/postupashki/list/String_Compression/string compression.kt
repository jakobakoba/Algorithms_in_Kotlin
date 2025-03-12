package postupashki.list.String_Compression

class Solution {
    fun compress(chars: CharArray): Int {
        val n = chars.size
        var pointer = 0
        var size = 0
        for (char in 0 until n){
            size++
            if (char == n - 1 || chars[char] != chars[char + 1]){
                chars[pointer] = chars[char]
                pointer++
                if(size > 1){
                    val str = size.toString()
                    for (digit in str){
                        chars[pointer] = digit
                        pointer++
                    }
                }
                size = 0
            }
        }
        return pointer
    }
}

fun main(){
    println(Solution().compress(charArrayOf('a')))
}