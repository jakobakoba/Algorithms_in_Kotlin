import java.io.File
import java.io.PrintWriter

fun main() {
    val inputFile = File("input.txt")
    val commands = inputFile.readLines()

    val tree = mutableListOf<Any?>()


    fun add(root: MutableList<Any?>, key: Int) {
        if (root.isEmpty()) {
            root.addAll(listOf(key, null, null))
            println("DONE")
            return
        }

        val rootKey = root[0] as Int
        if (key == rootKey) {
            println("ALREADY")
            return
        } else if (key < rootKey) {
            val left = root[1]
            if (left == null) {
                root[1] = mutableListOf<Any?>(key, null, null)
                println("DONE")
            } else {
                @Suppress("UNCHECKED_CAST")
                add(left as MutableList<Any?>, key)
            }
        } else {
            val right = root[2]
            if (right == null) {
                root[2] = mutableListOf<Any?>(key, null, null)
                println("DONE")
            } else {
                @Suppress("UNCHECKED_CAST")
                add(right as MutableList<Any?>, key)
            }
        }
    }

    fun search(root: MutableList<Any?>, key: Int) {
        if (root.isEmpty()) {
            println("NO")
            return
        }

        val rootKey = root[0] as Int
        if (key == rootKey) {
            println("YES")
            return
        } else if (key < rootKey) {
            val left = root[1]
            if (left == null) {
                println("NO")
            } else {
                @Suppress("UNCHECKED_CAST")
                search(left as MutableList<Any?>, key)
            }
        } else {
            val right = root[2]
            if (right == null) {
                println("NO")
            } else {
                @Suppress("UNCHECKED_CAST")
                search(right as MutableList<Any?>, key)
            }
        }
    }

    fun walk(root: MutableList<Any?>, depth: Int = 0) {
        if (root.isEmpty()) return

        val left = root[1]
        val right = root[2]

        if (left != null) {
            @Suppress("UNCHECKED_CAST")
            walk(left as MutableList<Any?>, depth + 1)
        }

        println(".".repeat(depth) + root[0])

        if (right != null) {
            @Suppress("UNCHECKED_CAST")
            walk(right as MutableList<Any?>, depth + 1)
        }
    }

    for (command in commands) {
        val parts = command.split(" ")
        when (parts[0]) {
            "ADD" -> add(tree, parts[1].toInt())
            "SEARCH" -> search(tree, parts[1].toInt())
            "PRINTTREE" -> walk(tree)
        }
    }
}
