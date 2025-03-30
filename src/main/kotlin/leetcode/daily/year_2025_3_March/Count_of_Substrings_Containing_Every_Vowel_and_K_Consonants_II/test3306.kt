package leetcode.daily.year_2025_3_March.Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II

class Solution {

    fun countOfSubstrings(word: String, k: Int): Long {

        fun atLeastK(k :Int ) : Long {
            val vowel = mutableMapOf<Char, Int>()
            var non_vowel = 0
            var res = 0L
            var l = 0
            for (r in 0 until word.length){
                if(word[r] in "aeiou"){
                    vowel[word[r]] = vowel.getOrDefault(word[r], 0) + 1
                } else {
                    non_vowel += 1
                }
                while(vowel.size == 5 && non_vowel >= k){
                    res += word.length - r
                    if (word[l] in "aeoiu"){
                        vowel[word[l]] = vowel[word[l]]!! - 1
                    } else {
                        non_vowel -= 1
                    }
                    if (vowel[word[l]] == 0){
                        vowel.remove(word[l])
                    }
                    l++
                }
            }
            return res
        }

        return atLeastK(k) - atLeastK(k + 1)
    }
}

fun main(){
    println(Solution().countOfSubstrings("aadieuoh", 1))
}