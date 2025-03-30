## 3151. Special Array I


```
bool isArraySpecial(int* nums, int numsSize) {
    int n = numsSize;

    bool ans = true;
    int i;
    for (i = 0; i < n - 1; i++){
        if ((nums[i] % 2 == 0) == (nums[i + 1] % 2 == 0)){
            ans = false;
            break;
        }
    }
    return ans;
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
parity это odd and even
```