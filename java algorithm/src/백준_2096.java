import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2096 {
    static int n;
    static int maxValue, minValue;
    static int[][] graph;
    static int[] dxArr = new int[]{-1, 0, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculate();
    }

    public void calculate() {
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        int[] prevMaxDp;
        int[] prevMinDp;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) {
                    maxDp[j] = graph[i][j];
                    minDp[j] = graph[i][j];
                }
                continue;
            }

            prevMaxDp = Arrays.copyOf(maxDp, 3);
            prevMinDp = Arrays.copyOf(minDp, 3);

            maxDp[0] = Math.max(prevMaxDp[0], prevMaxDp[1]) + graph[i][0];
            maxDp[1] = Math.max(Math.max(prevMaxDp[0], prevMaxDp[1]), prevMaxDp[2]) + graph[i][1];
            maxDp[2] = Math.max(prevMaxDp[1], prevMaxDp[2]) + graph[i][2];

            minDp[0] = Math.min(prevMinDp[0], prevMinDp[1]) + graph[i][0];
            minDp[1] = Math.min(Math.min(prevMinDp[0], prevMinDp[1]), prevMinDp[2]) + graph[i][1];
            minDp[2] = Math.min(prevMinDp[1], prevMinDp[2]) + graph[i][2];
        }

        System.out.println(Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2])) + " " + Math.min(minDp[0], Math.min(minDp[1], minDp[2])));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
