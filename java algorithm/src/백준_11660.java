import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class 백준_11660 {

    static int[][] graph;
    static int[][] dp;
    static int[] xy;

    public static void cal() {
        int x1 = xy[0]-1;
        int y1 = xy[1]-1;
        int x2 = xy[2]-1;
        int y2 = xy[3]-1;
        if(x1==0 && y1==0){
            System.out.println(dp[x2][y2]);
        }else if(x1==0){
            System.out.println(dp[x2][y2] - dp[x2][y1-1]);
        }else if(y1==0){
            System.out.println(dp[x2][y2] - dp[x1-1][y2]);
        }else{
            System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
        }
    }


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        xy = new int[4];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i==0&&j==0){
                    dp[i][j] = graph[i][j];
                }else if(i==0){
                    dp[i][j] = dp[i][j-1] + graph[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + graph[i][j];
                } else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + graph[i][j];
                }
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                xy[j] = Integer.parseInt(st.nextToken());
            }

            cal();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
