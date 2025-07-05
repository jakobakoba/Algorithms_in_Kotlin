## 71. Simplify Path


```
class Solution {
    fun simplifyPath(path: String): String {
        val stack = mutableListOf<String>()

        val new = path.split("/")

        for (s in new){
            if (s == ".."){
                if (stack.isNotEmpty()){
                    stack.removeLast()
                }
            } else {
                if (s != "." && s.isNotEmpty()){
                    stack.add(s)
                } 
            }
        }
        return "/${stack.joinToString("/")}"
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

