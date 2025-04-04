package postupashki.list.`Lowest Common Ancestor of a Binary Tree III`
class Node(var `val`: Int){
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}
fun main(){


    class Solution(){
        fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
            var pointerA = p
            var pointerB = q

            while(pointerA != pointerB){
                pointerA = if (pointerA?.parent != null ) pointerA.parent else q
                pointerB = if (pointerB?.parent != null) pointerB.parent else p
            }

            return pointerA
        }
    }

    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)

    node1.parent = null
    node2.parent = node1
    node3.parent = node1
    node4.parent = node2
    node5.parent = node2

    println(Solution().lowestCommonAncestor(node4, node5)?.`val`)




}