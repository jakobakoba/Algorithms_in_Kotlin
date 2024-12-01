### iterative:
- перепутал && и || в while цикле

### 29/11/2024
Line 17: Char 19: error: type mismatch: inferred type is TreeNode? but TreeNode was expected
stack.add(root)
- добавил проверку если root == null

### 30/11/2024
Line 24: Char 27: error: unresolved reference: next
cur = cur.next
- у TreeNode нет next

Line 27: Char 29: error: unresolved reference: poll
val cur = stack.poll()
- у mutableListOf нет метода poll

Line 29: Char 13: error: val cannot be reassigned
cur = cur.right
- 2 раза объявил одну и ту же переменную, так еще второй раз сделал ее val

### 01/12/2024
я не понимаю, после того как я добавил все левые ноды, что мне дальше делать?
- вытаскиваешь ноду из стека, добавляешь в ответ и потом двигаешь cur направо

Line 21: Char 27: error: type mismatch: inferred type is TreeNode! but Int was expected
stack.add(cur.left)
- stack тип сделал Int, а нужен TreeNode

Line 21: Exception in thread "main" java.lang.NullPointerException: left must not be null
- пиздец в стек надо добавлять не cur.left, а cur

Line 22: Exception in thread "main" java.lang.NullPointerException: left must not be null
- cur = root!! если так написал и потом пишешь while(cur != null) надо дописать тип
cur: TreeNode? = root!! чтобы было нуллабельным