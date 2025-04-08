package postupashki.telegram.email

/*
Имеется n пользователей, каждому из них соответствует список e-mail-ов (всего m). Например:

user1 -> xxx@ya.ru, foo@gmail.com, lol@mail.ru
user2 -> foo@gmail.com, ups@pisem.net
user3 -> xyz@pisem.net, vasya@pupkin.com
user4 -> ups@pisem.net, aaa@bbb.ru
user5 -> xyz@pisem.net

Считается, что если у двух пользователей общий email, значит, это один и тот же пользователь.

Требуется реализовать алгоритм, выполняющий слияние пользователей.
На выходе должен быть список пользователей с их e-mail-ами (такой же как на входе).
В качестве имени можно брать любое из исходных имен. Список e-mail-ов должен содержать
уникальные e-mail-ы. Параметры n и m произвольные.

В указанном примере ответ будет такой
user1 -> xxx@ya.ru, foo@gmail.com, lol@mail.ru, ups@pisem.net, aaa@bbb.ru
user3 -> xyz@pisem.net, vasya@pupkin.com

Нужно решение с линейной асимптотикой

Решение:
Довольно стандартная задача
Построим граф на пользователях такой, что два пользователя лежат в одной компоненте связности тогда
и только тогда, когда они должны быть объединены в одного пользователя. Для этого используем хеш-мапу:
для каждого e-mail-а список пользователей.
Соединим последовательно цепочкой этих пользователей друг с другом в графе.
Граф будет иметь размер порядка O(n + m). После этого найдем в графе компоненты связности
и восстановим по ним ответ на задачу

Итоговая асимптотика O(n + m)
 */

fun main(){
    val users = mapOf(
        "user1" to listOf("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"),
        "user2" to listOf("foo@gmail.com", "ups@pisem.net"),
        "user3" to listOf("xyz@pisem.net", "vasya@pupkin.com"),
        "user4" to listOf("ups@pisem.net", "aaa@bbb.ru"),
        "user5" to listOf("xyz@pisem.net")
    )

    fun solve(users: Map<String, List<String>>) {
        val map = mutableMapOf<String, MutableList<String>>()
        for ((user, emails) in users){
            for (email in emails){
                map.computeIfAbsent(email){mutableListOf()}.add(user)
            }
        }

        val graph = mutableMapOf<String, MutableList<String>>()
        for (user in users.keys){
            graph[user] = mutableListOf()
        }

        for ((_, userList) in map){
            for (i in 0 until userList.size - 1){
                graph[userList[i]]!!.add(userList[i + 1])
                graph[userList[i + 1]]!!.add(userList[i])
            }
        }

        val visited = mutableSetOf<String>()
        val components = mutableListOf<Set<String>>()

        fun dfs(user: String, component: MutableSet<String>){
            visited.add(user)
            component.add(user)
            for (neighbor in graph[user]!!){
                if(neighbor !in visited){
                    dfs(neighbor, component)
                }
            }
        }
        for (user in users.keys){
            if (user !in visited){
                val component = mutableSetOf<String>()
                dfs(user, component)
                components.add(component)
            }
        }

        val result = mutableMapOf<String, Set<String>>()
        for (component in components){
            val representative = component.first()
            val allEmails = component.flatMap{users[it]!!}.toSet()
            result[representative] = allEmails
        }

        for((user, emails) in result){
            println("$user -> ${emails.joinToString(", ")}")
        }
    }
    solve(users)
}