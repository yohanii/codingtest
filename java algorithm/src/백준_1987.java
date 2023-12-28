import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1987 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int r, c;
    static String[][] graph;
    static int maxValue;
    static String[] history;
    static int totalCount;
    static int[] visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new String[r][c];
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            String[] split = br.readLine().split("");
            graph[i] = Arrays.copyOf(split, split.length);
            for (int j = 0; j < c; j++) {
                if (!strings.contains(graph[i][j])) {
                    strings.add(graph[i][j]);
                }
            }
        }
        totalCount = strings.size();

        visited = new int[100];
        maxValue = 0;
        history = new String[r * c + 1];
        dfs(0, 0, 1);

        System.out.println(maxValue);
    }

    private void dfs(int x, int y, int moveCount) {
//        System.out.println(x + " " + y + " moveCount: " + moveCount);
        if (maxValue == totalCount) {
            return;
        }

        if (maxValue < moveCount) {
            maxValue = moveCount;
        }
        int charAt = graph[x][y].charAt(0);
        visited[charAt] = 1;
//        history[moveCount - 1] = graph[x][y];
//        List<String> historyList = new ArrayList<>();
//        for (int i = 0; i < moveCount; i++) {
//            historyList.add(history[i]);
//        }
//                Arrays.stream(history).limit(moveCount).toList();
//        System.out.println("historyList = " + historyList);
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

//            if (newX >= 0 && newX < r && newY >= 0 && newY < c && !historyList.contains(graph[newX][newY])) {
            if (newX >= 0 && newX < r && newY >= 0 && newY < c) {
                int charAt1 = graph[newX][newY].charAt(0);
                if (visited[charAt1] == 0) {
                    if (moveCount + 1 == totalCount) {
                        maxValue = totalCount;
                        return;
                    }
                    dfs(newX, newY, moveCount + 1);
                    visited[charAt1] = 0;
                }
            }
        }
    }



    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
