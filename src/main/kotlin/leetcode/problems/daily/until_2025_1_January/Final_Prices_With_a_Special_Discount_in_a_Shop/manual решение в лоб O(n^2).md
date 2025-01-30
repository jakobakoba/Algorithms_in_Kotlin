## 1475. Final Prices With a Special Discount in a Shop


```
class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        val n = prices.size
        val ans = IntArray(n)

        for(i in 0 until prices.size){
            var done = false
            for(j in i + 1 until prices.size){
                if (prices[j] <= prices[i]){
                    ans[i] = prices[i] - prices[j]
                    done = true
                    break
                }

            }
            if (!done){
                ans[i] = prices[i]
            }
            
        }
        return ans
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```