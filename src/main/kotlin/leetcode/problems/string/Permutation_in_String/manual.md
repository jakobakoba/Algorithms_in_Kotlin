## 567. Permutation in String

```
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val n1 = s1.length
        val n2 = s2.length

        if (n1 > n2) return false

        val freqS1 = IntArray(26)
        for (c in s1){
            freqS1[c - 'a']++
        }

        val diff = IntArray(26)
        for (i in 0 until n1){
            diff[s1[i] - 'a']--
            diff[s2[i] - 'a']++
        }

        fun allZero(arr: IntArray): Boolean {
            for (x in arr){
                if (x != 0){
                    return false
                }
            }
            return true
        }

        if (allZero(diff)){
            return true
        }

        for (i in n1 until n2){
            diff[s2[i] - 'a']++
            diff[s2[i - n1] - 'a']--

            if (allZero(diff)){
                return true
            }
        }
        return false
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```