import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_1865 {

    static int tc, n, m, w;
    static int[][] distance;
    static List<Edge> graph;
    static Set<Integer> warm;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 1; i < n + 1; i++) {
                graph = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                graph.add(new Edge(start, end, time));
                graph.add(new Edge(end, start, time));
            }

            boolean isAllWarmTimeZero = true;
            warm = new HashSet<>();
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                if (time != 0) {
                    isAllWarmTimeZero = false;
                }
                warm.add(start);
                graph.add(new Edge(start, end, -time));
            }
            if (isAllWarmTimeZero) {
                System.out.println("NO");
                continue;
            }

            //벨만 포드 알고리즘
            //모든 노드에 대해 start로 삼아서 돌리기
            distance = new int[n + 1][n + 1];
            for (int i = 1; i < n + 1; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
                distance[i][i] = 0;
            }

            if (checkAble()) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");


//            System.out.println("distance");
//            for (int[] ints : distance) {
//                for (int anInt : ints) {
//                    System.out.print(anInt + " ");
//                }
//                System.out.println("");
//            }
        }

    }

    private boolean checkAble() {
//        for (int i = 1; i < n + 1; i++) {
//            if (bell(i)) {
//                return true;
//            }
//        }
        for (Integer i : warm) {
            if (bell(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean bell(int start) {

        for (int i = 1; i < n + 1; i++) {
            for (Edge edge : graph) {
                int cur = edge.start;
                int next = edge.end;
                int cost = edge.time;

                if (distance[start][cur] != Integer.MAX_VALUE && distance[start][next] > distance[start][cur] + cost) {
                    distance[start][next] = distance[start][cur] + cost;
                    if (i == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }

        @Override
        public String toString() {
            return "start : " + start + " [" + end + ", " + time + "]";
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
