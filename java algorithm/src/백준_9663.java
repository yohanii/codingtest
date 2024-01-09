import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_9663 {

    static int n;
    static int count;
    static int[][] map;
    static int[][] status;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        count = 0;

        for (int i = 0; i < n; i++) {
            map = new int[n][n];
            status = new int[n][n];
            dfs(0, i);
        }

//        System.out.println("count = " + count);
        System.out.println(count);
    }

    private void dfs(int r, int c) {
//        System.out.println("r , c = " + r + ", " + c);
        //r == n 시 count++
        if (r == n) {
//            System.out.println("count++");
            count++;
            return;
        }

        //map update
        for (int i = 0; i < n; i++) {

            if (map[r][i] == 0) {
                map[r][i] = 1;
                status[r][i] = r;
            }

            if (map[i][c] == 0) {
                map[i][c] = 1;
                status[i][c] = r;
            }

            int newY1 = c - r + i;
            if (newY1 >= 0 && newY1 < n && map[i][newY1] == 0) {
                map[i][newY1] = 1;
                status[i][newY1] = r;
            }

            int newY2 = c + r - i;
            if (newY2 >= 0 && newY2 < n && map[i][newY2] == 0) {
                map[i][newY2] = 1;
                status[i][newY2] = r;
            }
        }

//        for (int[] ints : map) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println("");
//        }

        if (r + 1 == n) {
            dfs(r + 1, 0);
        }

        //dfs(r+1, index) for문 돌리기
        for (int i = 0; i < n; i++) {
            if (r+1 != n && map[r+1][i] == 0) {
                dfs(r+1, i);
            }
        }

        //map 되돌리기
//        updatePos.forEach(pos -> map[pos.x][pos.y] = 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (status[i][j] == r) {
                    status[i][j] = 0;
                    map[i][j] = 0;
                }
            }
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
