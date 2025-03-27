## 84. Largest Rectangle in Histogram


```
class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size

        val stack = mutableListOf<Pair<Int,Int>>()

        var max = 0

        for (i in 0 until n){
            var start = i
            while(stack.isNotEmpty() && stack.last().second > heights[i]){
                val (index, height) = stack.removeLast()
                max = maxOf(max, height * (i - index))
                start = index
            }
            stack.add(Pair(start, heights[i]))
        }

        for ((index, height) in stack){
            max = maxOf(max, height * (n - index))
        }
        return max
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
max = maxOf(max, height * (i - index))
получается тут считаем как будто шаги и это будут элементы не включая i текущий. Направо идет 
волна.  
Допустим, у нас есть массив:
heights = [2, 1, 5, 6, 2, 3]
И мы находимся на индексе i = 4 (heights[4] = 2), а в стеке был height = 5 с index = 2.

элементы 5 и 6 пойдут в учет. то есть i - index дает 2 но это элементы 5 и 6 

```