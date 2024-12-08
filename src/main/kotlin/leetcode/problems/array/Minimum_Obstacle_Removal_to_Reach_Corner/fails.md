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
### 04/12/2024
забыл добавить neighbor в visited и словил tle

### 06/12/2024
Line 16: Char 46: error: unexpected tokens (use ';' to separate expressions on the same line)
val deque: Deque<Triple<Int,Int,Int>>() = LinkedList()
- неправильно инициализировал deque. Не ленись! Проверь логику и синтаксис.

### 07/12/2024
Line 43: Char 2: error: expecting a top level declaration
}/
- в mutableSetOf<Pair пытался сравнить с listOf(nr,nc)

### 08/12/2024
Line 15: Char 17: error: variable expected if (r == rows - 1 && c = cols - 1) return obstacles
- typo == and =

### 09/12/2024 
typo rc and nc
- не проверял перед отправкой
