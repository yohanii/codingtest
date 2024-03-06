import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_1197 {

    static int v, e;
    static int[] parent;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //find, union 만들기
        //V-1번 반복하면서 가중치 오름차순된 Edge 선택
        //find 값 다르면 union 하기
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

//        System.out.println(edges);
//
//        System.out.print("parent : ");
//        for (int i : parent) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        int select = 0;
        int totalWeight = 0;
        while (select < v - 1) {
            Edge edge = edges.poll();
            if (union(edge.start, edge.end)) {
                select++;
                totalWeight += edge.weight;
            }
        }

//        System.out.print("parent : ");
//        for (int i : parent) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        System.out.println(totalWeight);
    }

    class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }

    public int find(int index) {
        if (parent[index] == index) {
            return index;
        }

        return parent[index] = find(parent[index]);
    }

    public boolean union(int start, int end) {
        int p1 = find(start);
        int p2 = find(end);

        if (p1 == p2) {
            return false;
        }

        parent[p2] = p1;
        find(end);
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
