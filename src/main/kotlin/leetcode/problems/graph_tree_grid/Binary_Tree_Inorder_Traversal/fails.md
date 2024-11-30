### iterative:
- перепутал && и || в while цикле

#### 29/11/2024
Line 17: Char 19: error: type mismatch: inferred type is TreeNode? but TreeNode was expected
stack.add(root)
- добавил проверку если root == null

#### 30/11/2024
Line 24: Char 27: error: unresolved reference: next
cur = cur.next
- у TreeNode нет next

Line 27: Char 29: error: unresolved reference: poll
val cur = stack.poll()
- у mutableListOf нет метода poll

Line 29: Char 13: error: val cannot be reassigned
cur = cur.right
- 2 раза объявил одну и ту же переменную, так еще второй раз сделал ее val

