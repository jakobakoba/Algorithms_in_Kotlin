package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader

class DSU(val size: Int){
    private val parent = IntArray(size + 1){it}
    private val rank = IntArray(size + 1) {1}

    var count = size

    fun find(u: Int) : Int {
        if (parent[u] != u){
            parent[u] = find(parent[u])
        }
        return parent[u]
    }

    fun union(u:Int, v:Int): Boolean {
        val rootU = find(u)
        val rootV = find(v)

        if(rootU == rootV) return false
        if (rank[rootU] > rank[rootV]){
            parent[rootV] = rootU
        } else {
            parent[rootU] = rootV
            if (rank[rootU] == rank[rootV]){
                rank[rootV]++
            }
        }
        count--
        return true
    }
}

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = reader.readLine().trim().split(" ").map{it.toInt()}

    val dsu = DSU(n)
    for (i in 0 until m){
        val (a, b) = reader.readLine().trim().split(" ").map{it.toInt()}
        dsu.union(a,b)
        if (dsu.count == 1){
            println(i + 1)
            return
        }
    }
    println(m)
}