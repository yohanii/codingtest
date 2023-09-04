import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class 백준_11726 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //f(n) = f(n-1) + f(n-2)
        //f(1) = 1, f(2) = 2, f(3) = 3
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        arr[1] = 1;
        if(n > 1)
            arr[2] = 2;

        if(n > 2){
            for(int i = 3; i < n+1; i++){
                arr[i] = (arr[i-1] + arr[i-2])%10007;
            }
        }

        System.out.println(arr[n]);

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
