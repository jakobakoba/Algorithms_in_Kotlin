## 919 · Meeting Rooms II (LINTCODE)

```
from typing import (
    List,
)
from lintcode import (
    Interval,
)

"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def min_meeting_rooms(self, intervals: List[Interval]) -> int:
        # Write your code here
        starters = []
        enders = []
        maximum = 0
        temp = 0
        for interval in intervals:
            starters.append(interval.start)
            enders.append(interval.end)

        starters.sort()
        enders.sort()
        p1 = 0
        p2 = 0
        while p1 < len(intervals):
            if starters[p1] < enders[p2]:
                temp += 1
                p1 += 1
            elif starters[p1] >= enders[p2]:
                temp -= 1
                p2 += 1
            maximum = max(maximum, temp)

        return maximum

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```
бесплатная:
https://www.lintcode.com/problem/919/
```