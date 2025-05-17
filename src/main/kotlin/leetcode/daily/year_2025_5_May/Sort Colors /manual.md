## 75. Sort Colors



``` 
class Solution {
    fun sortColors(nums: IntArray): Unit {
        val n = nums.size

        var left = 0
        var right = n - 1
        var i = 0

        while(i <= right){
            if (nums[i] == 0){
                nums[left] = nums[i].also{nums[i] = nums[left]}
                left++
                i++
            } else if (nums[i] == 2){
                nums[right] = nums[i].also{nums[i] = nums[right]}   
                right--
            } else {
                i++
            }
        }
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

