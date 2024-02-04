import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_17404 {

    static int n;
    static int[][] cost;
    static int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][3];
        int minCost = Integer.MAX_VALUE;
        for (int firstColor = 0; firstColor < 3; firstColor++) {

            for (int i = 0; i < 3; i++) {
                if (i == firstColor) {
                    dp[0][i] = cost[0][i];
                    continue;
                }
                dp[0][i] = 100000;
            }

            for (int i = 0; i < n-1; i++) {
                dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]) + cost[i + 1][0];
                dp[i + 1][1] = Math.min(dp[i][2], dp[i][0]) + cost[i + 1][1];
                dp[i + 1][2] = Math.min(dp[i][0], dp[i][1]) + cost[i + 1][2];
            }

            int min = -1;
            if (firstColor == 0) {
                min = Math.min(dp[n-1][1], dp[n - 1][2]);
            }
            if (firstColor == 1) {
                min = Math.min(dp[n-1][2], dp[n - 1][0]);
            }
            if (firstColor == 2) {
                min = Math.min(dp[n-1][0], dp[n - 1][1]);
            }
//            System.out.println(dp[n-1][0] + " " + dp[n-1][1] + " " + dp[n-1][2]);
            if (min < minCost) {
                minCost = min;
            }
        }
        System.out.println(minCost);


    }

    enum Color {
        RED, GREEN, BLUE
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
