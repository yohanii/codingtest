import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_9935 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mainStr = br.readLine();
        String bomb = br.readLine();

        if (bomb.length() == 1) {
            mainStr = mainStr.replaceAll(bomb, "");
            if (mainStr.isEmpty()) {
                System.out.println("FRULA");
                return;
            }
            System.out.println(mainStr);
            return;
        }

        //stackArr의 index cursor
        int stackIndex = 0;
        //bomb char 비교해서 맞으면 +1 / 1 ~ bomb.size() 저장
        int[] stackArr = new int[1000001];
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < mainStr.length(); index++) {
            char chr = mainStr.charAt(index);
//            if (stackArr[stackIndex] == 0) {
//                if (chr == bomb.charAt(stackArr[stackIndex])) {
//                    stackArr[stackIndex]++;
//                }
//                continue;
//            }
            stack.add(chr);
//            System.out.println("stack = " + stack);
//            System.out.println("stackIndex = " + stackIndex);
//            for (int i : stackArr) {
//                System.out.print(i);
//            }
//            System.out.println("");

            if (chr == bomb.charAt(0)) {
                stackIndex++;
                stackArr[stackIndex]++;
                continue;
            }

            if (chr == bomb.charAt(stackArr[stackIndex])) {
                stackArr[stackIndex]++;
            } else {
                stackIndex++;
            }

            if (stackArr[stackIndex] == bomb.length()) {
//                System.out.println("Main.solution");
                while (stackArr[stackIndex] > 0) {
                    stackArr[stackIndex]--;
                    stack.pop();
                }
                stackIndex--;
            }
        }


        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        System.out.println(stack.stream()
                .map(chr -> chr.toString())
                .collect(Collectors.joining()));


    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
