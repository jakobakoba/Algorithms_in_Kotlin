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

         while (stack1.isNotEmpty() && stack2.isNotEmpty()) {
            if (stack2.last() > stack1.last()) {
                stack1.removeLast()
                stack2.removeLast()
            } else {
                return false
            }
        }
        return stack1.isEmpty()
    }
}



```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```