## 1832. Check if the Sentence Is Pangram



``` 
class Solution {
    fun checkIfPangram(sentence: String): Boolean {
        var chars = IntArray(26)

        for (ch in sentence){
            chars[ch - 'a']++
        }

        return chars.all{it >= 1}
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

