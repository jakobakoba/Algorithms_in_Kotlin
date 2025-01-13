## 2116. Check if a Parentheses String Can Be Valid


```
class Solution {
    fun canBeValid(s: String, locked: String): Boolean {
        val stack1 = mutableListOf<Int>()
        val stack2 = mutableListOf<Int>()

        

        val n = s.length
        if (n % 2 != 0) return false

        for (i in 0 until n){
            if (locked[i] == '0'){
                stack2.add(i)
            }
            else if (s[i] == '('){
                stack1.add(i)
            } else if (s[i] == ')'){
                if (stack1.isNotEmpty()){
                    stack1.removeLast()
                } else if (stack2.isNotEmpty()){
                    stack2.removeLast()
                } else {
                    return false
                }
            }
        }

        if (stack1.isNotEmpty() && stack2.isNotEmpty()){
            for (i in stack1.size - 1 downTo 0){
                if (stack2.isNotEmpty() && stack2.last() > stack1.last()){
                    stack1.removeLast()
                    stack2.removeLast()
                } else {
                    return false
                }
            }
        }
        return true    
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```