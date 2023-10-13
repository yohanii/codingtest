import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_1967 {

    static int n;
    //    static int[][] map;
//    static ArrayList<Integer>[] line;
    static List<Node>[] map;
    static int max;
    static boolean[] visited;

    static class Node {
        int num, len;

        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
//        map = new int[n+1][n+1];
//        line = new ArrayList[n+1];
//        for(int i = 0; i < n+1; i++)
//            line[i] = new ArrayList<>();
        map = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++)
            map[i] = new ArrayList<>();

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

//            map[start][end] = weight;
//            map[end][start] = weight;
//            line[start].add(end);
//            line[end].add(start);
            map[start].add(new Node(end, weight));
            map[end].add(new Node(start, weight));
        }

        max = 0;
        for(int index = 1; index <= n; index++) {
            visited = new boolean[n + 1];
            visited[index] = true;
            dfs(index, 0);
        }
        System.out.println(max);

    }

    private static void dfs(int index, int sum) {
        if(sum > max)
            max = sum;

        for(Node node: map[index]) {
            if(!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, sum + node.len);
            }
        }

//        for(int i = 1; i <= n; i++) {
//            if(map[index][i] != 0 && visited[i] == 0) {
//                visited[i] = 1;
//                dfs(i, sum + map[index][i]);
//            }
//        }

//        for(int target: line[index]) {
//            if(visited[target] == 0) {
//                dfs(target, sum + map[index][target]);
//            }
//        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
