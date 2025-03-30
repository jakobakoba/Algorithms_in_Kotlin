## 2226. Maximum Candies Allocated to K Children


```
class Solution {
    fun maximumCandies(candies: IntArray, k: Long): Int {
        fun run(mid: Long): Boolean{
            var counter = 0L
            for (i in 0 until candies.size){
                if (candies[i] >= mid){
                    counter += candies[i] / mid
                }
            }
            return counter >= k
        }
        val sum = candies.sumOf{it.toLong()}
        if (sum < k) return 0

        var right = sum / k

        var left = 1L

        while(left <= right){
            val mid = (left + right) / 2
            
            if (run(mid)){
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return right.toInt()
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```