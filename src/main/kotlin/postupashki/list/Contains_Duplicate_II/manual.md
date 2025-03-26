## 219. Contains Duplicate II


```
class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int,Int>()

        val n = nums.size

        for (i in 0 until n){
            if (nums[i] in map){
                if(i - map[nums[i]]!! <= k){
                    return true
                }
            } 
            map[nums[i]] = i

        }
        return false
    }
}

another way (sliding window = set):
class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        
        var left = 0

        val window = mutableSetOf<Int>()

        for (right in 0 until nums.size){

            if (right - left > k){
                window.remove(nums[left])
                left++
            }

            if (nums[right] in window){
                return true
            }
            window.add(nums[right])
        }
        return false
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
коварная задача
- не забудь !! в map
- индекс надо делать ближе к i и поэтому всегда перезаписывай
map[nums[i]] = i даже если nums[i] есть в map. Надо делать ближе!

```