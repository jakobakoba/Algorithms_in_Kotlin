## 781. Rabbits in Forest



``` 
class Solution {
    fun numRabbits(answers: IntArray): Int {
        val n = answers.size

        val map = mutableMapOf<Int,Int>()

        for (answer in answers){
            map[answer + 1] = map.getOrDefault(answer + 1, 0) + 1
        }

        var result = 0

        for ((key, value) in map){
            if (key < value) {
                result += (key + value - 1) / key * key
            } else {
                result += key
            }
        }
        return result
    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: O(n)


**Описание решения**
```

```

