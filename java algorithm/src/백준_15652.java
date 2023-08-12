import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_15652 {
    static int N, M;
    static StringBuilder sb;
    static int[] arr;

    public static void dfs(int index, int depth) {
        if(depth == M+1){
            sb = new StringBuilder();
            IntStream.range(1, M+1).forEach(x -> {
                sb.append(arr[x]).append(" ");
            });
            System.out.println(sb);
            return;
        }


        IntStream.range(index, N+1).forEach(x -> {
            arr[depth] = x;
            dfs(x, depth+1);
        });

    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M+1];
        dfs(1, 1);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
