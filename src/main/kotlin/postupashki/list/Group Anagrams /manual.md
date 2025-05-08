## 49. Group Anagrams


```
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for (s in strs){
            val key = s.toCharArray().sorted().joinToString("")
            map.computeIfAbsent(key){mutableListOf()}.add(s)
        }

        return map.values.toList()
    }
}

```

**Оценка по времени**: О(n*klogk)
n is the number of strings in the array.
k is the average length of the strings.


**Оценка по памяти**: О(n*k)
n is the number of strings.
k is the average length of the strings.


**Описание решения**
```
sorted ждет charArray и поэтому toCharArray(), sorted не хочет String
```

