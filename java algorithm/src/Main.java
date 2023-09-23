import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    static int n, m;
    static ArrayList[] graph;
    static int[][] result;

    public static void dijkstra(int start) {
        int[] visited = new int[n+1];

        int prev = start;
        int index = start;
        while(index != -1) {
            //거리 업데이트
            for(Object e: graph[index]) {
                int[] elem = (int[]) e;

                System.out.println(elem[0] + " " + elem[1]);
            }

            //다음 index
            break;
        }

    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<int[]>();
        }

        result = new int[n+1][n+1];
        for(int i = 1; i < n+1; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
            result[i][i] = 0;
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            //나중에 더 작은 값 들어올때만 바꿔주기
            graph[start].add(new int[]{end, cost});
            result[start][end] = cost;
        }

        //print map
        for(int i = 1; i < result.length; i++){
            for(int j = 1; j < result.length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }

        dijkstra(1);

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
