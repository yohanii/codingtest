import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_11047_resolve {


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //방법
        //1. 가장 큰 동전부터 사용해 갯수를 센다

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
//        System.out.println(Arrays.toString(coins));

        int count = 0;
        int remain = k;
        for (int i = 0; i < n; i++) {
            if (remain == 0) {
                break;
            }

            int use = 0;
            int coin = coins[n - i - 1];

            use = remain / coin;
            remain -= use * coin;
            count += use;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
