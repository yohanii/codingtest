import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Stream;



public class 백준_1260 {
    static ArrayList<Integer> dfsVisited = new ArrayList<>();
    static ArrayList<Integer> bfsVisited = new ArrayList<>();
    static ArrayList<Integer>[] graph;

    static void dfs(int v) {
        dfsVisited.add(v);
        System.out.print(v + " ");

        ArrayList<Integer> stack = graph[v];

        for (Integer target : stack) {
            if (!dfsVisited.contains(target)) {
                dfs(target);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(queue.size() != 0) {
            int target = queue.poll();

            if(!bfsVisited.contains(target)){
                bfsVisited.add(target);
                System.out.print(target + " ");

                for(int a : graph[target]){
                    queue.add(a);
                }
            }

        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        //graph sort
        for(ArrayList<Integer> a : graph) {
            Collections.sort(a);
        }

        dfs(V);
        System.out.println("");
        bfs(V);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
