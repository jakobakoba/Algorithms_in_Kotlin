## 1769. Minimum Number of Operations to Move All Balls to Each Box


```
import kotlin.math.*
class Solution {
    fun minOperations(boxes: String): IntArray {
        val n = boxes.length
        var ans = IntArray(n)
        for (i in 0 until n){
            var temp = 0
            for (j in 0 until n){
                if (i != j && boxes[j] == '1'){
                    temp += abs(i - j)
                }
            }
            ans[i] = temp
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