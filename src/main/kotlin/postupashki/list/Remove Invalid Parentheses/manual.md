## 301. Remove Invalid Parentheses


```
class Solution {

    fun removeInvalidParentheses(s: String): List<String> {
        val validExpressions = mutableSetOf<String>()
        val length = s.length

        var leftToRemove = 0
        var rightToRemove = 0

        for (char in s) {
            if (char == '(') {
                leftToRemove++
            } else if (char == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--
                } else {
                    rightToRemove++
                }
            }
        }

        fun dfs(index: Int, leftToRemove: Int, rightToRemove: Int, leftCount: Int, rightCount: Int, path: StringBuilder) {
            if (index == length) {
                if (leftToRemove == 0 && rightToRemove == 0) {
                    validExpressions.add(path.toString())
                }
                return
            }

            if (length - index < leftToRemove + rightToRemove || rightCount > leftCount) {
                return
            }

            val char = s[index]
            val pathLengthBefore = path.length

            if (char == '(' && leftToRemove > 0) {
                dfs(index + 1, leftToRemove - 1, rightToRemove, leftCount, rightCount, path)
            } else if (char == ')' && rightToRemove > 0) {
                dfs(index + 1, leftToRemove, rightToRemove - 1, leftCount, rightCount, path)
            }

            path.append(char)


            if (char != '(' && char != ')') {
                dfs(index + 1, leftToRemove, rightToRemove, leftCount, rightCount, path)
            } else if (char == '(') {
                dfs(index + 1, leftToRemove, rightToRemove, leftCount + 1, rightCount, path)
            } else if (char == ')') {
                dfs(index + 1, leftToRemove, rightToRemove, leftCount, rightCount + 1, path)
            }

            path.setLength(pathLengthBefore)
        }

        dfs(0, leftToRemove, rightToRemove, 0, 0, StringBuilder())

        return validExpressions.toList()
    }
}



```

**Оценка по времени**: О(2^n) потому что в каждом шаге у нас 2 варианта


**Оценка по памяти**: О(2^n)


**Описание решения**
```
pruning - обрезка, сокращение, подрезка
```

