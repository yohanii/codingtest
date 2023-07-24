import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Stream;



public class 백준_2178 {

    int[][] graph;

    static void bfs(int N, int M, int[][] graph) {
        //point : (x, y, depth)
        int[][] visited = new int[N][M];

        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        while(!queue.isEmpty()){
//            System.out.println(queue);
            ArrayList<Integer> temp = queue.poll();
            int x = temp.get(0);
            int y = temp.get(1);
            int depth = temp.get(2);

            if(x==N-1 && y==M-1){
                System.out.println(depth+1);
                break;
            }

            if(visited[x][y] != 1){
                visited[x][y] = 1;
                if(x < N-1){
                    if(visited[x+1][y] != 1 && graph[x+1][y] == 1)
                        queue.add(new ArrayList<>(Arrays.asList(x+1, y, depth+1)));
                }

                if(x > 0){
                    if(visited[x-1][y] != 1 && graph[x-1][y] == 1)
                        queue.add(new ArrayList<>(Arrays.asList(x-1, y, depth+1)));
                }

                if(y < M-1){
                    if(visited[x][y+1] != 1 && graph[x][y+1] == 1)
                        queue.add(new ArrayList<>(Arrays.asList(x, y+1, depth+1)));
                }

                if(y > 0){
                    if(visited[x][y-1] != 1 && graph[x][y-1] == 1)
                        queue.add(new ArrayList<>(Arrays.asList(x, y-1, depth+1)));
                }
            }

        }



    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j=0; j < str.length(); j++) {
                graph[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        bfs(N, M, graph);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
