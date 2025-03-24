## 167. Two Sum II - Input Array Is Sorted


```
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val n = numbers.size

        var left = 0
        var right = n - 1

        while(left < right){
            val sum = numbers[left] + numbers[right]
            if (sum == target){
                return intArrayOf(left + 1, right + 1)
            }
            if (sum < target){
                left++
            } else {
                right--
            }
        }
        throw IllegalStateException(" ")
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```