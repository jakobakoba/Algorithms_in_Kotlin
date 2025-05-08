package yandex.yandex_7_training.yandex_7_training_4_dz

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    class Node(var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    val reader = BufferedReader(InputStreamReader(System.`in`))

    val n = reader.readLine().toInt()
    val otrezki = reader.readLine().split(" ").map { it.toInt() }

    var sum = 0L
    var head: Node? = null
    var prevNode: Node? = null

    for (num in otrezki) {
        val node = Node(num)
        sum += num.toLong() * num
        if (head == null) {
            head = node
        } else {
            prevNode!!.next = node
            node.prev = prevNode
        }
        prevNode = node
    }

    var curNode = head
    var curIndex = 1

    val k = reader.readLine().toInt()
    val sb = StringBuilder()
    sb.append(sum).append("\n")

    repeat(k) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        while (curIndex < b) {
            curNode = curNode!!.next
            curIndex++
        }
        while (curIndex > b) {
            curNode = curNode!!.prev
            curIndex--
        }

        when (a) {
            1 -> {
                val node = curNode!!
                val len = node.value
                sum -= len.toLong() * len

                val left = node.prev
                val right = node.next

                if (left != null && right != null) {
                    val x = if (len % 2 == 0) len / 2 else (len - 1) / 2
                    val y = len - x

                    sum -= left.value.toLong() * left.value
                    sum -= right.value.toLong() * right.value

                    left.value += x
                    right.value += y

                    sum += left.value.toLong() * left.value
                    sum += right.value.toLong() * right.value

                    left.next = right
                    right.prev = left

                    curNode = right
                } else if (left != null) {
                    sum -= left.value.toLong() * left.value

                    left.value += len
                    sum += left.value.toLong() * left.value
                    left.next = null

                    curNode = left
                    curIndex--
                } else {
                    sum -= right!!.value.toLong() * right.value

                    right.value += len
                    sum += right.value.toLong() * right.value

                    right.prev = null
                    head = right

                    curNode = right
                    curIndex = 1
                }
            }

            2 -> {
                val node = curNode!!
                val len = node.value
                sum -= len.toLong() * len

                val x = if (len % 2 == 0) len / 2 else (len - 1) / 2
                val y = len - x

                sum += x.toLong() * x
                sum += y.toLong() * y

                val left = node.prev
                val right = node.next

                val nodeX = Node(x)
                val nodeY = Node(y)

                nodeX.prev = left
                nodeX.next = nodeY
                nodeY.prev = nodeX
                nodeY.next = right

                if (left != null) {
                    left.next = nodeX
                } else {
                    head = nodeX
                }
                if (right != null) {
                    right.prev = nodeY
                }

                curNode = nodeX
            }
        }
        sb.append(sum).append("\n")
    }
    println(sb)
}
