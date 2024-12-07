# Recursive
Line 5: Char 22: error: unresolved reference: `val`
ans.add(node.`val`) в traverse в параметры записал Int, а не TreeNode
- node: TreeNode?
### 02/12/2024
проверил до отправки и не заметил: Line 2: Char 40: error: unresolved reference: MutableListOf
- неправильно написал тип к аргументу
### 07/12/2024
WA 35/71
- в рекурсивном вспомнил про итеративную и поэтому сначала сдела node.right и только потом
node.left. В рекурсивном хотел сделать итеративно. То есть действовал опять по памяти. Не думал и 
просто писал код вспоминая.

# Iterative
Line 6: Char 19: error: type mismatch: inferred type is TreeNode? but TreeNode was expected
stack.add(root) stack был TreeNode, а root был TreeNode?
- сделал stack TreeNode?


Line 12: Char 21: error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type TreeNode?
if (node.right != null){ node.right уже node требует nullability проверку
- сразу когда забираю ставлю "!!" stack.first()!!

Line 10: Exception in thread "main" java.lang.NullPointerException
- typo left and right не заметил

Line 11: Char 24: error: type mismatch: inferred type is TreeNode but Int was expected
answer.add(node)
- не заметил, что добавляю TreeNode, а не Int

Line 13: Exception in thread "main" java.util.NoSuchElementException: List is empty.
- надо обработать случай, когда root == null

#### 30/11/2024
Line 28: Char 33: error: unresolved reference: left
stack.add(stack.left)  
- в упор не увидел typo, хотя проверял перед отправкой

WA 35/71 
- в стек сначала надо добавлять правую и затем левую

### 02/12/2024
WA 35/71 урок не был усвоен, я повторил ошибку
- в стек сначала надо добавлять правую и затем левую

### 06/12/2024
Line 23: Exception in thread "main" java.lang.NullPointerException: left must not be null
- написал node.right?.let и также внутри написал node.left потому что на ходу вспомнил, что сначала 
добавляется правая сторона. Изменил код и не удостоверился как это изменение скажется на остальную часть кода.

### 07/12/2024 
забыл Of при создании mutableListOf. Сегодня уже несколько раз так ошибался.

