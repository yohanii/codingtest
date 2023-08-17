import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class Main {
    static int V, E;
    static int[][] graph;
    static boolean[] visited;
    static int minDis;

    public void dfs(int index, int dis) {
//        System.out.println(index);
        visited[index] = true;

        //1~V를 모두 방문 시 이동 거리를 기록
        boolean isAllVisited = true;
        for(int i = 1; i < V+1; i++) {
            if(visited[i] == false)
                isAllVisited = false;
        }
        if(isAllVisited){
            if(minDis > dis)
                minDis = dis;
            return;
        }

        for(int i = 1; i < V+1; i++){
            if(!visited[i] && graph[index][i] != Integer.MAX_VALUE){
                dfs(i, dis + graph[index][i]);
            }
        }
        visited[index] = false;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V+1][V+1];
        for(int[] a: graph) Arrays.fill(a, Integer.MAX_VALUE);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start][end] = weight;
            graph[end][start] = weight;
        }

        minDis = Integer.MAX_VALUE;

        //출발지점을 모두 돌면서 min값 얻기.
        for(int i = 0; i < V+1; i++) {
            visited = new boolean[V + 1];
            dfs(1, 0);
        }

        System.out.println(minDis);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
