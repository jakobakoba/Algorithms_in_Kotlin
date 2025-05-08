package yandex.yandex_7_training.yandex_7_training_2_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val P = 1_000_000_007L
    val X_ = 257L
    val MAXN = 100005

    val xPow = LongArray(MAXN)
    val geomSum = LongArray(MAXN)

    val n = reader.readLine().toInt()
    var paddedN = 1
    while (paddedN < n) {
        paddedN *= 2
    }
    val treeSize = paddedN * 2

    val nums = reader.readLine().trim().split(" ").map { it.toInt() }

    val hashTree = LongArray(treeSize)
    val lenTree = IntArray(treeSize)
    val lazyTree = LongArray(treeSize) { 0L }
    fun combineHashes(hLeft: Long, lenLeft: Int, hRight: Long, lenRight: Int): Long {
        if (lenLeft == 0) return (hRight % P + P) % P
        if (lenRight == 0) return (hLeft % P + P) % P


        val powerIndex = if (lenRight < xPow.size) lenRight else xPow.size - 1

        if (powerIndex < 0) return (hRight % P + P) % P

        val hL_mod = (hLeft % P + P) % P
        val hR_mod = (hRight % P + P) % P
        val pow_mod = (xPow[powerIndex] % P + P) % P

        return ((hL_mod * pow_mod) % P + hR_mod) % P
    }


    fun push(v: Int) {
        if (lazyTree[v] == 0L || v >= paddedN) {
            lazyTree[v] = 0L
            return
        }

        val assignedValue = lazyTree[v]
        val leftChild = 2 * v
        val rightChild = 2 * v + 1

        if (leftChild >= treeSize || rightChild >= treeSize) {
            lazyTree[v] = 0L
            return
        }


        lazyTree[leftChild] = assignedValue

        val leftLenIndex = minOf(lenTree[leftChild], geomSum.size - 1)
        if (leftLenIndex >= 0) {
            hashTree[leftChild] = (assignedValue * geomSum[leftLenIndex]) % P
            if (hashTree[leftChild] < 0) hashTree[leftChild] += P
        } else {
            hashTree[leftChild] = 0L
        }

        lazyTree[rightChild] = assignedValue
        val rightLenIndex = minOf(lenTree[rightChild], geomSum.size - 1)
        if (rightLenIndex >= 0) {
            hashTree[rightChild] = (assignedValue * geomSum[rightLenIndex]) % P
            if (hashTree[rightChild] < 0) hashTree[rightChild] += P
        } else {
            hashTree[rightChild] = 0L
        }

        lazyTree[v] = 0L
    }

    fun buildTree(a: List<Int>, v: Int, tl: Int, tr: Int) {
        lazyTree[v] = 0L
        lenTree[v] = tr - tl + 1
        if (tl == tr) {
            if (tl < a.size) {
                hashTree[v] = (a[tl].toLong() % P + P) % P
            } else {
                hashTree[v] = 0L
            }
        } else {
            val tm = tl + (tr - tl) / 2
            val leftChild = 2 * v
            val rightChild = 2 * v + 1
            buildTree(a, leftChild, tl, tm)
            buildTree(a, rightChild, tm + 1, tr)
            hashTree[v] = combineHashes(hashTree[leftChild], lenTree[leftChild], hashTree[rightChild], lenTree[rightChild])
        }
    }
    fun initializeHashing(limit: Int) {
        xPow[0] = 1L
        geomSum[0] = 0L
        geomSum[1] = 1L
        for (i in 1 until limit) {
            if (i < MAXN) {
                xPow[i] = (xPow[i - 1] * X_) % P
            }
            if (i + 1 < MAXN) {
                geomSum[i + 1] = (geomSum[i] + xPow[i]) % P
                if (geomSum[i + 1] < 0) geomSum[i + 1] += P
            }
        }
    }

    fun assignRange(v: Int, tl: Int, tr: Int, l: Int, r: Int, k: Long) {
        if (l > r || tl > r || tr < l) {
            return
        }
        if (l <= tl && tr <= r) {
            val k_mod = (k % P + P) % P
            lazyTree[v] = k_mod
            val lenIndex = minOf(lenTree[v], geomSum.size - 1)
            if (lenIndex >= 0) {
                hashTree[v] = (k_mod * geomSum[lenIndex]) % P
                if (hashTree[v] < 0) hashTree[v] += P
            } else {
                hashTree[v] = 0L
            }
        } else {
            push(v)
            val tm = tl + (tr - tl) / 2
            val leftChild = 2 * v
            val rightChild = 2 * v + 1
            assignRange(leftChild, tl, tm, l, r, k)
            assignRange(rightChild, tm + 1, tr, l, r, k)
            hashTree[v] = combineHashes(hashTree[leftChild], lenTree[leftChild], hashTree[rightChild], lenTree[rightChild])
        }
    }

    fun queryHash(v: Int, tl: Int, tr: Int, l: Int, r: Int): Pair<Long, Int> {
        if (l > r || tl > r || tr < l) {
            return Pair(0L, 0)
        }
        if (l <= tl && tr <= r) {
            return Pair(hashTree[v], lenTree[v])
        }

        push(v)

        val tm = tl + (tr - tl) / 2
        val leftChild = 2 * v
        val rightChild = 2 * v + 1

        val (hLeft, lenLeft) = queryHash(leftChild, tl, tm, l, r)
        val (hRight, lenRight) = queryHash(rightChild, tm + 1, tr, l, r)

        val combinedHash = combineHashes(hLeft, lenLeft, hRight, lenRight)
        val combinedLen = lenLeft + lenRight
        return Pair(combinedHash, combinedLen)
    }

    initializeHashing(minOf(paddedN + 1, MAXN))


    buildTree(nums, 1, 0, paddedN - 1)


    val q = reader.readLine().toInt()
    val result = StringBuilder()

    repeat(q) {
        val line = reader.readLine().trim().split(" ")
        val type = line[0].toInt()
        val l = line[1].toInt()
        val r = line[2].toInt()
        val k = line[3].toInt()

        if (type == 0) {
            assignRange(1, 0, paddedN - 1, l - 1, r - 1, k.toLong())
        } else {
            val l1 = l - 1
            val r1 = l + k - 2
            val l2 = r - 1
            val r2 = r + k - 2

            val (hash1, len1) = queryHash(1, 0, paddedN - 1, l1, r1)
            val (hash2, len2) = queryHash(1, 0, paddedN - 1, l2, r2)

            val finalHash1 = (hash1 % P + P) % P
            val finalHash2 = (hash2 % P + P) % P

            if (len1 == k && len2 == k && finalHash1 == finalHash2) {
                result.append('+')
            } else {
                result.append('-')
            }
        }
    }

    println(result.toString())
}