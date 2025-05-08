package yandex.yandex_7_training.yandex_7_training_1_dz

fun main(){
    val (n, m) = readln().trim().split(" ").map{it.toInt()}
    val deti = readln().trim().split(" ").map{it.toInt()}
    val audit = readln().trim().split(" ").map{it.toInt()}

    val detiIndex = deti.mapIndexed{index, value -> index to value + 1}.sortedBy{it.second}
    val auditIndex = audit.mapIndexed{index, value -> index to value}.sortedBy{it.second}

    val used = BooleanArray(m)
    val result = IntArray(n)

    for ((idxDeti, need) in detiIndex){
        for ((idxAudit, have) in auditIndex){
            if (!used[idxAudit] && have >= need){
                used[idxAudit] = true
                result[idxDeti] = idxAudit + 1
                break
            }
        }
    }
    val count = result.count{ it != 0}
    println(count)
    println(result.joinToString(" "))

}