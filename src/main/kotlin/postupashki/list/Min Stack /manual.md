## 155. Min Stack


```
class MinStack() {
    val stack = mutableListOf<Int>()
    val minStack = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        val minimal = minOf(`val`, if (minStack.isNotEmpty()) minStack.last() else `val`)
        minStack.add(minimal)
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

```

**Оценка по времени**: О(1)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

