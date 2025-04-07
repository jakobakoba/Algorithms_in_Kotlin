## Design Hit Counter (Lintcode)

binary search using list
```
from collections import deque

class HitCounter:

    def __init__(self):
        self.deque = deque()

    """
    @param timestamp: the timestamp
    @return: nothing
    """
    def hit(self, timestamp: int):
        self.deque.append(timestamp)

    """
    @param timestamp: the timestamp
    @return: the count of hits in recent 300 seconds
    """
    def get_hits(self, timestamp: int) -> int:
        while self.deque and self.deque[0] <= timestamp - 300:
            self.deque.popleft()
        return len(self.deque)

```

**Оценка по времени**: О(logn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

