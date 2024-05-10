import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_16946 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static boolean[][] smallVisited, visited;
    static int[][] map;
    static Set<Pos> walls;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //방법
        //1. 벽마다 이동할 수 있는 0의 개수를 센다
        //2. 0마다 둘러쌓인 벽에 +1해준다.
        //3. 0인 공간의 0갯수 세고, 둘러쌓인 벽에 그 갯수만큼 더해준다.

        //3번방법
        //1. nxm 돌면서 visited = false이고, 0인 지점에서 dfs 시작
        //2. dfs로 0의 갯수 먼저 세고, 동시에 벽 위치를 set에 저장
        //3. set에 저장된 pos에 zeroCount 더해주기
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }

        visited = new boolean[n][m];
        smallVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j);
                }
            }
        }
        printMap();
//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }
    }

    private void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]%10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void dfs(int i, int j) {
        walls = new HashSet<>();
        int zeroCount = dfsZero(i, j);
//        System.out.println("i, j = " + i + ", " + j);
//        System.out.println("zeroCount = " + zeroCount);
//        System.out.println("walls = " + walls);
//        smallVisited = new boolean[n][m];
//        updateMap(zeroCount, i, j);
        updateMap(zeroCount, walls);
    }

    private void updateMap(int zeroCount, Set<Pos> walls) {
        for (Pos wall : walls) {
            map[wall.x][wall.y] += zeroCount;
        }
    }

//    private void updateMap(int zeroCount, int i, int j) {
//        visited[i][j] = true;
//
//        for (int k = 0; k < 4; k++) {
//            int newX = i + dx[k];
//            int newY = j + dy[k];
//
//            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
//                if (map[newX][newY] != 0) {
//                    if (!smallVisited[newX][newY]) {
//                        smallVisited[newX][newY] = true;
//                        map[newX][newY] += zeroCount;
//                    }
//                    continue;
//                }
//                if (!visited[newX][newY]) {
//                    updateMap(zeroCount, newX, newY);
//                }
//            }
//        }
//    }

    private int dfsZero(int i, int j) {
        int result = 1;
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];

            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                if (map[newX][newY] == 0 && !visited[newX][newY]) {
                    result += dfsZero(newX, newY);
                    continue;
                }
                if (map[newX][newY] != 0) {
                    walls.add(new Pos(newX, newY));
                }
            }
        }

        return result;
    }

    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
