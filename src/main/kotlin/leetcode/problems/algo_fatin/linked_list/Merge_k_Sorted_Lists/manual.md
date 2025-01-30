## 23. Merge k Sorted Lists

```
import java.util.*

class Solution{
    fun mergeKLists(lists: Array<ListNode?>) : ListNode? {
  
        val pq = PriorityQueue<ListNode>(compareBy{it.`val`})
        for (i in lists){
            if(i != null){
                pq.add(i)    
            }        
        }
        val dummy = ListNode(0)
        var cur = dummy
        
        while(pq.isNotEmpty()){
            val kabanchik = pq.poll()
            cur.next = kabanchik
            cur = cur.next
            if (kabanchik.next != null){
                pq.offer(kabanchik.next)
            }
        }
        return dummy.next
    }
}
```

**Оценка по времени**: O(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
   //мне нужен queue где будут все первые элементы всех linkedLists
  //может бахнуть pq и держать size == arr.size
    
    //уже нельзя персонально сделать каждому линкед листу переменную
    //их может быть 104
    
    //каждый раз проходить for лупом каждый шаг? а как сравнить всех между собой?
    //pq поможет?
    
    //длина одного линкед листа может быть 500
    
    //что если у одного 1 элемент, у второго 20, у третьего 500.
    //держать pq size == arr.size не имеет смысла
    
    //просто добавляю первые элементы в pq и пока pq не пуст
    //каждый раз при взятии из pq
        

```