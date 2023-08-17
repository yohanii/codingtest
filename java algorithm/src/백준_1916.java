import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_1916 {
    static int N, M;
    static ArrayList<ArrayList<Node>> graph;

    class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public int dijkstra(int start, int end) {
        int[] dist = new int[N+1];
        boolean[] check = new boolean[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            //dist 업데이트
            Node ele = pq.poll();

            if(!check[ele.end]) {
                check[ele.end] = true;
                for(Node node : graph.get(ele.end)) {
                    if(!check[node.end] && dist[node.end] > dist[ele.end] + node.weight) {
                        dist[node.end] = dist[ele.end] + node.weight;
                        //pq에 다음 노드 추가
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));


    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
