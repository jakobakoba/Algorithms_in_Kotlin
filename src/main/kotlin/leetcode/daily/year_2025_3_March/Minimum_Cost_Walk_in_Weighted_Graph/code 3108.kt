package leetcode.daily.year_2025_3_March.Minimum_Cost_Walk_in_Weighted_Graph
//3108. Minimum Cost Walk in Weighted Graph

fun main(){
    class UnionFind(n: Int) {
        val parent = IntArray(n){it}
        var size = IntArray(n){1}

        fun find(x: Int): Int{
            if (x != parent[x]){
                parent[x] = find(parent[x])
            }
            return parent[x]
        }
        fun union(x: Int, y: Int){
            val rootX = find(x)
            val rootY = find(y)

            if (rootX != rootY){
                if (size[rootX] < size[rootY]){
                    parent[rootX] = rootY
                    size[rootY] += size[rootX]
                } else {
                    parent[rootY] = rootX
                    size[rootX] += size[rootY]
                }
            }
        }
    }

    class Solution {
        fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
            val uf = UnionFind(n)

            for ((u,v,w) in edges){
                uf.union(u,v)
            }

            val map = mutableMapOf<Int,Int>()

            for((u,v,w) in edges){
                val root = uf.find(u)
                if (root !in map){
                    map[root] = w
                } else {
                    map[root] = map[root]!! and w
                }
            }
            val res = mutableListOf<Int>()
            for ((src, dst) in query){
                val(r1, r2) = listOf(uf.find(src), uf.find(dst))
                if (r1 != r2){
                    res.add(-1)
                } else {
                    res.add(map[r1]!!)
                }
            }
            return res.toIntArray()
        }
    }
}
