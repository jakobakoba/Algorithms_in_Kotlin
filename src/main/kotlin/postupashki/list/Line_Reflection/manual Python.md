## 908 · Line Reflection (Lintcode)

```
from typing import (
    List,
)

class Solution:
    """
    @param points: n points on a 2D plane
    @return: if there is such a line parallel to y-axis that reflect the given points
    """
    def is_reflected(self, points: List[List[int]]) -> bool:
        # Write your code here

        minX = float("inf")
        maxX = float("-inf")

        pointSet = set()

        for s in points:
            minX = min(minX, s[0])
            maxX = max(maxX, s[0])
            pointSet.add((s[0], s[1]))

        mid = minX + maxX
        for s in points:
            if ((mid - s[0], s[1]) not in pointSet):
                return False

        return True

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
```