## 1769. Minimum Number of Operations to Move All Balls to Each Box


```
class Solution {
    fun minOperations(boxes: String): IntArray {
        val n = boxes.length

        val res = IntArray(n)

        var balls = 0
        var moves = 0

        for (i in 0 until n){
            res[i] = balls + moves
            moves += balls
            balls += "${boxes[i]}".toInt()
            
        }

        balls = 0
        moves = 0
        for (i in n - 1 downTo 0){
            res[i] += balls + moves
            moves += balls
            balls += "${boxes[i]}".toInt()
            
        }
        return res
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
https://www.youtube.com/watch?v=ZmH3gHiIqfI
```