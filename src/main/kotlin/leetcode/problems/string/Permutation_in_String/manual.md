## 567. Permutation in String

```
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val map1 = mutableMapOf<Char,Int>()
        for (char in s1){
            map1[char] = map1.getOrDefault(char, 0) + 1
        }

        val map2 = mutableMapOf<Char,Int>()

        for (i in 0 until s1.length){
            map2[s2[i]] = map2.getOrDefault(s2[i], 0) + 1
        }

        if (map1 == map2) return true
        

        for (i in s1.length until s2.length){
            val char = s2[i]

            map2[char] = map2.getOrDefault(char, 0) + 1

            val left = s2[i - s1.length]
            if (left in map2){
                map2[left] = map2[left]!! - 1
                if (map2[left]!! == 0){
                    map2.remove(left)
                }
            }
            if (map1 == map2) return true
        }
        return false
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
class Solution {
fun checkInclusion(s1: String, s2: String): Boolean {

    if(s1.length > s2.length ) return false


    val need = IntArray(26)
    val windows = IntArray(26)

    for(i in s1){
        need[i - 'a']++
    }

    for(i in s2.indices){
        windows[s2[i] - 'a']++
        if(i >= s1.length){
            windows[s2[i - s1.length] - 'a']--
        }

        if(need.contentEquals(windows)){
            return true 
        }
    }
    return false 
}
}
```