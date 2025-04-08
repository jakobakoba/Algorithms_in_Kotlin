## 122. Best Time to Buy and Sell Stock II

первый вариант
```
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = 0

        var left = 0
        var right = 1

        while(right < prices.size){
            if (prices[right] > prices[left]){
                max += prices[right] - prices[left]
            } 
            left = right
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
второй вариант
```
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0

        for (i in 1 until prices.size){
            if (prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1]
            }
        }

        return profit
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

