import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class 백준_1005 {

    static List<Integer>[] parent;
    static int[] dp, d;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            d = new int[n+1];
            parent = new ArrayList[n+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n+1; i++) {
                d[i] = Integer.parseInt(st.nextToken());
                parent[i] = new ArrayList<>();
            }

            for (int i =0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                parent[c].add(p);
            }

            int goal = Integer.parseInt(br.readLine());

            dp = new int[n+1];
            Arrays.fill(dp, -1);
            int result = getTime(goal);

//            System.out.print("dp: ");
//            for (int i : dp) {
//                System.out.print(i + " ");
//            }
//            System.out.println();

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private int getTime(int index) {
//        System.out.println("index = " + index);
//        System.out.print("dp: ");
//        for (int i : dp) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        if (dp[index] != -1) {
            return dp[index];
        }

        int maxDp = 0;
        for (Integer p : parent[index]) {
            int pTime = getTime(p);
            if (pTime > maxDp) {
                maxDp = pTime;
            }
        }

        return dp[index] = maxDp + d[index];
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
