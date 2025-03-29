## Longest Substring with At Most Two Distinct Characters (Lintcode)

```
class Solution:
    """
    @param s: a string
    @return: the length of the longest substring T that contains at most 2 distinct characters
    """
    def length_of_longest_substring_two_distinct(self, s: str) -> int:
        # Write your code here
        count = {}

        left = 0
        maximum = 0

        for right in range(len(s)):
            count[s[right]] = count.get(s[right], 0) + 1

            while len(count) > 2:
                count[s[left]] -= 1
                if count[s[left]] == 0:
                    del count[s[left]]
                left += 1
            maximum = max(maximum, right - left + 1)

        return maximum


```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1) размер не будет превышать 3


**Описание решения**
```
бесплатно:
https://www.lintcode.com/problem/928/

```

