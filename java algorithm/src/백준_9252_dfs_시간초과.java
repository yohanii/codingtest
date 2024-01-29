import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_9252_dfs_시간초과 {

    static String[] string1, string2;
    static String[] stackArr;
    static String[] maxLengthArr;
    static int maxLength;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        string1 = br.readLine().split("");
        string2 = br.readLine().split("");

        maxLength = Integer.MIN_VALUE;
        stackArr = new String[string1.length];
        dfs(0, 0, 0);
        System.out.println(maxLength);
        for (int i = 0; i < maxLength; i++) {
            System.out.print(maxLengthArr[i]);
        }
    }

    private void dfs(int index, int search, int stack) {
//        System.out.println(index + ", " + search + ", " + stack);
        if (index == string2.length) {
            if (stack > maxLength) {
                maxLength = stack;
                maxLengthArr = Arrays.copyOf(stackArr, stack);
//                System.out.println("case1: " + maxLength);
            }
        }


        for (int j = index; j < string2.length; j++) {
            String cur = string2[j];
            for (int i = search; i < string1.length; i++) {
                if (string1[i].equals(cur)) {
                    stackArr[stack] = cur;
                    dfs(j + 1, i + 1, stack + 1);
                    continue;
                }

                if (j == string2.length -1 && i == string1.length - 1) {
                    if (stack > maxLength) {
                        maxLength = stack;
                        maxLengthArr = Arrays.copyOf(stackArr, stack);
//                        System.out.println("case2: " + maxLength);
                    }
                    continue;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
