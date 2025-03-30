## 1752. Check if Array Is Sorted and Rotated


```
bool check(int* nums, int numsSize) {

    int count = 1;
    int i;
    int n = numsSize;
    for (i = 1; i < 2 * n; i++){
        if (nums[(i - 1) % n] <= nums[i % n]){
            count += 1;
        } else {
            count = 1;
        }
        if (count == n){
            return true;
        }
    }
    return n == 1;
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```