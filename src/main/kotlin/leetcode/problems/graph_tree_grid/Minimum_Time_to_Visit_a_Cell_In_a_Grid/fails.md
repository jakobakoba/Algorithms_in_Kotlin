#### my solution:
WA Input grid =[[0,1,3,2],[5,1,2,5],[4,3,8,6]]
Use Testcase Output -1 Expected 7
- completely wrong algorithm


### 01/12/2024
- надо минусовать time а не grid[r][c]
- grid[nr][nc] может быть ниже чем time так что берем max.
То есть max между time + 1 и grid[nr][nc] + wait