## 374. Guess Number Higher or Lower



``` 
/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {
    
    override fun guessNumber(n:Int):Int {
        var left = 1
        var right = n
    
        var num = -1
        
        while(left <= right){
            val mid = left + (right - left) / 2

             when(guess(mid)){
                -1 -> {
                    right = mid - 1
                }
                1 -> {
                    left = mid + 1
                } 
                else -> {
                    num = mid
                    break
                }
            }
        }
        return num
    }
}

```

**Оценка по времени**:


**Оценка по памяти**:


**Описание решения**
```

```

