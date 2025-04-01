## 21. Merge Two Sorted Lists

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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        
        val dummy = ListNode()

        var cur = dummy

        var l1 = list1
        var l2 = list2


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
}


```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1)


**Описание решения**
```
можно просто создать dummy и идти вперед сравнивая l1 и l2
while l1 && l2
потом под конец вставляем того кто остался
```