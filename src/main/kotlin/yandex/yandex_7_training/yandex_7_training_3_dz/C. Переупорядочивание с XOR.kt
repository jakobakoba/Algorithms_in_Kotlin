package yandex.yandex_7_training.yandex_7_training_3_dz

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

typealias ParentInfo = Pair<Int, Int>

fun findPathAndExecuteSwaps(
    k_start: Int,
    nums: MutableList<Long>,
    oddParityCols: MutableSet<Int>,
    n: Int,
    bitWidthL: Int
): Boolean {
    val queue = ArrayDeque<Int>()
    val visited = BooleanArray(bitWidthL)
    val parentData = Array<ParentInfo?>(bitWidthL) { null }

    if (k_start >= bitWidthL) return false

    queue.add(k_start)
    visited[k_start] = true
    var k_end = -1

    while (queue.isNotEmpty()) {
        val currentK = queue.poll()
        if (currentK != k_start && oddParityCols.contains(currentK)) {
            k_end = currentK
            break
        }

        for (nextK in 0 until bitWidthL) {
            if (!visited[nextK]) {
                var edgeViaIndex = -1
                for (i in 0 until n) {
                    val bitCurrent = (nums[i] shr currentK) and 1L
                    val bitNext = (nums[i] shr nextK) and 1L
                    if (bitCurrent != bitNext) {
                        edgeViaIndex = i
                        break
                    }
                }
                if (edgeViaIndex != -1) {
                    visited[nextK] = true
                    parentData[nextK] = ParentInfo(currentK, edgeViaIndex)
                    queue.add(nextK)
                }
            }
        }
    }

    if (k_end == -1) {
        return false
    }

    val pathEdges = ArrayDeque<Pair<Int, Int>>()
    var tempNode = k_end
    while (tempNode != k_start) {
        val parentInfo = parentData[tempNode]
        if (parentInfo == null) {
            return false
        }
        val prevNode = parentInfo.first
        pathEdges.addFirst(Pair(prevNode, tempNode))
        tempNode = prevNode
    }

    val originalNumsForPath = nums.toList()
    var violation = false

    for (edge in pathEdges) {
        val currentK = edge.first
        val nextK = edge.second

        var indexToUse = -1
        for (i in 0 until n) {
            val bitCurrent = (nums[i] shr currentK) and 1L
            val bitNext = (nums[i] shr nextK) and 1L
            if (bitCurrent != bitNext) {
                indexToUse = i
                break
            }
        }

        if (indexToUse == -1) {
            violation = true
            break
        }

        val swapMask = (1L shl currentK) xor (1L shl nextK)
        val originalValue = nums[indexToUse]
        val newValue = originalValue xor swapMask

        if (newValue == 0L) {
            violation = true
            break
        }

        if (newValue >= (1L shl bitWidthL)) {
            violation = true
            break
        }

        nums[indexToUse] = newValue
    }

    if (violation) {
        for (i in 0 until n) {
            nums[i] = originalNumsForPath[i]
        }
        return false
    } else {
        oddParityCols.remove(k_end)
        return true
    }
}


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().trim().toInt()
    val numsList = reader.readLine().trim().split(" ").map { it.toLong() }
    val nums = numsList.toMutableList()

    var totalPopcount = 0L
    var initialMax = 0L
    if (nums.isNotEmpty()) {
        initialMax = nums.maxOrNull() ?: 0L
    }

    val bitWidthL = if (initialMax == 0L) 1 else (64 - initialMax.countLeadingZeroBits())

    for (num in nums) {
        totalPopcount += num.countOneBits()

    }

    if (totalPopcount % 2L != 0L) {
        println("impossible")
        return
    }

    var cur = 0L
    for (x in nums) {
        cur = cur xor x
    }

    val oddParityCols = mutableSetOf<Int>()
    for (k in 0 until bitWidthL) {
        if ((cur shr k) and 1L == 1L) {
            oddParityCols.add(k)
        }
    }

    while (oddParityCols.isNotEmpty()) {
        val currentOddCols = oddParityCols.toList()
        val k_start = currentOddCols[0]
        oddParityCols.remove(k_start)

        val pathFoundAndValid = findPathAndExecuteSwaps(k_start, nums, oddParityCols, n, bitWidthL)

        if (!pathFoundAndValid) {
            println("impossible")
            return
        }
    }

    println(nums.joinToString(" "))
}