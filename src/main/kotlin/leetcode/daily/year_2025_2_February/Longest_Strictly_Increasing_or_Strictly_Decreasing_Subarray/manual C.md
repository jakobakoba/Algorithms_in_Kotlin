## 3105. Longest Strictly Increasing or Strictly Decreasing Subarray

```
#define max(a, b) ((a) > (b) ? (a) : (b))

int longestMonotonicSubarray(int* nums, int numsSize) {
    int cur = 1;
    int res = 1;
    int increasing = 0;

    int i;
    int n = numsSize;
    for (i = 1; i < n; i++){
        if (nums[i-1] < nums[i]){
            if (increasing > 0){
                cur += 1;
            } else {
                cur = 2;
                increasing = 1;
            }
        } else if (nums[i-1] > nums[i]){
            if (increasing < 0){
                cur += 1;
            } else {
                cur = 2;
                increasing = -1;
            }
        } else {
            cur = 1;
            increasing = 0;
        }
        res = max(res, cur);
    }
    return res;
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```