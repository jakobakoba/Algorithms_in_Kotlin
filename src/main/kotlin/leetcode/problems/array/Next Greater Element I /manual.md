## 496. Next Greater Element I

indices
```
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val indices = mutableMapOf<Int,Int>()
        val n = nums1.size
        for (i in 0 until n){
            indices[nums1[i]] = i
        }

        val m = nums2.size
        val ans = IntArray(n){-1}
        for (i in 0 until m){
            if (nums2[i] !in indices){
                continue
            }

            for (j in i + 1 until m){
                if (nums2[j] > nums2[i]){
                    val index = indices[nums2[i]]!!
                    ans[index] = nums2[j]
                    break
                }
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(m^2)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

monotonic stack
```
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val indices = mutableMapOf<Int,Int>()
        val n = nums1.size
        for (i in 0 until n){
            indices[nums1[i]] = i
        }

        val stack = mutableListOf<Int>()
        val ans = IntArray(n){-1}
        for (num in nums2){
            while(stack.isNotEmpty() && num > stack.last()){
                val value = stack.removeLast()
                val index = indices[value]!!
                ans[index] = num
            }

            if(num in indices){
                stack.add(num)
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(n + m)


**Оценка по памяти**: О(n + m)


**Описание решения**
```

```

