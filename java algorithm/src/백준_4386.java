import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class 백준_4386 {

    static int n;
    static List<Edge> edges;
    static List<Node> nodes;
    static int[] parent;
    static double totalDistance;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double inputX = Double.parseDouble(st.nextToken());
            double inputY = Double.parseDouble(st.nextToken());
            nodes.add(new Node(i, inputX, inputY));
            parent[i] = i;
        }

        edges = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                edges.add(new Edge(nodes.get(i), nodes.get(j)));
            }
        }
        Collections.sort(edges);
//        System.out.println(edges);

        totalDistance = 0;
        for (Edge edge : edges) {
            union(edge);
        }
        totalDistance = Math.round(totalDistance * 100) / 100.0;
        System.out.println(totalDistance);



    }

    class Edge implements Comparable<Edge>{
        Node start;
        Node end;
        double weight;

        public Edge(Node start, Node end) {
            this.start = start;
            this.end = end;
            this.weight = end.getDistance(start);
        }

        @Override
        public int compareTo(Edge edge) {
            if (weight - edge.weight < 0) {
                return -1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return "[" + start.index + "," + end.index + "," + weight + "]";
        }
    }

    class Node {
        int index;
        double x;
        double y;

        public Node(int index, double x, double y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        public double getDistance(Node node) {
            return Math.sqrt(Math.pow(node.x - x, 2) + Math.pow(node.y - y, 2));
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }

    public int find(int index) {
        if (parent[index] == index) {
            return index;
        }

        return parent[index] = find(parent[index]);
    }

    public void union(Edge edge) {
//        System.out.println("edge = " + edge);
        int start = edge.start.index;
        int end = edge.end.index;
//        System.out.println("find(start) = " + find(start));
//        System.out.println("find(end) = " + find(end));
        if (find(start) == find(end)) {
            return;
        }

        parent[find(end)] = find(start);
        totalDistance += edge.weight;
//        for (int i : parent) {
//            System.out.print("parent: ");
//            System.out.print(i + " ");
//        }
//        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
