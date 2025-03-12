## 908 · Line Reflection (Lintcode)

```
public class Solution {
    /**
     * @param points: n points on a 2D plane
     * @return: if there is such a line parallel to y-axis that reflect the given points
     */
    public boolean isReflected(int[][] points) {
        // Write your code here
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        Set<List<Integer>> pointSet = new HashSet<>();

        for (int[] point : points){
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            pointSet.add(List.of(point[0], point[1]));
        }

        int sum = minX + maxX;

        for (int[] point: points){
            if(!pointSet.contains(List.of(sum - point[0], point[1]))){
                return false;
            }
        }
        return true;
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://algo.monster/liteproblems/356
```