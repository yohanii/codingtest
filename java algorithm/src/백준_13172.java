import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_13172 {

    private static final long X = 1000000007L;
    //    private static final long X = 11L;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long sum = 0;
        int m = Integer.parseInt(br.readLine());
        long N = 1;
        long S = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            S = (S * n + s * N) % X;
            N = N * n % X;
        }

        System.out.println(getMod(S, N) % X);
    }

    private long getMod(long s, long n) {
        long reverseB = getPow(n, X - 2);

        return s * reverseB % X;
    }

    private long getPow(long n, long l) {

        if (l == 1) {
            return n;
        }

        long pow = getPow(n, l / 2);
        if (l % 2 == 1) {
            return n * (pow * pow % X) % X;
        }
        return pow * pow % X;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
