## 721. Accounts Merge

```
class Solution {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val graph = mutableMapOf<String, MutableSet<String>>()
        val emailName = mutableMapOf<String, String>()

        for (account in accounts){
            val name = account[0]
            val firstEmail = account[1]
            for (i in 1 until account.size){
                val email = account[i]
                graph.computeIfAbsent(email){mutableSetOf()}.add(firstEmail)
                graph.computeIfAbsent(firstEmail){mutableSetOf()}.add(email)
                emailName[email] = name
            }
        }
        
        val visited = mutableSetOf<String>()

        fun dfs(email: String, component: MutableList<String>){
            visited.add(email)
            component.add(email)
            for (neighbor in graph[email]!!){
                if (neighbor !in visited){
                    dfs(neighbor, component)
                }
            }
        }

        val result = mutableListOf<List<String>>()

        for (email in graph.keys){
            if (email !in visited){
                val component = mutableListOf<String>()
                dfs(email, component)
                component.sort()

                val name = emailName[email]!!
                result.add(listOf(name) + component)
            }
        }
        return result
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

