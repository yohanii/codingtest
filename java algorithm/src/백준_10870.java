import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;



public class 백준_10870 {
    private int fibonachi(int n) {
        if(n==1){
            return 1;
        } else if (n==0) {
            return 0;
        }

        return fibonachi(n-1) + fibonachi(n-2);
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonachi(n));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
