## 1780. Check if Number is a Sum of Powers of Three

```
infix fun Int.`**`(exponent: Int): Int = toDouble().pow(exponent).toInt()


class Solution {
    fun checkPowersOfThree(n: Int): Boolean {
        
        fun backtrack(i: Int, cur: Int): Boolean {
            if (cur == n){
                return true
            }

            if (cur > n || (3 `**` i) > n){
                return false
            }

            if (backtrack(i + 1, cur + (3 `**` i))){
                return true
            }

            return backtrack(i + 1, cur)
        }

        return backtrack(0,0)
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```