## 2429. Minimize XOR


```
class Solution {
    fun minimizeXor(num1: Int, num2: Int): Int {
        fun bitCount (num: Int ): Int {
            var count = 0
            var num = num
            while (num != 0){
                count += num and 1
                num = num ushr 1
            }
            return count
        }

        val amount = bitCount(num2)

        var result = 0
        var remaining = amount
      
        for (i in 31 downTo 0){
            if (num1 and (1 shl i) != 0){
                result = result or (1 shl i)
                remaining--
                if (remaining == 0) break
            }
        }

        for (i in 0 .. 31){
            if(remaining > 0 && result and (1 shl i) == 0){
                result = result or (1 shl i)
                remaining--
            }
        }
        return result


    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```