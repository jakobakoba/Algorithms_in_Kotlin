## 3024. Type of Triangle



``` 
class Solution {
    fun triangleType(nums: IntArray): String {
        var ans = "none"

        val a = nums[0]
        val b = nums[1]
        val c = nums[2]

        if (a + b <= c || b + c <= a || a + c <= b){
            return ans
        }
     
        if (a != b && b != c && a != c ) {
            ans = "scalene"
        } 
            else if (a == b && b == c && a == c) {
            ans = "equilateral"

        }
        else {
            ans = "isosceles"
        }
        
        return ans
    }
}

```

**Оценка по времени**: O(1)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

