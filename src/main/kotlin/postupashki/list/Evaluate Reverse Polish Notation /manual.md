## 150. Evaluate Reverse Polish Notation


```
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = mutableListOf<Int>()

        for (element in tokens){
            if (element in "+-*/"){
                val first = stack.removeLast()
                val second = stack.removeLast()
                when(element){
                    "+" -> {
                        stack.add(second + first)
                    }
                    "-" -> {
                        stack.add(second - first)
                    }
                    "*" -> {
                        stack.add(second * first)
                    }
                    "/" -> {
                        stack.add(second / first)
                    }
                }
            } else {
                stack.add(element.toInt())
            }
        }
        return stack.removeLast()
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
не перепутай first and second когда вытаскиваешь цифры из стека
```

