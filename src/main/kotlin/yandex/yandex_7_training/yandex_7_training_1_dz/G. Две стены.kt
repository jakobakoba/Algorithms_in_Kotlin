import java.io.*

data class Brick(val index: Int, val length: Int, val color: Int)

fun main() {
    val cin = System.`in`.bufferedReader()
    val cout = PrintWriter(System.out.bufferedWriter())

    val line1 = cin.readLine().split(" ")
    val n = line1[0].toInt()
    val k = line1[1].toInt()


    val bricksByColor = Array(k + 1) { mutableListOf<Brick>() }
    for (i in 1..n) {
        val line = cin.readLine().split(" ")
        val l = line[0].toInt()
        val c = line[1].toInt()
        bricksByColor[c].add(Brick(i, l, c))
    }

    val sums = IntArray(k + 1)
    var W = -1

    for (color in 1..k) {
        if (bricksByColor[color].isEmpty()) {
            cout.println("NO")
            cout.flush()
            return
        }

        var colorSum = 0L
        for (brick in bricksByColor[color]) {
            colorSum += brick.length
        }

        if (colorSum > Int.MAX_VALUE) {
            cout.println("NO")
            cout.flush()
            return
        }
        sums[color] = colorSum.toInt()

        if (color == 1) {
            W = sums[1]
            if (W <= 0) {
                cout.println("NO")
                cout.flush()
                return
            }
        } else {
            if (sums[color] != W) {
                cout.println("NO")
                cout.flush()
                return
            }
        }
    }

    if (W < 2) {
        cout.println("NO")
        cout.flush()
        return
    }

    val dp = Array(k + 1) { BooleanArray(W + 1) { false } }
    val parent = Array(k + 1) { IntArray(W + 1) { -2 } }

    for (color in 1..k) {
        dp[color][0] = true
        parent[color][0] = -1

        val currentBricks = bricksByColor[color]
        for (i in currentBricks.indices) {
            val brick = currentBricks[i]
            val l = brick.length
            for (s in W downTo l) {
                if (dp[color][s - l] && !dp[color][s]) {
                    dp[color][s] = true
                    parent[color][s] = i
                }
            }
        }
    }
    for (L in 1..W / 2) {
        var canAllColorsMakeSumL = true
        for (color in 1..k) {
            if (!dp[color][L]) {
                canAllColorsMakeSumL = false
                break
            }
        }

        if (canAllColorsMakeSumL) {
            cout.println("YES")
            val selectedIndices = mutableListOf<Int>()

            for (color in 1..k) {
                var currentSum = L
                val currentBricks = bricksByColor[color]

                while (currentSum > 0) {
                    val brickIdxInList = parent[color][currentSum]

                    val brick = currentBricks[brickIdxInList]
                    selectedIndices.add(brick.index)
                    currentSum -= brick.length
                }
            }

            cout.println(selectedIndices.sorted().joinToString(" "))
            cout.flush()
            return
        }
    }

    cout.println("NO")
    cout.flush()
}