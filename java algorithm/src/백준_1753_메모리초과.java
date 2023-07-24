import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Stream;



public class 백준_1753_메모리초과 {

    static int[] dijkstra(int V, int start, int[][] weight) {
        int i;
        ArrayList<Integer> visited = new ArrayList<>();
        int[] dis = new int[V+1];
        for(i=0;i<V+1;i++){
            dis[i] = 1000000;
        }
        dis[start] = 0;

        int node;
        int min;
        while(visited.size() < V) {
            //distance에서 방문하지 않은 곳 중 가장 짧은 곳 선택
            node = -1;
            min = 1000001;

            for(i=1; i<V+1; i++) {
                if(dis[i] < min && !visited.contains(i)){
                    node = i;
                    min = dis[i];
                }
            }
            visited.add(node);

            //인접 노드 중 dis 업데이트
            //dis[i] vs dis[node] + weight[node][i]
            for(i=1; i<V+1; i++) {
                if(weight[node][i] != 0 && (dis[i] > dis[node] + weight[node][i] || (dis[i]==0 && i!=start)))
                    dis[i] = dis[node] + weight[node][i];
            }

//            System.out.println(node);
//            for(int i =1 ; i < V+1; i++){
//                System.out.print(dis[i] + " ");
//            }
//            System.out.println("");

        }

        return dis;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        int[][] weight = new int[V+1][V+1];

        //간선 가중치 넣어주기
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            weight[a][b] = w;
        }

//        //값 확인
//        for(int i=0; i<V+1; i++){
//            for(int j =0; j<V+1;j++){
//                System.out.println(i + " " + j + " " + weight[i][j]);
//            }
//        }

        int[] result = dijkstra(V, start, weight);

        for(int i=1; i<V+1; i++){
            if(result[i]==1000000) {
                System.out.println("INF");
            }else {
                System.out.println(result[i]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
