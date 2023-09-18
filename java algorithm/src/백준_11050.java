import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_11050 {

    public static int fac(int n) {
        if(n == 1 || n == 0)
            return 1;

        return n * fac(n-1);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //n! / (k!)((n-k)!)
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(fac(n) / (fac(k) * fac(n-k)));

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
