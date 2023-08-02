import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class 백준_15650 {
    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int index, int depth) {
        if(depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = index; i <= N; i++) {
            arr[depth] = i;

            dfs(i + 1, depth + 1);
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
