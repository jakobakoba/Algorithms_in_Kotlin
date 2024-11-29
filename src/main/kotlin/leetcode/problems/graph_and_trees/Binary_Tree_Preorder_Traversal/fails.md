##### Recursive
Line 5: Char 22: error: unresolved reference: `val`
ans.add(node.`val`) в traverse в параметры записал Int, а не TreeNode
- node: TreeNode?

##### Iterative
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