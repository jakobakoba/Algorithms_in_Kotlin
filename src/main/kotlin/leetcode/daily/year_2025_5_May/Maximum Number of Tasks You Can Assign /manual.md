## 2071. Maximum Number of Tasks You Can Assign


```
class Solution {
    fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
        tasks.sort()
        workers.sort()
        
        var left = 0
        var right = minOf(tasks.size, workers.size)
        var ans = 0
        
        while(left <= right){
            val mid = (left + right) / 2
            if (canAssign(mid, tasks, workers, pills, strength)){
                ans = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return ans
    }
    
    fun canAssign(k: Int, tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Boolean {
        if (k == 0) return true
        
        val sortedTasks = tasks.copyOfRange(0, k).sorted()
        val sortedWorkers = workers.copyOfRange(workers.size - k, workers.size).sorted().toMutableList()
        
        val deque = ArrayDeque<Int>()
        var pillsUsed = 0
        
        for (task in sortedTasks.reversed()){
            while(sortedWorkers.isNotEmpty() && sortedWorkers.last() + strength >= task){
                deque.addLast(sortedWorkers.removeLast())
            }
            if (deque.isEmpty()) return false
            if (deque.first() >= task){
                deque.removeFirst()
            } else {
                if (pillsUsed >= pills) return false
                deque.removeLast()
                pillsUsed++
            }
        }
        return true
    }
}

```

**Оценка по времени**: О(nlogn + mlognm)


**Оценка по памяти**: О(k)


**Описание решения**
```

```

