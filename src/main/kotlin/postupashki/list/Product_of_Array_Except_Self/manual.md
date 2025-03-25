## 238. Product of Array Except Self


```
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size

        val prefix = IntArray(n + 1){1}
        for (i in 0 until n){
            prefix[i + 1] = nums[i] * prefix[i]
        }

        val postfix = IntArray(n + 1){1}
        for (i in n - 1 downTo 0){
            postfix[i] = postfix[i + 1] * nums[i]
        }

        val ans = IntArray(n)
        for (i in 0 until n){
            ans[i] = prefix[i] * postfix[i + 1]
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
intarray создавай с 1 потому что по дефолту они будут заполнены 0 либо первого делай 1

```