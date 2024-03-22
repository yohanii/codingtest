import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_14503 {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while(true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }

            int prevD = d;
            boolean findDirty = false;

            for (int i = 0; i < 4; i++) {
                d = d == 0 ? 3 : d-1;
                int newR = r + dx[d];
                int newC = c + dy[d];

                if (newR < 0 || newR >= n || newC < 0 || newC >= m) {
                    continue;
                }
                if (map[newR][newC] == 0) {
                    r = newR;
                    c = newC;
                    findDirty = true;
                    break;
                }
            }
            if (findDirty) {
                continue;
            }
            d = prevD;
            int newR = r - dx[d];
            int newC = c - dy[d];

            if (newR < 0 || newR >= n || newC < 0 || newC >= m || map[newR][newC] == 1) {
                System.out.println(count);
                break;
            }
            r = newR;
            c = newC;
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
