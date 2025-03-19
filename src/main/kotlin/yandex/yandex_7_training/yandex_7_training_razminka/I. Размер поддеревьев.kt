package yandex.yandex_7_training.yandex_7_training_razminka

fun main(){
    val n = readln().toInt()
    val map = mutableMapOf<Int, MutableList<Int>>()
    val children = IntArray(n + 1){-1}

    repeat(n - 1){
        val (a, b) = readln().trim().split(" ").map{it.toInt()}
        map.computeIfAbsent(a){mutableListOf<Int>()}.add(b)
        map.computeIfAbsent(b){mutableListOf<Int>()}.add(a)
    }

    fun count(num: Int): Int {
        children[num] = 1
        for (child in map[num]!!){
            if(children[child] == -1){
                children[num] = children[num] + count(child)
            }
        }
        return children[num]
    }
    count(1)

    val ans = children.drop(1).joinToString(" ")
    println(ans)
}