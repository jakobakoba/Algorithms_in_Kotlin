## 3170. Lexicographically Minimum String After Removing Stars



``` 
class Solution {
    fun clearStars(s: String): String {
        val n = s.length

        val comparator = compareBy<Pair<Char, Int>>({it.first}, {-it.second})
        val pq = PriorityQueue(comparator)

        for (i in 0 until n){
            if (s[i] == '*'){
                pq.poll()
            } else {
                pq.add(Pair(s[i], i))
            }
        }

        val ans = CharArray(n){'-'}
        while(pq.isNotEmpty()){
            val (char, index) = pq.poll()
            ans[index] = char
        }
        return ans.filter{it != '-'}.joinToString("")
    }
}

```

**Оценка по времени**: O(nlogn)


**Оценка по памяти**: O(n)


**Описание решения**
```

```

