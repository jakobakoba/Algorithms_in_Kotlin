## 43. Multiply Strings



``` 
class Solution {
    fun multiply(num1: String, num2: String): String {

        if (num1 == "0" || num2 == "0") return "0"
        val n = num1.length
        val m = num2.length

        val nums = IntArray(n + m)

        for (i in n - 1 downTo 0){
            for (j in m - 1 downTo 0){
                val mul = (num1[i] - '0') * (num2[j] - '0')
                val p1 = i + j
                val p2 = i + j + 1

                val sum = mul + nums[p2]

                nums[p2] = sum % 10
                nums[p1] += sum / 10
            }
        }

        val sb = StringBuilder()
        for (i in nums){
            if (sb.isEmpty() && i == 0){
                continue
            }
            sb.append(i)
        }
        return sb.toString()
    }
}

```

**Оценка по времени**: O(n * m)


**Оценка по памяти**:  O(n + m)


**Описание решения**
```

```

