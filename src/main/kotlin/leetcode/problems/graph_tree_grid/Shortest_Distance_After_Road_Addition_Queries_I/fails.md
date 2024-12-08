Line 60: Char 22: error: type mismatch: inferred type is Array<(out) IntArray!>! but List<IntArray> was expected
param_1, param_2
- ошибся в input, там был array, а я написал List<IntArray>

WA n = 4  queries =[[0,3],[0,2]] 271/972
следующий query переписывал предыдущий даже если он был 
лучше
- добавил if замена только если arr[query[0]] < query[1]
то есть заменяем только если текущий меньше чем 
новоприбывающий

WA n = 6 queries = [[1,4],[0,2]] 452 / 972
тут мое неоптимальное решение полностью себя дискредитирует
, потому что уже надо выбирать между несколькими
путями. Мое решение - обрабатывай query и иди прямо - больше не работает.

### 01/12/2024
- неправильно написал тип аргумента в input

WA 38/972
- создал visited, но саму проверку !in visited не сделал

WA 416/972
- изменил на queue c pq и заработало

### 02/12/2024
- return тип неправильный

Line 32: Exception in thread "main" java.lang.IllegalStateException:
- инициализировал visited за пределами функции

### 03/12/2024
Line 10: Char 30: error: one type argument expected for interface Queue<E : Any!>
val queue : Queue<Int, Int> = LinkedList()
- неправильно инициализировал Queue

Line 21: Char 38: error: function invocation 'step(...)' expected
for (neighbor in adj[step]){
- удалил переменную и потом ссылался на нее несуществующую

### 04/12/2024
Line 4: Char 46: error: passing value as a vararg is only allowed inside a parenthesized argument list
val adj = Array(n){mutableListOf<Int>{0}} 
- неправильно инициализировал mutableListOf, забыл скобки

Line 3: Char 48: error: passing value as a vararg is only allowed inside a parenthesized argument list
val adj = Array(n){mutableListOf<Int>(){0}}
- а теперь понял, что {0} там не нужен

### 06/12/2024
проверял код перед отправкой, но не учел возвращаемый тип. Должен был быть IntArray, а я возвращал List<Int>
- не забудь проверить возвращаемый тип

### 08/12/2024
Line 34: Char 16: error: type mismatch: inferred type is MutableList<Int> but IntArray was expected
return ans
- в последний момент когда отправил, понял что опять не заметил возвращаемый тип. Поймал ошибку 