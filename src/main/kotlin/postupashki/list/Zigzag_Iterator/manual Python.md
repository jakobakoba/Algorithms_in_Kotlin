## 540 · Zigzag Iterator (Lintcode)

```
from typing import List
class ZigzagIterator:

    def __init__(self, v1: List[int], v2: List[int]):
        self.current = 0
        self.indices = [0] * 2
        self.vectors = [v1, v2]

    def _next(self) -> int:
        vector = self.vectors[self.current]
        index = self.indices[self.current]
        result = vector[index]
        self.indices[self.current] = index + 1
        self.current = (self.current + 1) % 2
        return result

    def hasNext(self) -> bool:
        start = self.current
        while self.indices[self.current] == len(self.vectors[self.current]):
            self.current = (self.current + 1) % 2
            if self.current == start:
                return False
        return True


# Your ZigzagIterator object will be instantiated and called as such:
# solution, result = ZigzagIterator(v1, v2), []
# while solution.hasNext(): result.append(solution.next())
# Output result

```

**Оценка по времени**: О(n + m)


**Оценка по памяти**: О(1)


**Описание решения**
```
https://www.lintcode.com/problem/540/
```