## 22. Generate Parentheses


```
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val stack = mutableListOf<Char>()
        val res = mutableListOf<String>()

        fun backtrack(left: Int, right: Int){
            if (left == right && right == n){
                res.add(stack.joinToString(""))
                return
            }

            if(left < n){
                stack.add('(')
                backtrack(left+1, right)
                stack.removeLast()
            }

            if (right < left){
                stack.add(')')
                backtrack(left, right + 1)
                stack.removeLast()
            }
        }

        backtrack(0,0)
        return res
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

