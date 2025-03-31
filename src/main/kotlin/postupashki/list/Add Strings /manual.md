## 415. Add Strings


```
class Solution {
    fun addStrings(num1: String, num2: String): String {
        val n = num1.length
        val m = num2.length

        val deque: Deque<Char> = LinkedList()
        val reversed1 = num1.reversed()
        val reversed2 = num2.reversed()
        var p1 = 0
        var p2 = 0
        var leftover = 0
        while(p1 < n || p2 < m){
            var left = if (p1 < n) reversed1[p1] - '0' else 0
            var right = if (p2 < m) reversed2[p2] - '0' else 0

            val sum = left + right + leftover
            val num = sum % 10
            leftover = sum / 10
            deque.addFirst((num + '0'.code).toChar())
            p1++
            p2++
        }
        if (leftover > 0){
            deque.addFirst((leftover + '0'.code).toChar())
        }
        return deque.joinToString("")

    }
}

```

**Оценка по времени**: О(max(n,m))


**Оценка по памяти**: О(max(n,m))


**Описание решения**
```

```

