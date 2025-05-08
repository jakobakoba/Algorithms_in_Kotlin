## 1295. Find Numbers with Even Number of Digits


```
class Solution {
    fun findNumbers(nums: IntArray): Int {
        var ans = 0
        for (num in nums){
            var temp = num
            var counter = 0
            while(temp > 0){
                counter++
                temp = temp / 10
            }
            if (counter % 2 == 0) ans++
        }
        return ans
    }
}

```

**Оценка по времени**: О(n * d)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

