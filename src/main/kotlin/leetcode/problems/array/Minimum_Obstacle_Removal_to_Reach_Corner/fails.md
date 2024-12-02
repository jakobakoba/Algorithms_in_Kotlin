Line 53: Exception in thread "main" 
java.lang.ArrayIndexOutOfBoundsException: -1
- неправильный вывод: внутри if statement нужно соблюдать порядок проверок,
нельзя первым ставить то, что выбросит исключение
- правильный вывод: перепутал || и &&
- еще одна ошибка: перепутал !in and in

Line 53: Exception in thread "main" java.lang.ClassCastException:
kotlin.Triple cannot be cast to java.lang.Comparable
- pq было без compareBy, добавил compareBy{it.first}

# Deque
### 01/12/2024
- проверил, но все равно не заметил синтаксическую ошибку: два раза в одну линию инициализировал
 Deque
- неправильно назвал имя главной функции

### 02/12/2024
не проверил перед отправкой, поленился. Line 21: Char 21: error: unresolved reference: neighbor
if (neighbor in visited || nr < 0 || nc < 0 || nr >= rows || nc >= cols ){
- Pair(nr,nc) in visited

проверил, но все равно не нашел эту ошибку перед отправкой. Line 26: Char 36: error: type 
mismatch: inferred type is Int but Triple<Int, Int, Int>! was expected deque.addFirst(obstacles, nr, nc)
- Triple() 