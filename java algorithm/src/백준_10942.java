import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_10942 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //펠린드롬 판별 check(str) O(n) - 받은 숫자 string, 거꾸로 string 만들고 비교
        //dp
        //y-x == 0 -> dp[x][y] = 1
        //dp[x+1][y-1] == 1 && str[x] == str[y] -> dp[x][y] = 1
        //dp[x+1][y-1] == 1 && str[x] != str[y] -> dp[x][y] = 0
        //dp[x+1][y-1] == 0 && str[x] == str[y] -> dp[x][y] = 0
        //dp[x+1][y-1] == 0 && str[x] != str[y] -> dp[x][y] = check(str)
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j < n+1; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                if (j-i == 1) {
                    if (nums[i-1].equals(nums[j-1])) {
                        dp[i][j] = 1;
                    }
                    continue;
                }

                //j-i >= 2
                if (dp[i+1][j-1] == 1) {
                    if (nums[i-1].equals(nums[j-1])) {
                        dp[i][j] = 1;
                    }
                    continue;
                }

                //j-i >= 2 && dp[x+1][y-1] == 0
                if (nums[i-1].equals(nums[j-1])) {
                    dp[i][j] = 0;
                }
                //j-i >= 2 && dp[x+1][y-1] == 0 && nums[i-1].equals(nums[j-1]) == false
                dp[i][j] = check(i - 1, j - 1, nums);

            }
        }

//        System.out.println("dp");
//        for (int[] ints : dp) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }


        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end]).append("\n");
        }
        System.out.println(sb);
    }

    private int check(int x, int y, String[] nums) {
        for (int i = 0; i < (y-x+1) / 2; i++) {
            if (!nums[x + i].equals(nums[y-i])) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
