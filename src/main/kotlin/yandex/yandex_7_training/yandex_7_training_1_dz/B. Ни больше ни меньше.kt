package yandex.yandex_7_training.yandex_7_training_1_dz

fun main(){
    val t = readln().trim().toInt()
    repeat(t){
        val n = readln().trim().toInt()
        val nums = readln().trim().split(" ").map{it.toInt()}

        val result = mutableListOf<Int>()
        var start = 0
        var minVal = nums[0]

        for (end in 0 until nums.size){
            minVal = minOf(minVal, nums[end])
            val len = end - start + 1
            if (minVal < len){
                result.add(len - 1)
                start = end
                minVal = nums[end]
            }
        }
        result.add(n - start)

        println(result.size)
        println(result.joinToString(" "))
    }
}