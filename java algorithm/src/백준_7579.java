import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class 백준_7579 {

    static int n, m;
    static int[] memory, cost;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        memory = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int costSum = Arrays.stream(cost).reduce(Integer::sum).getAsInt();

        //dp [index][cost] = memory
        //dp[i][j] = max(dp[i-1][j-cost] + memory, dp[i-1][cost])
        int[][] dp = new int[n][costSum+1];
        for (int i = cost[0]; i < costSum + 1; i++) {
            dp[0][i] = memory[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < costSum+1; j++) {
                if (j-cost[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j-cost[i]] + memory[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }

//                if (i == n-1 && dp[i][j] >= m) {
//                    System.out.println(j);
//                    return;
//                }
            }
        }

        for (int i = 0; i < costSum + 1; i++) {
            if (dp[n-1][i] >= m) {
                System.out.println(i);
                break;
            }
        }

//        for (int[] ints : dp) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }


    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
