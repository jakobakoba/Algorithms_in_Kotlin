## 36. Valid Sudoku


```
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rows = List(9){mutableSetOf<Char>()}
        val cols = List(9){mutableSetOf<Char>()}

        val squares = mutableMapOf<Pair<Int,Int>, MutableSet<Char>>()

        for (r in 0 until 9){
            for (c in 0 until 9){
                val value = board[r][c]
                if (value == '.') continue
                val squareKey = Pair(r / 3, c / 3)
                if(value in rows[r] || value in cols[c] || value in squares.getOrPut(squareKey){mutableSetOf()}){
                    return false
                }
                rows[r].add(board[r][c])
                cols[c].add(board[r][c])
                squares.getOrPut(squareKey){mutableSetOf()}.add(value)
            }
        }
        return true
    }
}

```

**Оценка по времени**: О(1) все фиксированно


**Оценка по памяти**: О(1) все фиксированно


**Описание решения**
```

```

