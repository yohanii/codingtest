import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_1676 {
    public static int check(int n) {
        if(n==0)
            return 0;

        if(n%5 == 0)
            return 1 + check(n/5);
        else
            return 0;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int result = 0;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n+1; i++){
            result += check(i);
        }
        System.out.println(result);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
