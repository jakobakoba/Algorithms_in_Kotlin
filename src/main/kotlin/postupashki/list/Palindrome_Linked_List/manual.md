## 234. Palindrome Linked List

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
    fun isPalindrome(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while(fast != null && fast.next != null){
            fast = fast.next.next
            slow = slow?.next
        }

        var prev: ListNode? = null
        var cur = slow
        while(cur != null){
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        var left = head
        var right = prev

        while(left != null && right != null){
            if (left.`val` != right.`val`){
                return false
            }
            left = left.next
            right = right.next
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

если есть условие например while(left != null тогда внутри тела можно не писать left?.`val` 
а если условия нет а например просто while(right != null) тогда внутри тела для left?.`val` нужен


```