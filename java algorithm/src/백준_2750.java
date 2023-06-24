import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2750 {

    public int[] bubble_sort(int[] arr) {
        int[] result = arr;

        for(int i = result.length; i>1; i--) {
            for(int j=0; j<i-1; j++) {
                if(result[j] > result[j+1]) {
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }

        return result;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] resultArr = bubble_sort(arr);

        for(int i = 0; i < n; i++) {
            System.out.println(resultArr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
