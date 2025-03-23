## 42. Trapping Rain Water


```
class Solution {
    fun trap(height: IntArray): Int {
        val n = height.size

        val left = IntArray(n)
        val right = IntArray(n)

        var leftMax = 0
        for (i in 0 until n){
            leftMax = maxOf(leftMax, height[i])
            left[i] = leftMax
        }

        var rightMax = 0
        for (i in n - 1 downTo 0){
            rightMax = maxOf(rightMax, height[i])
            right[i] = rightMax
        }

        val minimal = IntArray(n)
        for (i in 0 until n){
            minimal[i] = minOf(left[i], right[i])
        }
        var ans = 0
        for (i in 0 until n){
            val temp = minimal[i] - height[i]
            ans += if (temp < 0) 0 else temp
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```