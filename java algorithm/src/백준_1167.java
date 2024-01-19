import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_1167 {
    static int v;
    static List<Edge>[] map;
    static int maxCost;
    static int maxIndex;
    static int[] visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //root 찾기 연결 노드 2개 이하면 아무거나
        //root부터 모든 점 거리 구하기
        //가장 먼 두 거리 합
        v = Integer.parseInt(br.readLine());
        map = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i < v + 1; i++) {
            String[] split = br.readLine().split(" ");
            int index = Integer.parseInt(split[0]);
            int length = (split.length - 2) / 2;

            for (int j = 0; j < length; j++) {
                map[index].add(new Edge(Integer.parseInt(split[2 * j + 1]), Integer.parseInt(split[2 * j + 2])));
            }
        }

        //dfs로 제일 먼 노드 찾기
        maxCost = Integer.MIN_VALUE;
        maxIndex = -1;
        dfs(1, 0, -1);

        maxCost = Integer.MIN_VALUE;
        dfs(maxIndex, 0, -1);
        System.out.println(maxCost);
    }

    private void dfs(int node, int sum, int prev) {
        if (prev != -1 && map[node].size() == 1) {
//            System.out.println("node = " + node + ", sum = " + sum);
            if (maxCost < sum) {
                maxCost = sum;
                maxIndex = node;
            }
            return;
        }

        for (Edge edge : map[node]) {
            if (edge.node != prev) {
                dfs(edge.node, sum + edge.cost, node);
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

        @Override
        public String toString() {
            return "[" + node + ", " + cost + "]";
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
