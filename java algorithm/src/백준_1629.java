import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Stream;



public class 백준_1629 {

    static long pow(int a, int b, int mod) {
        if (b == 0)
            return 1;

        long n = pow(a, b / 2, mod);
        if (b % 2 == 0)
            return n * n % mod;
        else
            return (n * n % mod) * a % mod;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
