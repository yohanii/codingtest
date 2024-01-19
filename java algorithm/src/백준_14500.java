import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_14500 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] totalVisited;
    static int maxValue;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //dfs
        //depth 0,1,2,3
        //depth 1에서 2,3 동시에 할 수 있어야함
        //모든 좌표 돌면서 totalVisited 체크하고 접근 x
        //각 좌표에서 dfs하는데 visited 체크하고 dfs 끝나면 다시 원복
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxValue = Integer.MIN_VALUE;
        visited = new boolean[n][m];

//        totalVisited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, map[i][j]);
                visited[i][j] = false;
//                totalVisited[i][j] = 1;
            }
        }
        System.out.println(maxValue);

    }

    private void dfs(int x, int y, int depth, int sum) {
        if (depth == 3) {
            maxValue = Math.max(maxValue, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newX >= n || newY < 0 || newY >= m) {
                continue;
            }

            if (!visited[newX][newY]) {
                if (depth == 1) {
                    visited[newX][newY] = true;
                    dfs(x, y, 2, sum + map[newX][newY]);
                    visited[newX][newY] = false;
                }

                visited[newX][newY] = true;
                dfs(newX, newY, depth + 1, sum + map[newX][newY]);
                visited[newX][newY] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
