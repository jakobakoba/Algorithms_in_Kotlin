### 21/01/2025
- ошибочно написал if (grid[nr][nc]  == d), но правильно будет grid[r][c]

### 22/01/2025
- ошибочно написал if(r == n-1 || c == m-1), а должно быть &&
- запутался в nr and nc в проверке out of bounds

### 23/01/2025
- неправильно вычислял nr and nc. Написал nr = nr + dr, но должно быть r + dr. same for nc
- ошибочно вместо deque поставил priorityqueue
- не сохранил значение в minCost 

### 24/01/2025
- не сохранил значение в minCost
- && and || запутался в r == n - 1 && c == m - 1

### 25/01/2025
- ошибочно пытался использовать keys когда написал, что directions это listOf. directions 
должен быть mapOf.

### 26/01/2025
- выбросил throw на скобку раньше
- не сохранил minCost в map

### 27/01/2025
- неправильно инициализировал deque. Забыл слово Deque 
- перепутал grid and directions. Пытался вытащить nr and nc из directions.
- перепутал grid[r][c] and grid[nr][nc]. Словил out of bounds error из за неправильного 
grid[nr][nc]. 