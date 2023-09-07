import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_7569 {
    class Tomato {
        int x;
        int y;
        int z;
        int time;

        public Tomato(int x, int y, int z, int time){
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }


    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] graph = new int[h][n][m];
        Queue<Tomato> queue = new LinkedList<>();

        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if(graph[i][j][k] == 1){
                        queue.add(new Tomato(i, j, k, 0));
                    }
                }
            }
        }

        //1위치를 queue에 다 넣는다.
        //queue 돌린다.
        //queue 비워지면, 0있는지 체크
        int lastTime = 0;
        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();
            int x = tomato.x;
            int y = tomato.y;
            int z = tomato.z;
            int time = tomato.time;
            lastTime = time;

            if(x > 0 && graph[x-1][y][z] == 0){
                graph[x-1][y][z] = 1;
                queue.add(new Tomato(x-1, y, z, time+1));
            }
            if(x < h-1 && graph[x+1][y][z] == 0){
                graph[x+1][y][z] = 1;
                queue.add(new Tomato(x+1, y, z, time+1));
            }
            if(y > 0 && graph[x][y-1][z] == 0){
                graph[x][y-1][z] = 1;
                queue.add(new Tomato(x, y-1, z, time+1));
            }
            if(y < n-1 && graph[x][y+1][z] == 0){
                graph[x][y+1][z] = 1;
                queue.add(new Tomato(x, y+1, z, time+1));
            }
            if(z > 0 && graph[x][y][z-1] == 0){
                graph[x][y][z-1] = 1;
                queue.add(new Tomato(x, y, z-1, time+1));
            }
            if(z < m-1 && graph[x][y][z+1] == 0){
                graph[x][y][z+1] = 1;
                queue.add(new Tomato(x, y, z+1, time+1));
            }
        }

        for(int[][] i : graph){
            for(int[] j : i){
                for(int k: j){
                    if(k==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(lastTime);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
