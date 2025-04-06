## 20. Valid Parentheses


```
class Solution {
    fun isValid(s: String): Boolean {
        val map = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        val stack = mutableListOf<Char>()

        for (char in s){
            if (char in map.values){
                stack.add(char)
            } else if (stack.isEmpty() || stack.removeLast() != map[char]!!)    {   
                    return false
                }
        }
        
        return stack.isEmpty()
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

