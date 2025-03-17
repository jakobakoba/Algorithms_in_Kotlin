## 2206. Divide Array Into Equal Pairs


```
class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        map = {}

        for i in nums:
            if i in map:
                map[i] += 1
            else:
                map[i] = 1
        
        n = len(nums) / 2

        for i in map.values():
            if i % 2 != 0:
                return False
            
        return True

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```