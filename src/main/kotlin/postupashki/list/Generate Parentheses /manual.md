## 22. Generate Parentheses


```
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        
        val ans = mutableListOf<String>()

        fun backtrack(opening: Int, closing: Int, cur: String){
            if (opening > n ) return

            if (cur.length == n * 2){
                ans.add(cur)
                return
            }

            if (opening < n){
                backtrack(opening + 1, closing, cur + "(")
            } 
            if (closing < opening){
                backtrack(opening, closing + 1, cur + ")")
            }
        }
        backtrack(0,0,"")
        return ans
    }
}

```

**Оценка по времени**: Time: O(4^n) — can't do better, because you have to output that many results.
The total number of valid strings is exponential (Catalan number), so:
Time complexity can't be better than O(4^n) — because that’s how many answers you
have to generate.


**Оценка по памяти**:  Space: O(n * 4^n) — just enough to hold the answers.

**Описание решения**
```

```

