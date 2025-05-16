## 2900. Longest Unequal Adjacent Groups Subsequence I



``` 
class Solution {
    fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        val ans = mutableListOf<String>()
        ans.add(words[0])
        var prev = groups[0]
        
        for (i in 1 until groups.size){
            if (groups[i] != groups[i - 1]){
                ans.add(words[i])
                prev = groups[i]
            }
        }

        return ans
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(n)


**Описание решения**
```

```

