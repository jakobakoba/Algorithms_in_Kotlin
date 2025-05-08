import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    when (reader.readLine()) {
        "pack" -> {
            val s = reader.readLine()
            val compressed = pack(s)
            println(compressed.size)
            println(compressed.joinToString(" "))
            System.out.flush()
        }
        "unpack" -> {
            val n = reader.readLine().toInt()
            val bytes = if (n > 0) reader.readLine().split(" ").map { it.toInt() } else emptyList()
            val original = unpack(bytes)
            println(original)
            System.out.flush()
        }
        else -> error("Unknown command")
    }
}

fun pack(s: String): List<Int> {
    if (s.isEmpty()) return emptyList()

    val dict = mutableMapOf<String, Int>().apply {
        for (i in 0..25) put(('a' + i).toString(), i)
    }
    var nextCode = 26

    var bitWidth = 5
    var threshold = 1 shl bitWidth
    val bits = mutableListOf<Boolean>()

    fun writeCode(code: Int) {
        for (b in bitWidth - 1 downTo 0) {
            bits.add(((code shr b) and 1) == 1)
        }
        if (nextCode >= threshold) {
            bitWidth++
            threshold = 1 shl bitWidth
        }
    }

    var w = s[0].toString()
    for (i in 1 until s.length) {
        val c = s[i]
        val wc = w + c
        if (dict.containsKey(wc)) {
            w = wc
        } else {
            writeCode(dict[w]!!)
            dict[wc] = nextCode++
            w = c.toString()
        }
    }
    writeCode(dict[w]!!)

    val payload = mutableListOf<Int>()
    var cur = 0
    var used = 0
    for (bit in bits) {
        cur = (cur shl 1) or if (bit) 1 else 0
        if (++used == 8) {
            payload.add(cur)
            cur = 0
            used = 0
        }
    }
    if (used > 0) {
        cur = cur shl (8 - used)
        payload.add(cur)
    }

    return payload
}

fun unpack(bytes: List<Int>): String {
    if (bytes.isEmpty()) return ""

    val bits = BooleanArray(bytes.size * 8) { i ->
        val b = bytes[i / 8]
        ((b shr (7 - (i % 8))) and 1) == 1
    }

    val dict = mutableMapOf<Int, String>().apply {
        for (i in 0..25) put(i, ('a' + i).toString())
    }
    var nextCode = 26
    var bitPos = 0
    var bitWidth = 5
    var threshold = 1 shl bitWidth

    fun readCode(): Int {
        var code = 0
        repeat(bitWidth) {
            code = (code shl 1) or if (bits[bitPos++]) 1 else 0
        }
        if (nextCode >= threshold - 1) {
            bitWidth++
            threshold = 1 shl bitWidth
        }
        return code
    }

    val firstCode = readCode()
    val out = StringBuilder(dict[firstCode]!!)
    var prevCode = firstCode

    while (bitPos + bitWidth <= bits.size) {
        val code = try {
            readCode()
        } catch (e: IndexOutOfBoundsException) {
            break
        }
        val entry = when {
            dict.containsKey(code) -> dict[code]!!
            code == nextCode -> dict[prevCode]!! + dict[prevCode]!!.first()
            else -> break
        }
        out.append(entry)
        dict[nextCode++] = dict[prevCode]!! + entry.first()
        prevCode = code
    }

    return out.toString()
}