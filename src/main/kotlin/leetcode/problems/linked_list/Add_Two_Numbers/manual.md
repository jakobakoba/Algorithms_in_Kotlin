## 2. Add Two Numbers


```
class Solution {
  
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var cur = dummy
        
        var c1 = l1
        var c2 = l2
        
        var leftover = 0
        while(c1 != null || c2 != null || leftover > 0){
            val sum = (c1?.`val` ?: 0) + (c2?.`val` ?: 0) + leftover
            val newValue = sum % 10
            leftover = sum / 10
            
            cur.next = ListNode(newValue)
            cur = cur.next
            
            c1 = c1?.next
            c2 = c2?.next
        }
        
        return dummy.next
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```