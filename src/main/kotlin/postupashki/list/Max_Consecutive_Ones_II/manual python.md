## Max Consecutive Ones II

```
from typing import (
    List,
)

class Solution:
    """
    @param nums: a list of integer
    @return: return a integer, denote  the maximum number of consecutive 1s
    """
    def find_max_consecutive_ones(self, nums: List[int]) -> int:
        # write your code here

        zeros = 0

        left = 0
        n = len(nums)

        maximum = 0

        for right in range(n):
            if nums[right] == 0:
                zeros += 1
            
            while zeros > 1:
                if nums[left] == 0:
                    zeros -= 1
                left += 1
            
            maximum = max(maximum, right - left + 1)

        return maximum

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```
бесплатная:
https://www.lintcode.com/problem/883/
 
очень похож на Longest Subarray of 1’s After Deleting One Element
```