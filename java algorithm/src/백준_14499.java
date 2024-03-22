import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_14499 {
    static int[][] map;
    static int n, m, x, y;
    static int[] dice;
    static int[] dx = new int[]{0, 0, 0, -1, 1};
    static int[] dy = new int[]{0, 1, -1, 0, 0};
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        dice = new int[6];
        while (t-- > 0) {
            int direction = Integer.parseInt(st.nextToken());
//            System.out.println("direction: " + direction);

            int num = roll(direction);
            if (num != -1) {
                System.out.println(num);
            }
        }
    }

    private int roll(int d) {

        int newX = x + dx[d];
        int newY = y + dy[d];

        if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
            return -1;
        }

        changeDice(d);

        if (map[newX][newY] == 0) {
            map[newX][newY] = dice[2];
        } else {
            dice[2] = map[newX][newY];
            map[newX][newY] = 0;
        }

        x = newX;
        y = newY;

        return dice[0];
    }

    private static void changeDice(int d) {
        switch (d) {
            case 1:
                int temp1 = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[2];
                dice[2] = dice[4];
                dice[4] = temp1;
                break;
            case 2:
                int temp2 = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[2];
                dice[2] = dice[5];
                dice[5] = temp2;
                break;
            case 3:
                int temp3 = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = temp3;
                break;
            case 4:
                int temp4 = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[2];
                dice[2] = dice[1];
                dice[1] = temp4;
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
