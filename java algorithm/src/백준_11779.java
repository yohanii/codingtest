import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_11779 {

    static int n, m;
    static List<Edge>[] map;

    static int[] distance;
    static int start, end;

    static int[] history;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start].add(new Edge(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        distance[start] = 0;

        history = new int[n + 1];
        dijkstra(start);
        System.out.println(distance[end]);

        List<Integer> historyList = new ArrayList<>();
        int cur = end;
        historyList.add(end);
        while (true) {
            historyList.add(0, history[cur]);
            cur = history[cur];

            if (cur == start) {
                break;
            }
        }

        System.out.println(historyList.size());
        for (int i : historyList) {
            System.out.print(i + " ");
        }

//        for (int i : distance) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
    }

    public void dijkstra(int start) {

        int[] visited = new int[n + 1];
        int current = start;

        while (true) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            visited[current] = 1;

            //distance update
            for (Edge edge : map[current]) {
                if (visited[edge.node] == 0 && distance[edge.node] > distance[current] + edge.cost) {
                    history[edge.node] = current;
                    distance[edge.node] = distance[current] + edge.cost;
                }
            }

            //current update
            for (int i = 1; i < n + 1; i++) {
                if (visited[i] == 0 && distance[i] < minValue) {
                    minValue = distance[i];
                    minIndex = i;
                }
            }

//            System.out.println("current = " + current);
            current = minIndex;

            if (minIndex == -1) {
                break;
            }
        }
    }

    class Edge {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
