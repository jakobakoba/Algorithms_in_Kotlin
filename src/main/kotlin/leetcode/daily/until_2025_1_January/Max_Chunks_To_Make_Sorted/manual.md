## 769. Max Chunks To Make Sorted


```
class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        var ans = 0

        var curMax = -1

        for (i in 0 until arr.size){
            curMax = maxOf(curMax, arr[i])

            if (curMax == i){
                ans += 1
            }
        }
        return
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```