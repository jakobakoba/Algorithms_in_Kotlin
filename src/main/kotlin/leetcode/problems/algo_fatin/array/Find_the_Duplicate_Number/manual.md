## 287. Find the Duplicate Number


```
class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[0]

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while(slow != fast)

        slow = nums[0]

        while(slow != fast){
            slow = nums[slow]
            fast=  nums[fast]
        }
        return slow
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```