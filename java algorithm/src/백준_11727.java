import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_11727 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //f(n) = f(n-1) + f(n-2)
        //f(1) = 1, f(2) = 2
        int n = Integer.parseInt(br.readLine());

        if(n == 1){
            System.out.println(1);
            return;
        } else  if(n == 2){
            System.out.println(3);
            return;
        }

        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 3;

        for(int i = 3; i < n+1; i++) {
            arr[i] = (arr[i-1] + 2 * arr[i-2]) % 10007;
        }
        System.out.println(arr[n]);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
