package yandex.yandex_7_training.yandex_7_training_1_dz

fun main() {
    val target = readln().toLong()
    val times = readln().trim().split(" ").map { it.toLong() }.toMutableList()

    for (i in 1 until times.size) {
        times[i] = maxOf(times[i], times[i - 1] * 2)
    }

    var remain = target
    var cost = 0L
    var ans = Long.MAX_VALUE

    for (i in times.size - 1 downTo 0) {
        val count = remain / times[i]
        cost += count * (1L shl i)
        remain -= count * times[i]

        ans = minOf(ans, cost + if (remain > 0) (1L shl i) else 0)
    }

    println(ans)
}
