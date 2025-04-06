## 470. Implement Rand10() Using Rand7()


```
/**
 * The rand7() API is already defined in the parent class SolBase.
 * fun rand7(): Int {}
 * @return a random integer in the range 1 to 7
 */
class Solution : SolBase() {
    fun rand10(): Int {
        while (true) {
            val row = rand7() - 1
            val col = rand7() - 1
            val value = row * 7 + col 

            if (value < 40) {
                return value % 10 + 1
            }
        }
    }
}

```

**Оценка по времени**: О(1) потому что
So the expected number of total rand7() calls is ~2.45, regardless of any external input.
💡 That expected number is fixed, no matter what — it doesn’t depend on any variable input.


**Оценка по памяти**: О(1)


**Описание решения**
```

```

