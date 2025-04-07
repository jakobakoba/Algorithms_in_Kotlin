## 150. Evaluate Reverse Polish Notation


```
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = mutableListOf<Int>()

        val operators = setOf("+", "-", "*", "/")

        for (char in tokens){
            if (char in operators){
                val second = stack.removeLast()
                val first = stack.removeLast()

                val result = when (char){
                    "+" -> {
                        first + second
                    }
                    "-" -> {
                        first - second
                    }
                    "*" -> {
                        first * second
                    }
                    "/" -> {
                        first / second
                    } else -> throw IllegalStateException("")
                }
                stack.add(result)
            } else {
                stack.add(char.toString().toInt())
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

