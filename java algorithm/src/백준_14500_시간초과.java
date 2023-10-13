import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_14500_시간초과 {
    static int n, m;
    static int[][] map;
    static int[][] visited;
    static int[][] bigVisited;
    static int result;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MIN_VALUE;
        bigVisited = new int[n][m];

        //ㅗ 모양 빼고 나머지 모양들
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited = new int[n][m];

                int dfsResult = dfs(i, j, 1);

                if(dfsResult > result)
                    result = dfsResult;

                bigVisited[i][j] = 1;
            }
        }
//        System.out.println(result);

        //ㅗ모양
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int score = getScore(i, j);
                if(score > result)
                    result = score;
            }
        }
        System.out.println(result);

    }

    private int getScore(int x, int y) {
        int count = 0;
        int result = map[x][y];
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newX < n && newY >= 0 && newY < m) {
                count++;
                result += map[newX][newY];
                list.add(map[newX][newY]);
            }
        }

        if(count <= 2) {
            return 0;
        } else if (count == 3) {
            return result;
        } else {
            return result - Collections.min(list);
        }
    }

    private int dfs(int x, int y, int count) {
        visited[x][y] = 1;

        if(count == 4)
            return map[x][y];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >= 0 && newX < n && newY >= 0 && newY < m && bigVisited[newX][newY] == 0 && visited[newX][newY] == 0) {
                if(count == 2) {
                    int dfsResult = dfs(x, y, count + 1);
                    if(dfsResult > max)
                        max = dfsResult;
                }

                int dfsResult = dfs(newX, newY, count + 1);
                if(dfsResult > max)
                    max = dfsResult;
            }
        }
        return max + map[x][y];
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
