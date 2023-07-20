import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2738 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
        int n = arr[0];
        int m = arr[1];

        int[][] saveArrA = new int[n][m];
        int[][] saveArrB = new int[n][m];
        int[][] resultArr = new int[n][m];


        for(int i = 0; i < n; i++) {
            int[] tempArr = Arrays.stream(br.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
            for(int j = 0; j < m; j++) {
                saveArrA[i][j] = tempArr[j];
            }
        }

        for(int i = 0; i < n; i++) {
            int[] tempArr = Arrays.stream(br.readLine().split(" ")).mapToInt(num -> Integer.parseInt(num)).toArray();
            for(int j = 0; j < m; j++) {
                saveArrB[i][j] = tempArr[j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print((saveArrA[i][j] + saveArrB[i][j]) + " ");
            }
            System.out.println("");
        }


    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
