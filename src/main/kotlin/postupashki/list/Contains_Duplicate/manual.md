## 217. Contains Duplicate


```
set:
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for (num in nums){
            if (num in set){
                return true
            }
            set.add(num)
        }
        return false
    }
}

sort:
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()

        for (i in 1 until nums.size){
            if (nums[i] == nums[i-1]){
                return true
            }
        }
        return false
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
тут надо чем-то пожертвовать либо памятью используя сет тогда время будет O(n)
либо жертвуешь time используя сортировку тогда память будет O(1)


```