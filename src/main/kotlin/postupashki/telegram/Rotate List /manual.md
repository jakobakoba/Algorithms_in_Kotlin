## 61. Rotate List


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
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 0) return head
        var size = 1
        var tail = head

        while(tail!!.next != null){
            size++
            tail = tail.next
        }

        val steps = size - (k % size)
        if (steps == size) return head

        var prev = head
        for (i in 0 until steps - 1){
            prev = prev!!.next
        }
        val newHead = prev.next
        prev.next = null
        tail.next = head

        return newHead
        
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

