## 3191. Minimum Operations to Make Binary Array Elements Equal to One I


```
class Solution:
    def minOperations(self, nums: List[int]) -> int:

        def flip(i):
            nums[i] = 0 if nums[i] else 1

        n = len(nums)
        ans = 0
        for i in range(n - 2):
            if nums[i] == 0:
                flip(i)
                flip(i + 1)
                flip(i + 2)
                ans += 1

        if nums[-1] == 0 or nums[-2] == 0: 
            return -1

        return ans

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```