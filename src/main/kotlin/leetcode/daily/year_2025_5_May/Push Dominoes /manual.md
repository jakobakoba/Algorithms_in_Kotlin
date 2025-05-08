## 838. Push Dominoes


```
class Solution {
    fun pushDominoes(dominoes: String): String {
        val domino = dominoes.toCharArray()
        val queue: Queue<Pair<Int,Char>> = LinkedList()
        
        for ((index, value) in domino.withIndex()){
            if(value != '.'){
                queue.add(Pair(index, value))
            }
        }
        
        while(queue.isNotEmpty()){
            val (i, ch) = queue.poll()
            
            if (ch == 'L'){
                if (i > 0 && domino[i - 1] == '.'){
                    queue.add(Pair(i-1, 'L'))
                    domino[i-1] = 'L'
                }
            } else if (ch == 'R'){
                if (i + 1 < domino.size && domino[i + 1] == '.'){
                    if (i + 2 < domino.size && domino[i + 2] == 'L'){
                        queue.poll()
                    } else {
                        queue.add(Pair(i + 1, 'R'))
                        domino[i + 1] = 'R'
                    }
                }
            }
        }
        return domino.joinToString("")
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

