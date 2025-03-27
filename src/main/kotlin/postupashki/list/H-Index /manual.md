## 274. H-Index

sort
```
class Solution {
    fun hIndex(citations: IntArray): Int {
        val n = citations.size

        citations.sort()

        var h = 0
        for (i in n - 1 downTo 0){
            val papers = n - i
            val potentialH = minOf(citations[i], papers)
            if (potentialH > h){
                h = potentialH
            }
        }
        return h
    }
}   


```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(1)


**Описание решения**
```
мы идем справа налево в отсортированном массиве и поэтому все последующие левые они будут меньше
чем текущий. 
меньший будет либо citations[i] либо количество цитат
```

bucket
```
class Solution {
    fun hIndex(citations: IntArray): Int {
        val n = citations.size
        val bucket = IntArray(n + 1)
        
        for (c in citations){
            if(c >= n){
                bucket[n]++
            } else {
                bucket[c]++
            }
        }
        
        var count = 0
        for (i in n downTo 0){
            count += bucket[i]
            if(count >= i){
                return i
            }
        }
        return 0
    }
}


```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```
