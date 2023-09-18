import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_11403 {

    static int n;
    static int[][] map;
    static int[] visited;
    static int[][] result;

    public void dfs(int start, int x){
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0 && map[x][i] == 1){
                visited[i] = 1;
                result[start][i] = 1;
                result[x][i] = 1;
                dfs(start, i);
            }
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            visited = new int[n];
            dfs(i, i);
        }

        for(int[] i: result){
            for(int j: i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
