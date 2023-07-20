import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;



public class 백준_11053 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max_dp = -1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[j] > dp[i]) {
                    dp[i] = dp[j];
                }
            }
            dp[i]++;
            if(max_dp < dp[i]) {
                max_dp = dp[i];
            }
        }
        System.out.println(max_dp);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
