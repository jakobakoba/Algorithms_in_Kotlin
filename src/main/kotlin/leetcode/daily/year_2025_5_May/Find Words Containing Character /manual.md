## 2942. Find Words Containing Character



``` 
class Solution {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        
        var ans = mutableListOf<Int>()

        for (i in 0 until words.size){
            val word = words[i]
            for (char in word){
                if (char == x){
                    ans.add(i)
                    break
                }
            }
        }
        return ans
    }
}

```

**Оценка по времени**: O(n * m)


**Оценка по памяти**: O(n)


**Описание решения**
```

```

