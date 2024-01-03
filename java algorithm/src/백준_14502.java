import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_14502 {
    static int maxZeroCount;
    static int n, m;
    static int[][] graph;
    static List<Pos> zeroList, oneList, twoList;
    static int[] dfsArr;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        zeroList = new ArrayList<>();
        oneList = new ArrayList<>();
        twoList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                switch (input) {
                    case 0:
                        zeroList.add(new Pos(i, j));
                        break;
                    case 1:
                        oneList.add(new Pos(i, j));
                        break;
                    case 2:
                        twoList.add(new Pos(i, j));
                        break;
                }
                graph[i][j] = input;
            }
        }

//        System.out.println("zeroList = " + zeroList);
//        System.out.println("oneList = " + oneList);
//        System.out.println("twoList = " + twoList);

        dfsArr = new int[3];
        maxZeroCount = Integer.MIN_VALUE;
        dfs(0, 0);
        System.out.println(maxZeroCount);
    }

    private void dfs(int depth, int value) {
        if (value >= zeroList.size()) {
            return;
        }

        dfsArr[depth] = value;

        if (depth == 2) {
            //동작
//            for (int i : dfsArr) {
//                System.out.print(i);
//            }
//            System.out.println("");

            //바이러스 퍼트리기
            bfs();
            //남은 0 개수 세기
            //0개수 max 값 찾기
        } else {
            dfs(depth + 1, value + 1);
        }
        dfs(depth, value + 1);
    }

    private void bfs() {
        int[][] visited = new int[n][m];
        int[][] diffusion = new int[n][m];
        for (int i = 0; i < diffusion.length; i++) {
            diffusion[i] = Arrays.copyOf(graph[i], m);
        }
        Pos pos1 = zeroList.get(dfsArr[0]);
        Pos pos2 = zeroList.get(dfsArr[1]);
        Pos pos3 = zeroList.get(dfsArr[2]);
        diffusion[pos1.x][pos1.y] = 1;
        diffusion[pos2.x][pos2.y] = 1;
        diffusion[pos3.x][pos3.y] = 1;

        Queue<Pos> queue = new LinkedList<>(twoList);
//        System.out.println(queue);
        while (!queue.isEmpty()) {

            Pos pos = queue.poll();
//            System.out.println("pos = " + pos);
            visited[pos.x][pos.y] = 1;
            diffusion[pos.x][pos.y] = 2;

            for (int i = 0; i < 4; i++) {
                int newX = pos.x + dx[i];
                int newY = pos.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && visited[newX][newY] == 0 && diffusion[newX][newY] == 0) {
                    visited[newX][newY] = 1;
                    queue.add(new Pos(newX, newY));
                }
            }
        }

        countRemainZero(diffusion);
    }

    private void countRemainZero(int[][] diffusion) {
        int zeroCount = 0;
        for (int[] arr : diffusion) {
            for (int elem : arr) {
                if (elem == 0) {
                    zeroCount++;
                }
            }
        }
        if (zeroCount > maxZeroCount) {
            maxZeroCount = zeroCount;
        }
//        System.out.println("zeroCount = " + zeroCount);
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
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
