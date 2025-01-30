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

class Solution{
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var cur = dummy
        var l = list1
        var r = list2
        while(l != null && r != null){
            if (l.`val` < r.`val`){
                cur.next = l
                l = l.next
            } else {
                cur.next = r
                r = r.next
            }
            cur = cur.next
        }
        
        cur.next = l ?: r
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