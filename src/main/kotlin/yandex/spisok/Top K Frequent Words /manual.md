## 692. Top K Frequent Words


``` 
class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val n = words.size

        val map = mutableMapOf<String, Int>()
        for (word in words){
            map[word] = map.getOrDefault(word, 0 ) + 1
        }

        val comparator = Comparator<Pair<String, Int>>{
            a,b -> 
            if (a.second != b.second){
                a.second - b.second
            } else {
                b.first.compareTo(a.first)
            }
        }

        val pq = PriorityQueue(comparator)

        for ((word, freq) in map){
            pq.add(Pair(word, freq))

            if (pq.size > k){
                pq.poll()
            }
        }

        val ans = mutableListOf<String>()
        while(pq.isNotEmpty()){
            ans.add(pq.poll().first)
        }
        return ans.reversed()
    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

