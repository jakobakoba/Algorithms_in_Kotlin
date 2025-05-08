package postupashki.telegram.`Функция normalize`

fun main(){
    fun normalize(path: String): String {
        if (path == ""){
            return "."
        }

        val isAbsolute = path.startsWith("/")
        val parts = mutableListOf<String>()

        for (part in path.split("/")){
            if (part == "" || part == "."){
                continue
            }
            else if (part == ".."){
                if (parts.isNotEmpty() && parts.last() != ".."){
                    parts.removeLast()
                } else {
                    if (!isAbsolute){
                        parts.add(part)
                    }
                }
            } else {
                parts.add(part)
            }
        }

        var normalized = parts.joinToString("/")

        return when {
            normalized == "" -> if (isAbsolute) "/" else "."
            isAbsolute -> "/$normalized"
            else -> normalized
        }
    }

    println(normalize("/foo/bar//bax/asdf/quux/.."))
    println(normalize("a/../../b"))
    println(normalize("/a/../../b"))
}