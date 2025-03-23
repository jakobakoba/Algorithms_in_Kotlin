## 42. Trapping Rain Water


```
class Solution {
    fun trap(height: IntArray): Int {
        val n = height.size
        var leftWall = height[0]
        var rightWall = height[n-1]

        var left = 0
        var right = n - 1

        var ans = 0
        while(left < right){
            if (leftWall < rightWall){
                left++
                val temp = leftWall - height[left]
                ans += if (temp < 0) 0 else temp
                leftWall = maxOf(leftWall, height[left])
            } else {
                right--
                val temp = rightWall - height[right]
                ans += if (temp < 0) 0 else temp
                rightWall = maxOf(rightWall, height[right])
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```