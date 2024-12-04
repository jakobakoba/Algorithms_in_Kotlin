#### my solution:
WA Input grid =[[0,1,3,2],[5,1,2,5],[4,3,8,6]]
Use Testcase Output -1 Expected 7
- completely wrong algorithm


### 01/12/2024
- надо минусовать time а не grid[r][c]
- grid[nr][nc] может быть ниже чем time так что берем max.
То есть max между time + 1 и grid[nr][nc] + wait

### 02/12/2024
проверил до отправки, но все равно не заметил: Line 12: Char 16: error: the integer literal does not conform to the expected type Triple<Int, Int, Int>!
pq.add(0,0,0)
- не wrapped Triple

проверил до отправки, но все равно не заметил:   visited(Pair(nr, nc))
- visited.add

### 04/12/2024
WA 26/41
grid[nr][nc] - time % 2 вот тут нужны скобки, иначе будет неправильный порядок вычисления