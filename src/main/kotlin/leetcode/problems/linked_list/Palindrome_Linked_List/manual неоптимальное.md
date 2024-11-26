## 234. Palindrome Linked List

```
неоптимальное решение:
   fun isPalindrome(head: ListNode?): Boolean {
        val list = mutableListOf<Int>()
        
        var cur = head
        while(cur != null){
            list.add(cur.`val`)
            cur = cur!!.next
        }
        val n = list.size  
        var left = n / 2
        var right = n / 2
        
        if (list.size % 2 == 0){
            left = n / 2 - 1
        }
        
        if (list[left] != list[right]){
            return false
        }
        while(left >= 0 && right < n){
            if (list[left] != list[right]){
                return false
            }
            left--
            right++
        }
        return true
    }
```

**Оценка по времени**: О(n) сначала прохожу по linkedlist, 
потом в листе по обе стороны


**Оценка по памяти**: О(n) создаю list и пару переменных


**Описание решения**
```
неоптимальное:
можно все это сохранить в list
и потом от середины идти в обе стороны
если нечетное:
норм
если четное то:
var left = size / 2 - 1
var right = size / 2


```