import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_17070 {
    static int n, successCount;
    static int[][] graph;
    enum Status {RIGHT, MIDDLE, UNDER}

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        successCount = 0;
        dfs(new Pos(0, 1), Status.RIGHT);
        System.out.println(successCount);
    }

    private void dfs(Pos pos, Status status) {
        if (pos.x == n-1 && pos.y == n-1) {
            successCount++;
            return;
        }

        switch (status) {
            case RIGHT :
                moveRight(pos);
                moveMiddle(pos);
                break;
            case MIDDLE:
                moveRight(pos);
                moveUnder(pos);
                moveMiddle(pos);
                break;
            case UNDER:
                moveUnder(pos);
                moveMiddle(pos);
                break;
        }
    }

    private void moveRight(Pos pos) {
        int newX = pos.x;
        int newY = pos.y + 1;
        if (newY < n && graph[newX][newY] == 0) {
            dfs(new Pos(newX, newY), Status.RIGHT);
        }
    }

    private void moveMiddle(Pos pos) {
        int newX = pos.x + 1;
        int newY = pos.y + 1;
        if (newX < n && newY < n && graph[newX][newY] == 0 && graph[newX - 1][newY] == 0 && graph[newX][newY - 1] == 0) {
            dfs(new Pos(newX, newY), Status.MIDDLE);
        }
    }

    private void moveUnder(Pos pos) {
        int newX = pos.x + 1;
        int newY = pos.y;
        if (newX < n && graph[newX][newY] == 0) {
            dfs(new Pos(newX, newY), Status.UNDER);
        }
    }

    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
