## 242. Valid Anagram

sort
```
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sorted1 = s.toList().sorted()
        val sorted2 = t.toList().sorted()

        var p1 = 0
        var p2 = 0
        while(p1 < s.length && p2 < t.length){
            if (sorted1[p1] != sorted2[p2]){
                return false
            }
            p1++
            p2++
        }
        return p1 == s.length && p2 == t.length
    }
}

можно этот же код написать покороче:
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sorted1 = s.toList().sorted()
        val sorted2 = t.toList().sorted()

        return sorted1 == sorted2
    }
}


```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```
intarray
```
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val arr = IntArray(26)
        if (s.length != t.length) return false

        for(i in 0 until s.length){
            arr[s[i] - 'a']++
            arr[t[i] - 'a']--
        }

        return arr.all{it == 0}
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```