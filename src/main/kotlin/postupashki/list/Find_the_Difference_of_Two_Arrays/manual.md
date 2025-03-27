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

```

**Оценка по времени**: О(nm)


**Оценка по памяти**: О(nm)


**Описание решения**
```

```