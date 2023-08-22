import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_1647 {
    static int[] parent;
    static ArrayList<Edge> graph;

    class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    public static int find(int index) {
        if(index == parent[index]) {
            return index;
        }

        return parent[index] = find(parent[index]);
    }

    public static void union(int start, int end) {
        int x = find(start);
        int y = find(end);

        if(x != y){
            parent[y] = x;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //다 연결할 수 있는 경로 찾고, 가장 긴 도로 제거 그 중 최소
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        parent = new int[N+1];
        IntStream.range(1, N+1).forEach(x -> parent[x] = x);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.add(new Edge(start, end, weight));
        }

        Collections.sort(graph);

        int bigCost = 0;
        int sumCost = 0;

        for(Edge edge : graph) {
            if(find(edge.start) != find(edge.end)){
                sumCost += edge.weight;
                union(edge.start, edge.end);

                bigCost = edge.weight;
            }
        }

//        System.out.println(sumCost + " " + bigCost);
        System.out.println(sumCost - bigCost);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
