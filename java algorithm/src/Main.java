import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;



public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Integer a = Integer.parseInt(st.nextToken());
            Integer b = Integer.parseInt(st.nextToken());

            map.put(a, b);
        }
        Integer[] keyArr = map.keySet().toArray(new Integer[0]);
        Integer[] dp = new Integer[k+1];
        for(int i = 1; i < k+1; i++) {
            if(dp[i] == null) {
                if(map.get(i) ==null) {
                    dp[i] = 0;
                } else {
                    dp[i] = map.get(i);
                }
            }
            int j = 0;
            while(i > j && j < keyArr.length) {
                if(i - keyArr[j] > 0) {
                    if(dp[keyArr[j]] + dp[i - keyArr[j]] > dp[i]) {
                        dp[i] = dp[keyArr[j]] + dp[i - keyArr[j]];
                    }
                } else {
                    break;
                }
                j++;
            }
        }
        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
