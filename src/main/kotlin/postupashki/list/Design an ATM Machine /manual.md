## 2241. Design an ATM Machine


```
class ATM() {

    val denominations = listOf(20, 50, 100, 200, 500)

    val count = IntArray(5){0}

    fun deposit(banknotesCount: IntArray) {
        for (i in 0 until 5){
            count[i] += banknotesCount[i]
        }
    }

    fun withdraw(amount: Int): IntArray {
        val ans = IntArray(5){0}
        var amount = amount

        for (i in 4 downTo 0){
            val used = minOf(amount  / denominations[i], count[i])
            ans[i] = used
            amount -= used * denominations[i]
        }

        if (amount != 0){
            return intArrayOf(-1)
        }

        for (i in 0 until 5){
            count[i] -= ans[i]
        }
        return ans
    }

}

/**
 * Your ATM object will be instantiated and called as such:
 * var obj = ATM()
 * obj.deposit(banknotesCount)
 * var param_2 = obj.withdraw(amount)
 */

```

**Оценка по времени**: О(denominations) то есть O(1)


**Оценка по памяти**:  О(denominations) то есть O(1)


**Описание решения**
```

```

