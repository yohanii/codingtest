import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_11725 {
    static int N;
    static int[] parent;
    static ArrayList<Integer>[] edge;

    public static void bfs() {
        int[] visited = new int[N+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int ele = queue.poll();
            visited[ele] = 1;

            for(int child : edge[ele]){
                if(visited[child] == 0){
                    parent[child] = ele;
                    queue.add(child);
                }
            }

        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[N+1];

        edge = new ArrayList[N+1];
        for(int i = 1; i< N+1; i++){
            edge[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[a].add(b);
            edge[b].add(a);
        }

        bfs();

        for(int i = 2; i < N+1; i++) {
            System.out.println(parent[i]);
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
