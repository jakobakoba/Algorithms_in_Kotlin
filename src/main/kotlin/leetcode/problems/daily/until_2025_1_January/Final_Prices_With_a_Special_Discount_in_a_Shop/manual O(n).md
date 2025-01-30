## 1475. Final Prices With a Special Discount in a Shop


```
class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        val stack = mutableListOf<Int>()

        for(i in prices.indices){

            while(stack.isNotEmpty() && prices[stack.last()] >= prices[i]){
                val j = stack.removeLast()
                prices[j] -= prices[i]
            }

            stack.add(i)
        }
        return prices
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```