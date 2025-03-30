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
                if len_s == len_t:
                    return s[idx + 1:] == t[idx + 1:]
                else:
                    return s[idx + 1:] == t[idx:]
        return len_s == len_t + 1
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

https://algo.monster/liteproblems/161
```

