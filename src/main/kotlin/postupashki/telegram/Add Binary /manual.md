## 67. Add Binary


```
class Solution {
    fun addBinary(a: String, b: String): String {
        var i = a.length - 1
        var j = b.length - 1

        var carry = 0
        val sb = StringBuilder()
        while(i >= 0 || j >= 0 || carry != 0){
            val first = if (i >= 0) a[i] - '0' else 0
            val second = if (j >= 0) b[j] - '0' else 0
            var sum = first + second + carry
            sb.append(sum % 2)
            carry = sum / 2
            i--
            j--
        }
        return sb.reverse().toString()
    }
}

```

**Оценка по времени**: О(max(n,m))


**Оценка по памяти**: О(max(n,m))


**Описание решения**
```

```

