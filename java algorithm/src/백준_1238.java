import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_1238 {

    static int n, m, x;
    static int[][] map, result;

    public static int dijkstra(int start) {
        int index = start;
        int[] visited = new int[n+1];

        while(index != -1) {
//            System.out.println(index);
            visited[index] = 1;
            //업데이트
            for (int i = 1; i < n + 1; i++) {
                if (map[index][i] == 0)
                    continue;

                int len = map[index][i] + result[start][index];
                if (visited[i] == 0 && len < result[start][i]) {
                    result[start][i] = len;
                }
            }

            //갈 수 있는 길 중 result 값 가장 작은 것 골라서 index에 넣기
            int minIndex = index;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                if (visited[i] == 0 && result[start][i] < min) {
                    minIndex = i;
                    min = result[start][i];
                }
            }
            if (minIndex == index)
                index = -1;
            else
                index = minIndex;
        }

        return 0;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        result = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start][end] = cost;
        }

        int maxCost = Integer.MIN_VALUE;
        for(int i = 0; i < n+1; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
            for(int j = 0; j < n+1; j++){
                if(map[i][j] != 0)
                    result[i][j] = map[i][j];
            }
            result[i][i] = 0;
        }

        for(int i = 1; i < n+1; i++) {
            dijkstra(i);
        }

        for(int i = 1; i < n+1; i++) {
            int sum = result[i][x] + result[x][i];
            if(sum > maxCost)
                maxCost = sum;
        }
//        dijkstra(x);


//        //map
//        for(int i = 1; i < n+1; i++){
//            for(int j = 1; j < n+1; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//
//        //result
//        for(int i = 1; i < n+1; i++){
//            for(int j = 1; j < n+1; j++) {
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.println("");
//        }

        System.out.println(maxCost);

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
