import java.io.File
import java.io.PrintWriter

fun main() {
    val INPUT = File("input.txt").inputStream()
    val OUTPUT = File("output.txt").outputStream()

    val bufferedReader = INPUT.bufferedReader()
    val outputWriter = PrintWriter(OUTPUT, true)

    while (true) {
        val n = bufferedReader.readLine()?.toInt() ?: break
        val s = bufferedReader.readLine().trim().split(" ").map { it.toLong() }
        val (m, k) = bufferedReader.readLine().split(" ").map { it.toInt() }
        val starters = bufferedReader.readLine().trim().split(" ").map { it.toInt() }


        var left = 0
        var right = 1

        val stops = IntArray(n)

        var t = 0

        while(right < n){

            if (s[right - 1] > s[right]) {
                left = right
                stops[right] = left
                t = 0
            } else if (s[right - 1] < s[right]){
                stops[right] = left
            } else if (s[right - 1] == s[right]){
                t += 1
                if (t > k){
                    while(left < right && t > k){
                        if (s[left] == s[left + 1]){
                            t -= 1
                        }
                        left++
                    }
                    stops[right] = left
                }
                // t < k значит можно спокойно добавить s[right] = left
                else {
                    stops[right] = left
                }
            }
            right++
        }

        val sb = StringBuilder()
        for (index in starters){
            sb.append("${stops[index - 1] + 1} ")
        }
        outputWriter.println(sb.trim())


    }

    outputWriter.close()
    bufferedReader.close()
}
