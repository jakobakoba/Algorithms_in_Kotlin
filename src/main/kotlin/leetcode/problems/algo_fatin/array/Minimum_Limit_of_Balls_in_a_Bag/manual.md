## 1760. Minimum Limit of Balls in a Bag


```

class Solution {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        val maximus = nums.maxOf{it}
        
        var ans = maximus
        var left = 1
        var right = maximus

        while(left <= right) {
            val mid = (left + right) / 2
            var operations = 0
            
            for (num in nums){
                operations += (num - 1) / mid
                if (operations > maxOperations) break
            }
            if (operations <= maxOperations){
                ans = minOf(ans, mid)
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return ans
    }
}


```

**Оценка по времени**: О(nlogm)


**Оценка по памяти**: О(1)


**Описание решения**
```
мы считаем какое самое маленькое число мы можем получить за допустимую операцию
n = 6 max_balls = 3  6/3 = 2 операции но это 1 операция, поэтому нужен -1, но если больше чем
ровное число 
например 7 / 3 тогда надо ceil 7/3 что будет 3 и отсюда -1. = 3 - 1 = 2
2 операции дадут 3 элемента  из 7 это 3 3 1 но было всего лишь 2 операции 6 1 и 3 3 1 

это можно обойти без ceil если сразу n - 1 / mid
6 - 1 / 3 = 5/3 = 1
7 - 1 / 3 = 6 / 3 = 2

neetcode:
ops += ceil(n / max_balls) - 1

example:
ceil (10/3) - 1 = 3.33 - 1 = 4 - 1 = 3

(10 - 1) / 3 = 9 / 3 = 3 

```