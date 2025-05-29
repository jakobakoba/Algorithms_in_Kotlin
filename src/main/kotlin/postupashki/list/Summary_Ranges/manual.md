## 228. Summary Ranges


```
class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val n = nums.size
        var left = 0 
        val ans = mutableListOf<String>()
        for (right in 0 until n){
            if (right == n - 1 || nums[right] + 1 != nums[right + 1]){
                if (right == left){
                    ans.add("${nums[left]}")
                } else {
                    ans.add("${nums[left]}->${nums[right]}")
                }
                left = right + 1
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

```
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b



Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:

Input: nums = [0,2,3,4,6,8,9 , 11]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

 

Constraints:

    0 <= nums.length <= 20
    -231 <= nums[i] <= 231 - 1
    All the values of nums are unique.
    nums is sorted in ascending order.


class Solution {
    fun summaryRanges(nums: IntArray): List<String> {

        val result = mutableListOf<String>()
        if(nums.isEmpty()) return result

        var start = nums[0]

        for(i in 1 .. nums.size){
            val end = nums[i -1 ]
            if(i == nums.size || nums[i] != nums[i - 1 ] + 1){
                if(start == end){
                    result.add("$start")
                } else {
                    result.add("$start->$end")
                }
                if( i < nums.size) start = nums[i]
            }
        }
        return result
    }
}```