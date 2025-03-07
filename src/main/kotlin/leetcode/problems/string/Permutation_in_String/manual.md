## 567. Permutation in String

```
class Solution {
    fun isZero(arr: IntArray): Boolean {
        for (num in arr){
            if (num != 0){
                return false
            }
        }
        return true
    }
    fun checkInclusion(s1: String, s2: String): Boolean {
        val diff = IntArray(26)
        val (n1, n2) = listOf(s1.length, s2.length)

        if (n1 > n2) return false

        for (i in 0 until n1){
            diff[s1[i] - 'a']--
            diff[s2[i] - 'a']++
        }
        
        var found = isZero(diff)

        for (i in n1 until n2){
            diff[s2[i] - 'a']++
            diff[s2[i - n1] - 'a']--
            if (isZero(diff)) {
                found = true
                break
            }
        }
        return found
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```