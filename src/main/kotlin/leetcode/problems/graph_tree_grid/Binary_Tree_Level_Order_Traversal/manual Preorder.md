## 102. Binary Tree Level Order Traversal


```
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val answer = mutableListOf<MutableList<Int>>()
        
        fun preorder(node: TreeNode?, level: Int) {
            if (node == null) return 
            
            if (answer.size <= level){
                answer.add(mutableListOf<Int>())
            }
                answer[level].add(node.`val`)
        
            preorder(node.left, level + 1)
            preorder(node.right, level + 1)            
        }
        preorder(root, 0)
        return answer
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: O(n)


**Описание решения**
```

```