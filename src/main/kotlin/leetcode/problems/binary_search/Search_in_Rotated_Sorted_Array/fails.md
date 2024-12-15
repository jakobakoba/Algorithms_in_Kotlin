### 12/12/2024
WA and TLE
offset condition should be left < right and condition the main one left <= right

### 14/12/2024
WA 136/196
- вернул left вместо right in findOffset()
- в search in while (left <= right) вместо left < right
- in while loop left = mid + 1 and right = mid - 1 instead of i + 1 and i - 1