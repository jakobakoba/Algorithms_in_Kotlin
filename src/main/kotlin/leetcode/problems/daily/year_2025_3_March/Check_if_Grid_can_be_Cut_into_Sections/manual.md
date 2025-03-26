## 3394. Check if Grid can be Cut into Sections

```
class Solution {
    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        val sortedX = mutableListOf<IntArray>()
        val sortedY = mutableListOf<IntArray>()

        for ((a,b,c,d) in rectangles){
            sortedX.add(intArrayOf(a,c))
            sortedY.add(intArrayOf(b,d))
        }
        sortedX.sortBy{it[0]}
        sortedY.sortBy{it[0]}

        val x = mutableListOf<IntArray>()
        val y = mutableListOf<IntArray>()
        for ((a,c) in sortedX){
            if (x.isEmpty()){
                x.add(intArrayOf(a,c))            
            } else {
                val last = x.last()
                val min = minOf(last[1], c)
                val max = maxOf(last[0], a)
                if (min > max){
                    x.removeLast()
                    val left = minOf(last[0], a)
                    val right=  maxOf(last[1], c)
                    x.add(intArrayOf(left, right))
                } else {
                    x.add(intArrayOf(a,c))
                }
            }
        }
        for ((b,d) in sortedY){
            if (y.isEmpty()){
                y.add(intArrayOf(b, d))
            } else {
                val last = y.last()
                val min = minOf(last[1], d)
                val max = maxOf(last[0], b)
                if (min > max){
                    y.removeLast()
                    val left = minOf(last[0], b)
                    val right = maxOf(last[1], d)
                    y.add(intArrayOf(left, right))
                } else {
                    y.add(intArrayOf(b, d))
                }
            }
        }
        return x.size >= 3 || y.size >= 3
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```