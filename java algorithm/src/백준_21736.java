import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_21736 {

    static char[][] map;
    static int n, m;
    static int result = 0;
    static int[][] visited;

    public void dfs(int x, int y) {
        visited[x][y] = 1;

        if(x > 0 && visited[x-1][y] == 0){
            if(map[x-1][y] == 'P'){
//                System.out.println(x + " " + y);
                dfs(x-1, y);
                result++;
            }else if(map[x-1][y] == 'O'){
                dfs(x-1, y);
            }
        }

        if(x < n-1 && visited[x+1][y] == 0){
            if(map[x+1][y] == 'P'){
//                System.out.println(x + " " + y);
                dfs(x+1, y);
                result++;
            }else if(map[x+1][y] == 'O'){
                dfs(x+1, y);
            }
        }

        if(y > 0 && visited[x][y-1] == 0){
            if(map[x][y-1] == 'P'){
//                System.out.println(x + " " + y);
                dfs(x, y-1);
                result++;
            }else if(map[x][y-1] == 'O'){
                dfs(x, y-1);
            }
        }

        if(y < m-1 && visited[x][y+1] == 0){
            if(map[x][y+1] == 'P'){
//                System.out.println(x + " " + y);
                dfs(x, y+1);
                result++;
            }else if(map[x][y+1] == 'O'){
                dfs(x, y+1);
            }
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //dfs
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new int[n][m];

        int startX = 0;
        int startY = 0;

        for(int i = 0; i < n; i++) {
            String inputStr = br.readLine();

            for(int j = 0; j < m; j++) {
                map[i][j] = inputStr.charAt(j);
                if(map[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);

        if(result == 0){
            System.out.println("TT");
            return;
        }
        System.out.println(result);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
