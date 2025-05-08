package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader

private const val maxN = 129

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))


    val n = reader.readLine().toInt()

    val bit = Array(maxN){Array(maxN){LongArray(maxN)} }

    fun update(x: Int, y: Int, z: Int, delta: Long){
        var ix = x + 1
        while(ix <= n){
            var iy = y + 1
            while(iy <= n){
                var iz = z + 1
                while(iz <= n){
                    bit[ix][iy][iz] += delta
                    iz += iz and -iz
                }
                iy += iy and -iy
            }
            ix += ix and -ix
        }
    }

    fun query(x: Int, y: Int, z: Int) : Long {
        if (x < 0 || y < 0 || z < 0){
            return 0L
        }

        var sum = 0L
        var ix = x + 1

        while(ix > 0){
            var iy = y + 1
            while(iy > 0){
                var iz = z + 1
                while(iz > 0){
                    sum += bit[ix][iy][iz]
                    iz -= iz and -iz
                }
                iy -= iy and -iy
            }
            ix -= ix and -ix
        }
        return sum
    }

    fun rangeSum(x1: Int, y1: Int, z1: Int, x2: Int, y2: Int, z2: Int): Long {
        return (query(x2, y2, z2)
                - query(x1 - 1, y2, z2)
                - query(x2, y1 - 1, z2)
                - query(x2, y2, z1 - 1)
                + query(x1 - 1, y1 - 1, z2)
                + query(x1 - 1, y2, z1 - 1)
                + query(x2, y1 - 1, z1 - 1)
                - query(x1 - 1, y1 - 1, z1 - 1))
    }

    val ans = StringBuilder()

    while(true){
        val str = reader.readLine().trim().split(" ").map{it.toInt()}

        when(str[0]){
            1 -> {
                val x = str[1]
                val y = str[2]
                val z = str[3]
                val k = str[4].toLong()
                update(x,y,z,k)

            }
            2 -> {
                val x1 = str[1]
                val y1 = str[2]
                val z1 = str[3]
                val x2 = str[4]
                val y2 = str[5]
                val z2 = str[6]

                val result = rangeSum(x1, y1, z1, x2, y2, z2)
                ans.append("$result\n")
            }
            3 -> {
                break
            }
        }
    }
    println(ans)
}