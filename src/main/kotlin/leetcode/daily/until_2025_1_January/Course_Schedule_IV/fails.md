### 01/02/2025
- ошибочно написал MutableSetOf<Int>, правильно будет MutableSet<Int>
- не проверил if (adj[i] != null)
- ошибочно на ans поставил type Int, должно быть Boolean
- в dfs override значения. set prerequisites новый должны находиться внутри if (i !in preMap)