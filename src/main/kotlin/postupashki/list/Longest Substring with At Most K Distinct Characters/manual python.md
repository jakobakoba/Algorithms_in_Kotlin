## Longest Substring with At Most K Distinct Characters (Lintcode)

```
class Solution:
    """
    @param s: A string
    @param k: An integer
    @return: An integer
    """
    def length_of_longest_substring_k_distinct(self, s: str, k: int) -> int:
        # write your code here
        count = {}

        left = 0

        maximum = 0

        for right in range(len(s)):
            char = s[right]

            count[char] = count.get(char, 0) + 1

            while len(count) > k :
                left_char = s[left]
                count[left_char] -= 1
                if count[left_char] == 0:
                    del count[left_char]
                left += 1

            maximum = max(maximum, right - left + 1)

        return maximum


```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1) только алфавит 26 букв


**Описание решения**
```
https://www.lintcode.com/problem/386/
```

