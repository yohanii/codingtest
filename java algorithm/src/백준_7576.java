import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class 백준_7576 {
    static int[][] map;
    static int N, M;
    static Queue<int[]> queue = new LinkedList<>();

    private static boolean checkZero() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    return true;
                }
            }
        }

        return false;
    }

    private static int bfs() {
        int[] elem;
        int r, c;

        while(!queue.isEmpty()) {
            elem = queue.poll();
            r = elem[0];
            c = elem[1];

            if(r > 0 && map[r-1][c] == 0) {
                queue.add(new int[]{r-1, c});
                map[r-1][c] = map[r][c] + 1;
            }
            if (r < N-1 && map[r+1][c] == 0) {
                queue.add(new int[]{r+1, c});
                map[r+1][c] = map[r][c] + 1;
            }
            if (c > 0 && map[r][c-1] == 0) {
                queue.add(new int[]{r, c-1});
                map[r][c-1] = map[r][c] + 1;
            }
            if (c < M-1 && map[r][c+1] == 0) {
                queue.add(new int[]{r, c+1});
                map[r][c+1] = map[r][c] + 1;
            }

        }

        int max = Integer.MIN_VALUE;
        if (checkZero()) {
            return -1;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }

            return max - 1;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) queue.add(new int[]{i, j, 0});
            }
        }

        System.out.println(bfs());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
