## 2033. Minimum Operations to Make a Uni-Value Grid


```
class Solution {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val (m, n) = listOf(grid.size, grid[0].size)
        val nums = mutableListOf<Int>()

        for (i in 0 until m){
            for (j in 0 until n){
                val number = grid[i][j]
                nums.add(number)
                if (abs(number - grid[0][0]) % x != 0) {
                    return -1
                }
            }
        }
        nums.sort()
        var mid = nums[nums.size / 2]
        var ans = 0
        for (num in nums){
            ans += abs(mid - num) / x
        }
        return ans
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

prefix:
```
class Solution {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val (m,n) = listOf(grid.size, grid[0].size)

        val nums = mutableListOf<Int>()

        for (i in 0 until m){
            for (j in 0 until n){
                if (grid[i][j] % x != grid[0][0] % x ){
                    return -1
                }
                nums.add(grid[i][j])
            }
        }
        nums.sort()

        var prefix = 0
        val total = nums.sum()
        var res = Int.MAX_VALUE

        for (i in 0 until nums.size){
            val costLeft = nums[i] * i - prefix
            val costRight = total - prefix - (nums[i] * (nums.size - i) )
            val operations = (costLeft + costRight) / x
            res = minOf(res, operations)
            prefix += nums[i]
        }
        return res
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

O(1) space:
```
class Solution {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val (m, n) = listOf(grid.size, grid[0].size)


        for (i in 0 until m){
            for (j in 0 until n){
                if (abs(grid[i][j] - grid[0][0]) % x != 0) {
                    return -1
                }
            }
        }
        for (i in 0 until m){
            grid[i].sort()
        }

        var min = grid[0][0]
        var max = grid[0][0]
        for (i in 0 until m){
            for (j in 0 until n){
                min = minOf(min, grid[i][j])
                max = maxOf(max, grid[i][j])
            }
        }
        fun count(target: Int): Int{
            var  count = 0
            for (i in 0 until m){
                val row = grid[i]
                var left = 0
                var right = row.size
                while(left < right){
                    val m = (left + right) / 2
                    if (row[m] <= target) left = m + 1
                    else right = m
                }
                count += left
            }
            return count
        }

        var low = min
        var high = max
        val k = (m * n) / 2
        while(low < high){
            val mid = (low + high) / 2
            val count = count(mid)
            if (count <= k) low = mid + 1
            else high = mid 
        }
        val median = low

        var ans = 0
        for (i in 0 until m){
            for (j in 0 until n){
                ans += abs(grid[i][j] - median) / x
            }
        }

        
        return ans
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(1)


**Описание решения**
```

```
