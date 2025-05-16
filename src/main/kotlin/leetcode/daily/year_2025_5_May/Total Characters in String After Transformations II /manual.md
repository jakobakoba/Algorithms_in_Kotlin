## 3337. Total Characters in String After Transformations II



``` 
class Solution {
    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        val MOD = 1000000007

        val initial = LongArray(26){0}
        for (c in s){
            initial[c - 'a']++
        }

        val transition = Array(26){LongArray(26){0}}
        for (i in 0 until 26){
            val count = nums[i]
            for (k in 1 .. count){
                val j = (i + k) % 26
                transition[j][i] = transition[j][i] + 1
            }
        }

        fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray>{
            var result = Array(26){LongArray(26){0}}
            for (i in 0 until 26){
                for (k in 0 until 26){
                    for (j in 0 until 26){
                        result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD
                    }
                }
            }
            return result
        }

        fun matrixExpo(mat: Array<LongArray>): Array<LongArray>{
            var result = Array(26){i -> LongArray(26){if (i == it) 1L else 0L}}
            var cur = mat
            var expo = t
            while(expo > 0){
                if (expo % 2 == 1){
                    result = multiply(result, cur)
                }
                cur = multiply(cur, cur)
                expo /= 2
            }
            return result
        }

        val matrixPower = matrixExpo(transition)

        val result = LongArray(26){0}
        for (j in 0 until 26){
            for (k in 0 until 26){
                result[j] = (result[j] + initial[k] * matrixPower[j][k]) % MOD
            }
        }
        return (result.sum() % MOD).toInt()
    }
}
```

**Оценка по времени**: O(|s| + log t).


**Оценка по памяти**: O(1)


**Описание решения**
```

```
