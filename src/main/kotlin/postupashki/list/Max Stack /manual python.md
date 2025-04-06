## Max Stack

```
class MaxStack:

    def __init__(self):
        # Initialize the stack and max_stack
        self.stack = []
        self.max_stack = []

    def push(self, x: int) -> None:
        # Push the element to the stack
        self.stack.append(x)
        
        # If max_stack is empty, or x is greater than or equal to the current max, push it onto max_stack
        if not self.max_stack:
            self.max_stack.append(x)
        else:
            self.max_stack.append(max(x, self.max_stack[-1]))

    def pop(self) -> int:
        # Pop the element from both the stack and max_stack
        self.max_stack.pop()
        return self.stack.pop()

    def top(self) -> int:
        # Return the top element of the stack
        return self.stack[-1]

    def peekMax(self) -> int:
        # Return the maximum element (the top of the max_stack)
        return self.max_stack[-1]

    def popMax(self) -> int:
        # The max value is at the top of max_stack
        max_val = self.peekMax()

        # Pop from stack until we find the max value and remove it
        temp_stack = []
        while self.top() != max_val:
            temp_stack.append(self.pop())

        # Pop the max value from both stack and max_stack
        self.pop()

        # Push the elements back onto the stack
        while temp_stack:
            self.push(temp_stack.pop())

        return max_val


```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
lintcode:
https://www.lintcode.com/problem/859/description
```

