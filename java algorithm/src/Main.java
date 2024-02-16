import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] visited;
    static String[][] map;
    static int count;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //한 곳에 박히거나
        //사이클 돌거나
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        int stack = 1;
        count = 0;
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                find(i, j, stack);
                stack++;
            }
        }
        System.out.println(count);

    }

    public void find(int x, int y, int stack) {
//        System.out.println("cur x, y = " + x + ", " + y);

        if (visited[x][y] != 0) {
            if (visited[x][y] == stack) {
//                System.out.println("case1 x, y = " + x + ", " + y);
                count++;
            }
            return;
        }
        visited[x][y] = stack;

        int newX = -1;
        int newY = -1;

        switch (map[x][y]) {
            case "U":
                newX = x - 1;
                newY = y;
                break;
            case "D":
                newX = x + 1;
                newY = y;
                break;
            case "L":
                newX = x;
                newY = y - 1;
                break;
            case "R":
                newX = x;
                newY = y + 1;
                break;
        }
//        if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
////            System.out.println("case2 x, y = " + x + ", " + y);
//            count++;
//            return;
//        }
        find(newX, newY, stack);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
