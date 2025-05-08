## 790. Domino and Tromino Tiling


```
class Solution {
    fun numTilings(n: Int): Int {
        val MOD = 1000000007

        val full = LongArray(n + 1)
        val part = LongArray(n + 1)

        full[0] = 1
        full[1] = 1
        if (n >= 2){
            full[2] = 2
        }
        

        part[0] = 0
        part[1] = 0
        if (n >= 2){
            part[2] = 1
        }

        for (i in 3 .. n){
            part[i] = (part[i-1] + full[i-2]) % MOD
            full[i] = (full[i-1] + full[i-2] + 2 * part[i-1]) % MOD
        }
        return full[n].toInt()
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)
можно сделать O(1)


**Описание решения**
```

```

