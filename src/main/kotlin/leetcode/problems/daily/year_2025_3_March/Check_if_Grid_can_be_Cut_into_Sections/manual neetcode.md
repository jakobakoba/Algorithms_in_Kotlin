## 3394. Check if Grid can be Cut into Sections

```
class Solution {
    fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
        val x = mutableListOf<IntArray>()
        val y = mutableListOf<IntArray>()

        for ((a,b,c,d) in rectangles){
            x.add(intArrayOf(a,c))
            y.add(intArrayOf(b,d))
        }
        x.sortBy{it[0]}
        y.sortBy{it[0]}

        fun count(list: List<IntArray>): Int {
            var prev = -1
            var count = 0
            for ((start, end) in list){
                if (start >= prev){
                    count++
                }
                if (count >= 3){
                    break
                }
                prev = maxOf(prev, end)
            }
            return count
        }
        return count(x) >= 3 || count(y) >= 3
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```