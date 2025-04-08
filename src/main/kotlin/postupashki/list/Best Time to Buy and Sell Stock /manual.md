## 121. Best Time to Buy and Sell Stock


```
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = 0

        var left = 0
        var right = 1

        while(right < prices.size){
            if (prices[right] > prices[left]){
                val profit = prices[right] - prices[left]
                max = maxOf(max, profit)
            } else {
                left = right
            }
            right++
        }
        return max

    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

