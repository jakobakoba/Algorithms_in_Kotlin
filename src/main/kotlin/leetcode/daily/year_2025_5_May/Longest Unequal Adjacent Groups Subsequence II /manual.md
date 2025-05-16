## 2901. Longest Unequal Adjacent Groups Subsequence II



``` 
class Solution {
    fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        val n = words.size

        val dp = IntArray(n){1}
        val prev = IntArray(n){-1}

        var maxLen = 1
        var maxIndex = 0
        fun hamming (a: String, b: String): Boolean {
            var count = 0
            for (i in 0 until a.length){
                if (a[i] != b[i] ){
                    count++
                    if (count > 1){
                        return false
                    }
                }
            }
            return true
        }

        for (i in 0 until n){
            for (j in 0 until i){
                if (groups[i] != groups[j] && words[i].length == words[j].length){
                    if (hamming(words[i], words[j])){
                        if (dp[j] + 1 > dp[i]){
                            dp[i] = dp[j] + 1
                            prev[i] = j
                        }
                    }
                }
            }
            if (dp[i] > maxLen){
                maxLen = dp[i]
                maxIndex = i
            }
        }

        val result = mutableListOf<String>()

        while(maxIndex != -1){
            result.add(words[maxIndex])
            maxIndex = prev[maxIndex]
        }
        result.reverse()
        return result
    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

