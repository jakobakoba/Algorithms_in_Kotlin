## 234. Palindrome Linked List

```
class Solution{
    fun isPalindrome(head: ListNode?): Boolean {
    
       var dummy = head
       
       var slow = head
       var fast = head
       
       while(fast != null && fast.next != null){
            slow = slow!!.next
            fast = fast.next.next
       }
       
       var prev: ListNode? = null
       
       var cur = slow
       
       while(cur != null){
            val temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
       }
       
       while(dummy != null && prev != null){
            if(dummy.`val` != prev.`val`) return false
            
            dummy = dummy.next
            prev = prev.next
       }
       return true
    }
}
```

**Оценка по времени**: О(n) все за один раз

**Оценка по памяти**: О(1) создаю только переменные


**Описание решения**
```
находим середину через slow, fast
переворачиваем вторую половину
начинаем сравнивать до середины с обоих концов


```