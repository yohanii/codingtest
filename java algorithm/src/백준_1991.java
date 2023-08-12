import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_1991 {

    static int n;
    static int[][] arr;
    static int[] visited;

    public static void dfs1(int index) {
        visited[index] = 1;
        System.out.print((char)(index+65));

        for(int i = 0; i < 2; i++){
            int eleIndex = arr[index][i+1];
//            System.out.println(eleIndex);
            if(eleIndex != -1 && visited[eleIndex] != 1){
                dfs1(eleIndex);
            }
        }
    }

    public static void dfs2(int index){
        int eleIndex = arr[index][1];
        if(eleIndex != -1 && visited[eleIndex] != 1){
            dfs2(eleIndex);
        }

        visited[index] = 1;
        System.out.print((char)(index+65));

        eleIndex = arr[index][2];
        if(eleIndex != -1 && visited[eleIndex] != 1){
            dfs2(eleIndex);
        }
    }

    public static void dfs3(int index){
        for(int i = 0; i < 2; i++){
            int eleIndex = arr[index][i+1];
            if(eleIndex != -1 && visited[eleIndex] != 1){
                dfs3(eleIndex);
            }
        }

        visited[index] = 1;
        System.out.print((char)(index+65));
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //'A' - 65, '.' - 46

        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];

        for(int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = (int)st.nextToken().charAt(0);

            int left = (int)st.nextToken().charAt(0);
            int right = (int)st.nextToken().charAt(0);

            if(left != 46) {
                arr[parent - 65][1] = left - 65;
                arr[left-65][0] = parent - 65;
            }
            if(right != 46) {
                arr[parent - 65][2] = right - 65;
                arr[right - 65][0] = parent - 65;
            }
        }

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < 3; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println("");
//        }

        visited = new int[n];
        dfs1(0);
        System.out.println("");

        visited = new int[n];
        dfs2(0);
        System.out.println("");

        visited = new int[n];
        dfs3(0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
