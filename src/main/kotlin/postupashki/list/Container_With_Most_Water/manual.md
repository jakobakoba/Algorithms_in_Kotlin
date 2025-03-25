## 11. Container With Most Water


```
class Solution {
    fun maxArea(height: IntArray): Int {
        val n = height.size

        var left = 0
        var right = n - 1
        var max = Int.MIN_VALUE
        while(left < right){
            val length = right - left
            val leftWall = height[left]
            val rightWall = height[right]

            max = maxOf(max, length * minOf(leftWall, rightWall))

            if (leftWall < rightWall){
                left++
            } else {
                right--
            }
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