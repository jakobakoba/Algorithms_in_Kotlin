package yandex_6_training_2_dz;
//в яндекс контесте package надо убрать

import java.io.*;
import java.util.*;

public class Problem_I_JAVA {
    public static void main(String[] args) throws Exception {


        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
        PrintWriter outputWriter = new PrintWriter(new FileWriter("output.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            int n = Integer.parseInt(line.trim());

            long[] a = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(
                    Long::parseLong).toArray();

            long[] b = Arrays.stream(bufferedReader.readLine().split(" ")).mapToLong(
                    Long::parseLong).toArray();

            int[] p = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(
                    Integer::parseInt).toArray();

            Stack<Integer> aStack = new Stack<>();
            Stack<Integer> bStack = new Stack<>();

            List<Integer> aSorted = new ArrayList<>();
            List<Integer> bSorted = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                aSorted.add(i);
                bSorted.add(i);
            }

            aSorted.sort(Comparator
                    .comparing((Integer i) -> a[i])
                    .thenComparing((Integer i) -> b[i])
                    .thenComparing(Comparator.reverseOrder()));

            bSorted.sort(Comparator
                    .comparing((Integer i) -> b[i])
                    .thenComparing((Integer i) -> a[i])
                    .thenComparing(Comparator.reverseOrder()));

            aStack.addAll(aSorted);
            bStack.addAll(bSorted);

            int[] result = new int[n];
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                if (p[i] == 1) {
                    while (set.contains(bStack.peek())) {
                        bStack.pop();
                    }
                    int value = bStack.pop();
                    set.add(value);
                    result[i] = value + 1;
                } else {
                    while (set.contains(aStack.peek())) {
                        aStack.pop();
                    }
                    int value = aStack.pop();
                    set.add(value);
                    result[i] = value + 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    sb.append(result[i]);
                } else {
                    sb.append(result[i]).append(" ");
                }
            }
            outputWriter.println(sb.toString());
        }

        outputWriter.close();
        bufferedReader.close();
    }
}