## 19. Remove Nth Node From End of List


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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var left = dummy
        var right = dummy

        for (i in 0 until n){
            right = right.next
        }

        while(right.next != null){
            left = left.next
            right = right.next
        }
        left.next = left.next.next

        return dummy.next
    }
}
```
**Оценка по времени**: O(n) прохожу за один раз по списку


**Оценка по памяти**: O(1) ничего не создаю


**Описание решения**  
можно создать dummy который будет смотреть на root and first and second которые тоже
будут смотреть на root
потом second прыгает на n вперед
как только second достигает n
мы двигаем first and second одновременно до тех пор пока second.next != null
потом first.next = first.next.next
        