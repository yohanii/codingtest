import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class 백준_14940 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] graph;
        //1. graph 받기
        //2. queue에 2인 지점 넣고, visited 체크하면서 queue에 넣기
        //3. queue에서 꺼내고 visited체크하고, 동서남북 queue에 넣기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        int startX = 0;
        int startY = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

//        System.out.println(startX + " " + startY);

        int[][] answer = new int[n][m];
        for(int[] i: answer){
            Arrays.fill(i, -1);
        }

        int[][] isVisited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        answer[startX][startY] = 0;

        while(!queue.isEmpty()){
            int[] elem = queue.poll();
            int x = elem[0];
            int y = elem[1];
            isVisited[x][y] = 1;

            if(graph[x][y] == 0){
                answer[x][y] = 0;
                continue;
            }

            if(x > 0 && isVisited[x-1][y] == 0){
                queue.add(new int[]{x-1, y});
                isVisited[x-1][y] = 1;
                answer[x-1][y] = answer[x][y] + 1;
            }

            if(x < n-1 && isVisited[x+1][y] == 0){
                queue.add(new int[]{x+1, y});
                isVisited[x+1][y] = 1;
                answer[x+1][y] = answer[x][y] + 1;
            }

            if(y > 0 && isVisited[x][y-1] == 0){
                queue.add(new int[]{x, y-1});
                isVisited[x][y-1] = 1;
                answer[x][y-1] = answer[x][y] + 1;
            }

            if(y < m-1 && isVisited[x][y+1] == 0){
                queue.add(new int[]{x, y+1});
                isVisited[x][y+1] = 1;
                answer[x][y+1] = answer[x][y] + 1;
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 0)
                    answer[i][j] = 0;
            }
        }

        for(int[] i : answer){
            for(int j: i){
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
