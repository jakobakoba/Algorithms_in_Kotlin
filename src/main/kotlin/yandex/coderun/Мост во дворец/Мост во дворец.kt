package yandex.coderun.`Мост во дворец`

fun main(){
    fun solution(n: Int, a: IntArray): Int {
        // your code here
        a.sort()

        var left = 0

        var max = 0

        for (right in 0 until n){
            while(a[left] < a[right] - n + 1){
                left++
            }
            max = maxOf(max, right - left + 1)
        }
        return n - max
    }

}