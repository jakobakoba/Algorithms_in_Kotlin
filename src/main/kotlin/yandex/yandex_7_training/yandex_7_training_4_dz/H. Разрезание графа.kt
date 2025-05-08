package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader



fun main(){
    class DSU(private val size: Int) {
        private val parent = IntArray(size + 1){it}
        private val rank = IntArray(size + 1){1}

        fun find(u: Int): Int{
            if (parent[u] != u){
                parent[u] = find(parent[u])
            }
            return parent[u]
        }

        fun union(u: Int, v: Int) {
            val rootU = find(u)
            val rootV = find(v)
            if (rootU == rootV) return

            if (rank[rootU] > rank[rootV]){
                parent[rootV] = rootU
            } else {
                parent[rootU] = rootV
                if (rank[rootU] == rank[rootV]) rank[rootV]++
            }
        }

        fun connected(u: Int, v: Int): Boolean = find(u) == find(v)
    }
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, k) = reader.readLine().trim().split(" ").map{it.toInt()}

    val edges = mutableSetOf<Pair<Int,Int>>()

    repeat(m){
        val (u, v) = reader.readLine().trim().split(" ").map{it.toInt()}
        val a = minOf(u, v)
        val b = maxOf(u, v)
        edges.add(a to b)
    }

    val operations = mutableListOf<Triple<String, Int, Int>>()

    repeat(k){
        val str = reader.readLine().split(" ")
        val command = str[0]
        val u = str[1].toInt()
        val v = str[2].toInt()
        operations.add(Triple(command, u, v))
    }

    val dsu = DSU(n)

    val answer = mutableListOf<String>()

    for (i in operations.size - 1 downTo 0){
        val (op, u, v) = operations[i]
        when(op){
            "cut" ->  {
                dsu.union(u, v)
            }
            "ask" -> {
                answer.add(if(dsu.connected(u,v)) "YES" else "NO")
            }
        }
    }
    println(answer.reversed().joinToString("\n"))
}