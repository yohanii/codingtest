import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_2638 {

    static int[][] map, airMap;
    static int n, m;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Pos> cheeses = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    cheeses.add(new Pos(i, j));
                }
            }
        }

        int count = 0;
        while (!cheeses.isEmpty()) {
            //map 내부 색칠
            map = new int[n][m];
            cheeses.forEach(cheese -> map[cheese.x][cheese.y] = 1);
            airMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(airMap[i], 1);
            }
            for (int i = 0; i < n; i++) {
                dfs(i, 0);
                dfs(i, m - 1);
            }
            for (int i = 0; i < m; i++) {
                dfs(0, i);
                dfs(n - 1, i);
            }

            cheeses = cheeses.stream()
                    .filter(cheese -> !isSatisfied(cheese))
                    .collect(Collectors.toList());

            count++;
        }
        System.out.println(count);



//        System.out.println("map");
//        for (int[] ints : map) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println("");
//        }
    }

    private void dfs(int x, int y) {
        if (map[x][y] == 1) {
            return;
        }

        airMap[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] == 0 && airMap[newX][newY] == 1) {
                dfs(newX, newY);
            }
        }
    }

    private boolean isSatisfied(Pos pos) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int newX = pos.x + dx[i];
            int newY = pos.y + dy[i];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m && airMap[newX][newY] == 0) {
                count++;
            }
        }

        if (count >= 2) {
            return true;
        }
        return false;
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
