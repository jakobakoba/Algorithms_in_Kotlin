## 85. Maximal Rectangle


```
class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val (m, n) = listOf(matrix.size, matrix[0].size)
        val array = IntArray(n)
        var max = 0
        for (i in 0 until m){
            for (j in 0 until n){
                array[j] = if (matrix[i][j] == '1') array[j] + 1 else 0
            }

            val stack = mutableListOf<Pair<Int,Int>>()

            for (x in 0 until n){
                var start = x
                while(stack.isNotEmpty() && stack.last().second > array[x]){
                    val (index, height) = stack.removeLast()
                    max = maxOf(max, height * (x - index))
                    start = index
                }
                stack.add(Pair(start, array[x]))
            }

            for ((index, height) in stack){
                max = maxOf(max, height * (n - index))
            }
        }
        return max
    }
}

```

**Оценка по времени**: О(mn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```