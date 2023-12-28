import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1504 {
    public static final int MAX_VALUE = 1000000000;
    static int n, e, v1, v2;
    static int[][] graph;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
            graph[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());


        int[] dijkstra1 = dijkstra(1);
        int[] dijkstraV1 = dijkstra(v1);
        int[] dijkstraV2 = dijkstra(v2);

//        for (int i : dijkstra1) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//
//        for (int i : dijkstraV1) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
//
//        for (int i : dijkstraV2) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
        if (List.of(dijkstra1[v1], dijkstraV1[v2], dijkstraV2[n]).contains(MAX_VALUE) && List.of(dijkstra1[v2], dijkstraV2[v1], dijkstraV1[n]).contains(MAX_VALUE)) {
            System.out.println(-1);
            return;
        }
        int result = Math.min(dijkstra1[v1] + dijkstraV1[v2] + dijkstraV2[n], dijkstra1[v2] + dijkstraV2[v1] + dijkstraV1[n]);
        System.out.println(result);
    }

    private int[] dijkstra(int start) {
//        int[] distance = Arrays.copyOf(graph[start], n + 1);
        int[] distance = new int[n + 1];
        Arrays.fill(distance, MAX_VALUE);
        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] > 0) {
                distance[i] = graph[start][i];
            }
        }
        distance[start] = 0;
        List<Integer> visited = new ArrayList<>();

        int current = start;
        while (visited.size() < n) {
//            System.out.println("current = " + current);
            visited.add(current);
            //distance 업데이트
            for (int index = 1; index < n + 1; index++) {
                if (!visited.contains(index) && graph[current][index] > 0 && distance[index] > distance[current] + graph[current][index]) {
                    distance[index] = distance[current] + graph[current][index];
                }
            }

            //visit 하지 않은 애들 중에서 가장 거리 짧은 애 고르고 넘겨주기
            int minValue = Integer.MAX_VALUE;
            for (int index = 1; index < n + 1; index++) {
                if (!visited.contains(index) && distance[index] < minValue) {
                    minValue = distance[index];
                    current = index;
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
