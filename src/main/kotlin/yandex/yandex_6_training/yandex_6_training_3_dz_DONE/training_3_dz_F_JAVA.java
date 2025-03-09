//package yandex_6_training_3_dz;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//import java.util.Stack;
//
//public class training_3_dz_F_JAVA {
//    public static void main(String[] args) throws IOException {
//        File INPUT = new File("input.txt");
//        File OUTPUT = new File("output.txt");
//
//        var bufferedReader = new java.io.BufferedReader(new java.io.FileReader(INPUT));
//        var outputWriter = new PrintWriter(OUTPUT);
//
//        int n = Integer.parseInt(bufferedReader.readLine());
//        String w = bufferedReader.readLine();
//        String s = bufferedReader.readLine();
//
//        Stack<Character> stack = new Stack<>();
//        StringBuilder ans = new StringBuilder();
//
//        int open = 0;
//
//        Map<Character, Character> map = Map.of(')', '(', ']', '[');
//
//        for (char c : s.toCharArray()) {
//            ans.append(c);
//            if (map.containsValue(c)) {
//                stack.push(c);
//                open++;
//            } else if (map.containsKey(c) && !stack.isEmpty() && stack.peek() == map.get(c)) {
//                stack.pop();
//            }
//        }
//
//        while (ans.length() < n) {
//            for (char c : w.toCharArray()) {
//                if (map.containsValue(c) && open < n / 2) {
//                    open++;
//                    ans.append(c);
//                    stack.push(c);
//                    break;
//                } else if (map.containsKey(c) && !stack.isEmpty() && stack.peek() == map.get(c)) {
//                    ans.append(c);
//                    stack.pop();
//                    break;
//                }
//            }
//        }
//
//        outputWriter.println(ans.toString());
//        outputWriter.close();
//        bufferedReader.close();
//    }
//}
