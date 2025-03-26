## 220. Contains Duplicate III


```
class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
        val treeSet = TreeSet<Int>()

        val n = nums.size

        for (i in 0 until n){
            val ceiling = treeSet.ceiling(nums[i] - valueDiff)

            if (ceiling != null && ceiling <= nums[i] + valueDiff){
                return true
            }

            treeSet.add(nums[i])

            if (i >= indexDiff){
                treeSet.remove(nums[i - indexDiff])
            }
        }
        return false
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```