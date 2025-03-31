## One Edit Distance (Lintcode)

```
class Solution:
    """
    @param s: a string
    @param t: a string
    @return: true if they are both one edit distance apart or false
    """
    def is_one_edit_distance(self, s: str, t: str) -> bool:
        # write your code here
        if len(s) < len(t):
            return self.is_one_edit_distance(t, s)
            
        len_s, len_t = len(s), len(t)
        
        if len_s - len_t > 1:
            return False
            
        for idx in range(len_t):
            if s[idx] != t[idx]:
                //вот тут замена s[i] to t[i], и проверяем, что оставшаяся часть строк совпадает.
                if len_s == len_t:
                    return s[idx + 1:] == t[idx + 1:]
                // вот тут удаление то есть s[i] удаляется, и оставшаяся часть совпадает с t.
                else:
                    return s[idx + 1:] == t[idx:]
        //тут вставка одно символа в s
        return len_s == len_t + 1
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```
бесплатно:
https://www.lintcode.com/problem/640/

разбор:
https://algo.monster/liteproblems/161
```

