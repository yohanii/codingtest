import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class Main {
    static int N, M;
    static int[][] graph;

    public static void dijkstra(int start, int end) {
        //start부터의 거리
        int[] dis = new int[N+1];
        int[] visited = new int[N+1];
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int currentIndex;

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        for(int i = 0; i < N; i++){
            if(graph[start][i+1] != 0){
                dis[i+1] = graph[start][i+1];
            }
        }
        visited[0] = 1;
        visited[start] = 1;

        for(int i = 1; i < N+1; i++){
            if(dis[i] < min && i != start){
                min = dis[i];
                minIndex = i;
            }
        }
        currentIndex = minIndex;

        while(true){
            //거리 업데이트
            visited[currentIndex] = 1;
            for(int i = 1; i < N+1; i++) {
                if(graph[currentIndex][i] != 0 && dis[i] > dis[currentIndex] + graph[currentIndex][i]){
                    dis[i] = dis[currentIndex] + graph[currentIndex][i];
                }
            }

            //visited 체크하고 모두 방문했을 시 break
            Boolean allVisited = true;
            for(int ele: visited){
                if(ele == 0) allVisited = false;
            }
            if(allVisited) break;

            //비용 작은 곳 방문
            min = Integer.MAX_VALUE;
            for(int i = 1; i < N+1; i++){
                if(dis[i] < min && i != currentIndex && visited[i] == 0){
                    min = dis[i];
                    minIndex = i;
                }
            }
            currentIndex = minIndex;
        }
        for(int ele: dis) System.out.println(ele);
        System.out.println(dis[end]);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
