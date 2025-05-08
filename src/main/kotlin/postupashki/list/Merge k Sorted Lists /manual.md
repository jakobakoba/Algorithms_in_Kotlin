## 23. Merge k Sorted Lists

```
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    
    fun merge(l1: ListNode?, l2: ListNode?): ListNode?{
        val dummy = ListNode(0)
        var cur = dummy
        var l1 = l1
        var l2 = l2
        while(l1 != null && l2 != null){
            if (l1.`val` < l2.`val`){
                cur.next = l1
                l1 = l1.next
            } else {
                cur.next = l2
                l2 = l2.next
            }
            cur = cur.next
        }
        cur.next = l1 ?: l2
        return dummy.next
    }
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {

        if (lists.isEmpty()) return null

        var current = lists.toMutableList()

        while(current.size > 1){
            val temp = mutableListOf<ListNode?>()
            for (i in 0 until current.size step 2){
                val first = current[i]
                val second = if (i + 1 < current.size) current[i + 1] else null

                temp.add(merge(first, second))
            }
            current = temp
        }
        return current[0]
    }
}

```

**Оценка по времени**: О(nlogk)
Work per iteration: O(N).
Number of iterations: O(log k).
Total: O(N * log k).




**Оценка по памяти**: О(k)
k is the number of linked lists, reflecting the storage of pointers in the mutable lists.




**Описание решения**
```

```

