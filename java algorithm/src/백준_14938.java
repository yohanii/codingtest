import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_14938 {
    static int n, m, r;
    static int[] items;
    static int[][] graph;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new int[n][n];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a-1][b-1] = w;
            graph[b-1][a-1] = w;
        }

        int maxItemSum = Integer.MIN_VALUE;
        //각 지역마다
        for (int start = 0; start < n; start++) {
            // dijkstra 하기
            int[] distance = dijkstra(start);
            // 수색범위 이하의 구역의 아이템 개수 세기
            int itemSum = getItemSum(distance);
//            System.out.println("i = " + start + " itemSum = " + itemSum);
            if (itemSum > maxItemSum) {
                maxItemSum = itemSum;
            }
        }
        // 그 중 max 값 구하기
        System.out.println(maxItemSum);
    }

    private int getItemSum(int[] distance) {
        int itemSum = 0;
        for (int i = 0; i < n; i++) {
            if (distance[i] <= m) {
                itemSum += items[i];
            }
        }
        return itemSum;
    }

    private int[] dijkstra(int start) {
        int[] distance = new int[n];
        Arrays.fill(distance, 1000000);
        distance[start] = 0;
        for (int i = 0; i < n; i++) {
            if (graph[start][i] > 0) {
                distance[i] = graph[start][i];
            }
        }

        List<Integer> visited = new ArrayList<>();
        int current = start;
        while (visited.size() < n) {
            visited.add(current);

            //distance update
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && graph[current][i] > 0 && distance[i] > distance[current] + graph[current][i]) {
                    distance[i] = distance[current] + graph[current][i];
                }
            }

            //next node
            int minDistance = 1000000;
            int nextIndex = -1;
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && distance[i] <= minDistance) {
                    minDistance = distance[i];
                    nextIndex = i;
                }
            }
            current = nextIndex;
        }

        return distance;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
