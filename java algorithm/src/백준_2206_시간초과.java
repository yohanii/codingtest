import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_2206_시간초과 {

    static int n, m;
    static int[][] graph;

    static int[][] dp;

    static int[][] visited;

    static int minDistance;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //dfs
        //벽 뚫기 1번 가능
        minDistance = Integer.MAX_VALUE;
        visited = new int[n][m];
        dfs(0, 0, 0, 0);

        if (minDistance > 10000000) {
            System.out.println(-1);
            return;
        }
        System.out.println(minDistance + 1);
    }

    private void dfs(int x, int y, int status, int distance) {
//        System.out.println("x, y = " + x + ", " + y + " status = " + status);
        if (x == n - 1 && y == m - 1) {
            if (minDistance > distance) {
                minDistance = distance;
            }
            return;
        }

        visited[x][y] = 1;
        if (dp[x][y] > distance) {
            dp[x][y] = distance;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && visited[newX][newY] == 0 && dp[newX][newY] >= distance + 1) {
//                System.out.println("graph[newX][newY]  = " + graph[newX][newY]);
                if (graph[newX][newY] == 0) {
//                    System.out.println("newX, newY = " + newX + ", " + newY);
                    dfs(newX, newY, status, distance + 1);
                    continue;
                }
                if (status == 0) {
                    dfs(newX, newY, 1, distance + 1);
                }
            }
        }
        visited[x][y] = 0;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
