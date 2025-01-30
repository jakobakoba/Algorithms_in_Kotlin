## 143. Reorder List

```
class Solution{
    fun reorderList(head: ListNode?): Unit {
        var dummy = head
        
        var slow = head
        var fast = head
        
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow!!.next
            fast = fast.next.next
        }
        
        var prev: ListNode? = null
        var cur = slow!!.next
        
        slow.next = null
        
        while(cur != null){
            val temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        }
        
        while(dummy != null && prev != null){
            val temp = dummy.next
            dummy.next = prev
            dummy = prev
            prev = temp
        }
    }
}
```

**Оценка по времени**: О(n) 


**Оценка по памяти**: О(1)


**Описание решения**
```
находим premid  методом slow, fast
переворачиваем вторую половину
начинаем идти 
val temp = dummy.next
dummy.next = prev
dummy = prev
prev = temp

```