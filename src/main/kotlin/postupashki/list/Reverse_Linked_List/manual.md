## 206. Reverse Linked List

```
 fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur = head
    
    while(cur != null){
        val temp = cur.next
        cur.next = prev
        prev = cur
        cur = temp
    }
    return prev   
}
```
**Оценка по времени**:  Время O(n) один раз

**Оценка по памяти**: O(1) создаю лишь 1 переменную

**Описание решения**  
```
можно создать prev
val temp = cur.next
cur.next = prev
prev = cur
cur = temp
        

```
