## 71. Simplify Path


```
class Solution {
    fun simplifyPath(path: String): String {
        val path = path + "/"
        val stack = mutableListOf<String>()

        var cur = ""
        for (char in path){
            if (char == '/'){
                if (cur == ".."){
                    if (stack.isNotEmpty()){
                        stack.removeLast()
                    }
                } else if (cur != "" && cur != "."){
                    stack.add(cur)
                }
                cur = ""
            } else {
                cur += char
            }
        }
        return "/" + stack.joinToString("/")
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
будь осторожен:
сравнение char and "/" будет ошибка, правильнее будет char == '/'
прежде чем вытаскивать со стека проверь наличие не пуст ли стек
```

