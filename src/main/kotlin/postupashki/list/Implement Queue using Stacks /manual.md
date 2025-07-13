## 232. Implement Queue using Stacks


```
class MyQueue() {
    val stack1 = mutableListOf<Int>()
    val stack2 = mutableListOf<Int>()

    fun push(x: Int) {
        stack1.add(x)
    }

    fun pop(): Int {
        if (stack2.isEmpty()){
            while(stack1.isNotEmpty()){
                stack2.add(stack1.removeLast())
            }
        }
        return stack2.removeLast()
    }

    fun peek(): Int {
        if (stack2.isEmpty()){
            while(stack1.isNotEmpty()){
                stack2.add(stack1.removeLast())
            }
        }
        return stack2.last()
    }

    fun empty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

