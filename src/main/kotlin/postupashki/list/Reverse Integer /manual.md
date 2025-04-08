## 7. Reverse Integer

```
const val MAX = Int.MAX_VALUE
const val MIN = Int.MIN_VALUE

class Solution {
   
    fun reverse(x: Int): Int {
        var x = x
        
        var res = 0

       

        while(x != 0){
            val digit = x % 10
            x = x / 10

            if (res > MAX / 10 || (res == MAX / 10 && digit >= MAX % 10)){
                return 0
            }
            if (res < MIN / 10 || (res == MIN / 10 && digit <= MIN % 10)){
                return 0
            }
            res = (res * 10) + digit
        }
        return res
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

