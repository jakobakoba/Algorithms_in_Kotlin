## 71. Simplify Path


```
class Solution {
    fun simplifyPath(path: String): String {
        val stack = mutableListOf<String>()

        val parsed = path.split("/")

        for (text in parsed){
            if (text == ".."){
                if (stack.isNotEmpty()){
                    stack.removeLast()
                }
            } else if (text != "." && text != ""){
                stack.add(text)
            }
        }
        val res = stack.joinToString("/")
        return "/$res"
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

