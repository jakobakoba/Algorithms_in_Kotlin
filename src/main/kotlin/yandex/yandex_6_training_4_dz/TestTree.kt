package yandex.yandex_6_training_4_dz

data class TreeNode(val value: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main(){
    var ans = 0
    fun sumOfSubtree(root: TreeNode): IntArray {
        val p = intArrayOf(1,0)

        if (root.left != null){
            val ptemp = sumOfSubtree(root.left!!)

            p[1] += ptemp[0] + ptemp[1]

            p[0] += ptemp[0]
        }

        if (root.right != null){
            val ptemp = sumOfSubtree(root.right!!)

            p[1] += ptemp[0] + ptemp[1]

            p[0] += ptemp[0]
        }

        ans += p[1]

        return p
    }

    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)
    root.left!!.left!!.left = TreeNode(8)
    root.left!!.left!!.right = TreeNode(9)
    sumOfSubtree(root)

    print(ans)
}