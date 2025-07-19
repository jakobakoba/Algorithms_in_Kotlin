## 2215. Find the Difference of Two Arrays


```
class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()

        val first = mutableListOf<Int>()
        for (num in set1){
            if (num !in set2){
                first.add(num)
            }
        }
        val second = mutableListOf<Int>()
        for (num in set2){
            if(num !in set1){
                second.add(num)
            }
        }
        return listOf(first, second)
    }
}

class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = mutableSetOf<Int>()
        val set2 = mutableSetOf<Int>()

        for (num in nums1){
            set1.add(num)
        }

        for (num in nums2){
            set2.add(num)
        }
        val ans = Array(2){mutableListOf<Int>()}
        for (num in set1){
            if (num !in set2){
                ans[0].add(num)
            }
        }
        for (num in set2){
            if (num !in set1){
                ans[1].add(num)
            }
        }
        return ans.toList()
    }
}

```

**Оценка по времени**: О(nm)


**Оценка по памяти**: О(nm)


**Описание решения**
```

```