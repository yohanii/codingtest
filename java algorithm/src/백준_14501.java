import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_14501 {
    public void solution() throws IOException {

        //16m 22s
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[25];
        for (int i = n; i > 0; i--) {
            if (i + t[i-1] > n+1) {
                dp[i] = dp[i+1];
                continue;
            }

            dp[i] = Math.max(dp[i+1], dp[i + t[i-1]] + p[i-1]);
        }

        System.out.println(dp[1]);

    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
