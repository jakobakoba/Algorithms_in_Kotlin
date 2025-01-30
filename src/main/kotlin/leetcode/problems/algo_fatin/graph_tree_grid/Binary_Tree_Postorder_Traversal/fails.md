# recursive
### 30/11/2024
WA 1/71
- забыл запустить саму функцию


# iterative
Line 31: Char 21: error: unresolved reference: right
if (top.right != null && top.right != lastVisited){
- в mutableListOf тип указал Int вместо TreeNode

Line 26: Char 27: error: type mismatch: inferred type is Int but TreeNode was expected
stack.add(cur.`val`)
- добавил Int в стек с типами TreeNode

Line 36: Char 15: error: unexpected tokens (use ';' to separate expressions on the same line)
} else {
- написал while, а должно было быть просто if

вывело пустую строку
- написал && вместо ||

### 30/11/2024
Line 25: Char 27: error: unresolved reference: next
cur = cur.next
- у TreeNode нет свойства next

Line 25: Char 17: error: val cannot be reassigned
lastVisited = top
- val и var 

### 01/12/2024
непонятно вот я добавил все левые ноды, а потом что?
- берешь самый последний элемент стека и смотришь а является ли он самым правым то есть правее только null
 либо тот кто правее уже был обработан? 
Если нет, то идешь до талого направо, а если да, то добавляешь в ответ

### 02/12/2024
Line 34: Char 32: error: expecting an element
answer.add(top.`val)
- синтаксис ошибка

Time limit exceeded
- проверял top, а нужно было проверять top.right

### 04/12/2024
Line 18: Char 31: error: unresolved reference: visited
if (top.right !in visited && top.right != lastVisited){
- делал по памяти и зачем то влепил visited хотя в коде его даже не было

Line 18: Char 27: error: none of the following functions can be called with the arguments supplied:
- "!in null" написал и даже не заметил

visited.add(top)
- сверху исправил, но в коде оказался еще один visited. Все 3 ошибки из-за того, что пишешь по памяти, совершенно не думая что пишешь

Line 23: Char 17: error: val cannot be reassigned
lastVisited = top
- просто пройдись по коду, не ленись

### 06/12/2024
Line 20: Char 27: error: type mismatch: inferred type is TreeNode but Int was expected
stack.add(cur)
- не заметил что в stack записан тип Int, хотя нужно было написать TreeNode