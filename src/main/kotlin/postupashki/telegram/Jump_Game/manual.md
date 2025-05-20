## 55. Jump Game

```
Задача с Яндекса.

Наконец то встретилась новая задача, которая к тому же есть на литкоде. 

Дается массив a. Вы стоите на самой левой позиции и хотите попасть на самую последнюю позицию. 
Когда вы стоите на позиции i, вы можете прыгнуть максимум на a[i] позиций вперед. 
Вернуть true если можно с левого края попасть на правый край. 

Пример
3, 1, 2, 0, 0, 4.
Ответ false.

Решение:
От i той позиции мы можем прыгнуть на любую позицию из [i, a[i]+i]. Будем воспринимать 
это как отрезок. 
Тогда у нас получается n отрезков. Они между собой как то пересекаются. 

Если два отрезка пересекается это означает что вы можете попасть на любую позицию на объединение
 отрезков. 

Вам надо слить отрезки и убедиться что в одном отрезки находится позиция 0 и позиция n-1.

Слить все отрезки мы можем за О(n), так как отрезки отсортированы по первому числу.
 (кстати задача про сливания отрезков это старая задача Яндекса) 
Ссылка в комментариях.

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var max = 0
        var ans = true
        for (i in 0 until nums.size){
            if (i > max){
                ans = false
                break
            }
            max = maxOf(max, i + nums[i])
        }
        return ans
    }
}

another solution:
class Solution {
    fun canJump(nums: IntArray): Boolean {
        
        val n = nums.size
        var goal = n - 1
        for (i in n - 1 downTo 0){
            if (nums[i] + i >= goal){
                goal = i
            }
        }
        return 0 == goal
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

TIME LIMIT EXCEEDED без dp чистая рекурсия
```
class Solution {
fun canJump(nums: IntArray): Boolean {
val n = nums.size

        fun helper(i: Int): Boolean {
            if (i >= n) return false
            if (i == n - 1){
                return true
            }

            var maxSteps = nums[i]

            for (j in 1 .. maxSteps){
                if (helper(i + j)){
                    return true
                }
            }
            return false
        }

        return helper(0)
    }
}
```

рекурсия с memoization
```
class Solution {
    fun canJump(nums: IntArray): Boolean {
        val n = nums.size

        val dp = IntArray(n){-1}
        fun helper(i: Int ): Boolean {
            if (i >= n) return false
            if (i == n - 1) return true
            if (dp[i] != -1) return dp[i] == 1

            val steps = nums[i]
            for (j in 1 .. steps){
                if (helper(i + j)){
                    dp[i] = 1
                    return true
                }
            }
            dp[i] = 0
            return false
        }
        return helper(0)
    }
}
```
