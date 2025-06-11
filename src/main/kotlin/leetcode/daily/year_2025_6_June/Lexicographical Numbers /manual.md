## 386. Lexicographical Numbers


``` 
class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        val ans = mutableListOf<Int>()

        var cur = 1

        repeat(n){
            ans.add(cur)

            if (cur * 10 <= n){
                cur *= 10
            } else {
                while(cur % 10 == 9 || cur + 1 > n){
                    cur /= 10
                }
                cur += 1
            }
        }
        return ans
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1) не учитывая память под результат.


**Описание решения**
```

```

