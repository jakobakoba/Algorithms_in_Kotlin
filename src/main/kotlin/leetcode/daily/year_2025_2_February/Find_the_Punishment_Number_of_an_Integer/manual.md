## 2698. Find the Punishment Number of an Integer


```
class Solution {
    fun punishmentNumber(n: Int): Int {
        var res = 0

        fun partition(i: Int, cur: Int, target: Int, string: String): Boolean{
            if (i == string.length  && cur == target){
                return true
            }

            for (j in i until string.length){
                val substring = string.substring(i, j + 1).toInt()
                if (partition(j + 1, cur + substring, target, string)){
                    return true
                }
            }
            return false
        }

        for (i in 1 until n + 1){
            if (partition(0, 0, i, (i * i).toString())){
                res += i * i
            }
        }

        return res
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```