## 916. Word Subsets


```
class Solution {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val count_2 = mutableMapOf<Char, Int>()

        for (w in words2){
            val count_w = mutableMapOf<Char,Int>()
            for (char in w){
                count_w[char] = count_w.getOrDefault(char, 0) + 1
            }
            for ((c, count) in count_w){
                count_2[c] = maxOf(count_2[c] ?: 0, count)
            }
        }

        val res = mutableListOf<String>()

        for (w in words1){
            val count_w = mutableMapOf<Char,Int>()
            for (char in w){
                count_w[char] = count_w.getOrDefault(char, 0) + 1
            }
            var flag = true

            for ((c, count) in count_2){
                if(count_w[c] ?: 0 < count){
                    flag = false
                    break
                }
            }
            if (flag){
                res.add(w)
            }
        }
        return res
        
    }
}

```

**Оценка по времени**: О()


**Оценка по памяти**: О()


**Описание решения**
```
https://www.youtube.com/watch?v=LFX61XMU22c

```