## 2094. Finding 3-Digit Even Numbers



``` 
class Solution {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val ans = mutableListOf<Int>()

        val map = mutableMapOf<Char,Int>()
        for (digit in digits){
            val d = '0' + digit
            map[d] = map.getOrDefault(d, 0) + 1
        }

        for (i in 100 until 1000 step 2){
            val number = i.toString()
            val numMap = mutableMapOf<Char,Int>()
            for (c in number){
                numMap[c] = numMap.getOrDefault(c, 0) + 1
            }
            var flag = true
            for ((ch, value) in numMap){
                if (ch !in map){
                    flag = false
                    break
                }
                if (map[ch]!! < numMap[ch]!!){
                    flag = false
                    break
                }
            }
            if(flag){
                ans.add(i)
            }

        }
        return ans.toIntArray()
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(1) только цифры от 0 до 9


**Описание решения**
```

```

