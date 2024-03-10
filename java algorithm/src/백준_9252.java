import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_9252 {

    static int[][] dp;
    static String first, second;

    static String result;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //dp
        first = br.readLine();
        second = br.readLine();

        dp = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i < first.length() + 1; i++) {
            for (int j = 1; j < second.length() + 1; j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

//        for (int[] ints : dp) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }

        int answer = dp[first.length()][second.length()];
        System.out.println(answer);
        if (answer == 0) {
            return;
        }

        result = "";
        find(first.length(), second.length());

        System.out.println(result);
    }

    private void find(int x, int y) {
        if (x == 0 || y == 0) {
            return;
        }

        if (dp[x][y] > dp[x-1][y] && dp[x][y] > dp[x][y-1]) {
//            System.out.println(first.charAt(x-1));
            result = first.charAt(x-1) + result;
            find(x - 1, y - 1);
            return;
        }

        if (dp[x][y] == dp[x-1][y]) {
            find(x-1, y);
            return;
        }
        find(x, y-1);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
