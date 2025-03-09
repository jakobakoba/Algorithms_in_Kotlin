package yandex.yandex_6_training.yandex_6_training_3_dz_DONE;

import java.io.*;
import java.util.*;

public class training_3_dz_I_JAVA_FINAL {
    static class Rover {
        int index;
        int time;

        Rover(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        File INPUT = new File("input.txt");
        File OUTPUT = new File("output.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT)));
        PrintWriter outputWriter = new PrintWriter(new FileOutputStream(OUTPUT), true);

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) break;
            int n = Integer.parseInt(line);

            String[] mainRoadDirections = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(mainRoadDirections[0]) % 4;
            int b = Integer.parseInt(mainRoadDirections[1]) % 4;

            Set<Integer> mainDirections = new HashSet<>(Arrays.asList(a, b));

            PriorityQueue<Rover>[] directions = new PriorityQueue[4];
            for (int i = 0; i < 4; i++) {
                directions[i] = new PriorityQueue<>(Comparator.comparingInt(r -> r.time));
            }

            for (int i = 0; i < n; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                int direction = Integer.parseInt(input[0]) % 4;
                int time = Integer.parseInt(input[1]) - 1;
                directions[direction].add(new Rover(i, time));
            }

            int[] ans = new int[n];
            int timer = 0;

            while (!Arrays.stream(directions).allMatch(PriorityQueue::isEmpty)) {
                List<Integer> passed = new ArrayList<>();

                for (int d = 0; d < 4; d++) {
                    if (directions[d].isEmpty()) continue;
                    Rover rover = directions[d].peek();

                    if (rover.time > timer) continue;

                    int rightDir = (d + 3) % 4;
                    int leftDir = (d + 1) % 4;
                    int oppositeDir = (d + 2) % 4;
                    boolean greenLight = true;

                    if (mainDirections.contains(d)) {
                        if (mainDirections.contains(rightDir) && !directions[rightDir].isEmpty() &&
                                directions[rightDir].peek().time <= timer) {
                            greenLight = false;
                        }
                    } else {
                        if (!directions[rightDir].isEmpty() && directions[rightDir].peek().time <= timer) {
                            greenLight = false;
                        }
                        if (mainDirections.contains(leftDir) && !directions[leftDir].isEmpty() &&
                                directions[leftDir].peek().time <= timer) {
                            greenLight = false;
                        }
                        if (mainDirections.contains(oppositeDir) && !directions[oppositeDir].isEmpty() &&
                                directions[oppositeDir].peek().time <= timer) {
                            greenLight = false;
                        }
                    }

                    if (greenLight) {
                        passed.add(d);
                        ans[rover.index] = timer + 1;
                    }
                }

                passed.forEach(dir -> directions[dir].poll());
                timer++;
            }

            for (int res : ans) {
                outputWriter.println(res);
            }
        }
        outputWriter.close();
    }
}
