import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_2206 {

    static int[][] map;
    static int[][][] visited;
    static int n, m;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        visited = new int[2][n][m];

        bfs(0, 0);
    }

    private void bfs(int startX, int startY) {

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(startX, startY, 0));

        while (!queue.isEmpty()) {
//            System.out.println(queue);
            Pos current = queue.poll();
            visited[current.wall][current.x][current.y] = 1;

            if (current.x == n - 1 && current.y == m - 1) {
                System.out.println(current.distance + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if (current.wall == 0) {
                        int nextValue = map[newX][newY];
                        if (visited[nextValue][newX][newY] == 0) {
                            queue.add(new Pos(newX, newY, nextValue, current.distance + 1));
                            visited[nextValue][newX][newY] = 1;
                        }
                        continue;
                    }

                    if (map[newX][newY] == 0 && visited[1][newX][newY] == 0) {
                        queue.add(new Pos(newX, newY, current.wall, current.distance + 1));
                        visited[1][newX][newY] = 1;
                    }
                }
            }

        }
        System.out.println(-1);
    }


    class Pos {
        int x;
        int y;
        int wall;
        int distance;

        public Pos(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.wall = 0;
        }

        public Pos(int x, int y, int wall, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
