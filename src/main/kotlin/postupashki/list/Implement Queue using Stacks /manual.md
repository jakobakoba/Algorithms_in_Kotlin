## 232. Implement Queue using Stacks


```
class MyQueue() {
    val input = mutableListOf<Int>()
    val output = mutableListOf<Int>()

    fun push(x: Int) {
        input.add(x)
    }

    fun pop(): Int {
        prepare()
        return output.removeLast()
    }

    fun peek(): Int {
        prepare()
        return output.last()

    }

    fun empty(): Boolean {
        return input.isEmpty() && output.isEmpty()
    }

    fun prepare(){
        if (output.isEmpty()){
            while(input.isNotEmpty()){
                output.add(input.removeLast())
            }
        }
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

