package yandex.yandex_7_training.yandex_7_training_razminka

fun main(){
    val n = readln().toInt()
    val setAll = mutableSetOf<String>()
    val setChildren = mutableSetOf<String>()
    val parentMap = mutableMapOf<String, String>()

    repeat(n - 1){
        val (child, parent) = readln().split(" ")
        parentMap[child] = parent
        setAll.add(parent)
        setAll.add(child)
        setChildren.add(child)
    }

    val root = (setAll - setChildren).first()

    val heights = mutableMapOf<String, Int>(root to 0)

    fun getHeight(node: String): Int {
        if (node == root) return 0
        if (node !in heights){
            heights[node] = getHeight(parentMap[node]!!) + 1
        }
        return heights[node]!!
    }

    setAll.forEach { getHeight(it) }

    setAll.sorted().forEach { println("$it ${heights[it]}") }
}