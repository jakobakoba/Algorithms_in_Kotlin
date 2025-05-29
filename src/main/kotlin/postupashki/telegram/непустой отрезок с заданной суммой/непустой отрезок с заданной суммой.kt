package postupashki.telegram.`непустой отрезок с заданной суммой`

/*
Дан массив целых чисел, нужно найти непустой подотрезок
 (непрерывную подпоследовательность) с заданной суммой X,
 либо сказать, что это невозможно.

Для найденного отрезка (если он существует) следует выдать на выход индексы его концов.
 */
fun main(){

    fun helper(nums: IntArray, target: Int): IntArray {

        val map = mutableMapOf<Long,Int>()
        map[0] = -1
        val n = nums.size
        var cur = 0L
        for(i in 0 until n){
            cur += nums[i].toLong()
            val needed = cur - target.toLong()
            if (needed in map){
                return intArrayOf(map[needed]!! + 1, i)
            }
            if(cur !in map){
                map[cur] = i
            }
        }
        return intArrayOf(-1,-1)
    }
    val indices = helper(intArrayOf(2,5,5,3), 7)
    println("${indices[0]}, ${indices[1]}")


}

/*
Пример:
kotlin
Массив: [2, 3, 5, 3]
target = 8
    Префиксные суммы:
        Индекс 0: sum = 2 → map[2] = 0
        Индекс 1: sum = 5 → map[5] = 1
        Индекс 2: sum = 10 → needed = 10 - 8 = 2.
            map[2] = 0 → подотрезок начинается с 0 + 1 = 1, заканчивается на 2.
Почему +1:
    map[needed] хранит индекс, на котором заканчивается сумма needed.
    Искомый подотрезок начинается следующим элементом после этого индекса.
 */