## 540 · Zigzag Iterator (Lintcode)

```
public class ZigzagIterator {
    private int current;
    private List<Integer> indices = new ArrayList<>();
    private List<List<Integer>> vectors = new ArrayList<>();

    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        current = 0;
        indices.add(0);
        indices.add(0);
        vectors.add(v1);
        vectors.add(v2);
    }
    
    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        List<Integer> vector = vectors.get(current);
        int index = indices.get(current);
        int result = vector.get(index);
        indices.set(current, index + 1);
        current = (current + 1) % 2;
        return result;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        int start = current;
        while(indices.get(current) == vectors.get(current).size()){
            current = (current + 1) % 2;
            if (start == current){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.lintcode.com/problem/540/
```