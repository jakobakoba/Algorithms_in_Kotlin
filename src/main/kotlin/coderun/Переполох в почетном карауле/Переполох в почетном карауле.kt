package coderun.`Переполох в почетном карауле`

fun main(){
    fun solution(n: Int, m: Int, swaps: IntArray): IntArray {
        val result = IntArray(m)
        // your code here
        val guard = IntArray(2 * n + 1){it}

        var count = n
        for (i in 0 until m){
            val p = swaps[2 * i]
            val q = swaps[2 * i + 1]


            if ((p <= n && q > n) || (p > n && q <= n)){
                val pos_in = if (p <= n) p else q
                val pos_out = if (p <= n) q else p
                val guard_in = guard[pos_in]
                val guard_out = guard[pos_out]

                if (guard_out <= n && guard_in > n){
                    count += 1
                } else if (guard_in <= n && guard_out > n){
                    count -= 1
                }
            }
            val temp = guard[p]
            guard[p] = guard[q]
            guard[q] = temp

            result[i] = count

        }
        return result
    }

}