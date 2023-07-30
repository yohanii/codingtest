import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class 백준_1074 {



    static void check(Long N, Long c, Long r, Long count) {

        if(N == 1){
            System.out.println(count+r+2*c);
            return;
        }

        //1사분면 : 0 <= r < 2^(n-1)   && 0 <= c < 2^(n-1)
        //2사분면 : 2^(n-1) <= r < 2^n && 0 <= c < 2^(n-1)
        //3사분면 : 0 <= r < 2^(n-1)   && 2^(n-1) <= c < 2^n
        //4사분면 : 2^(n-1) <= r < 2^n && 2^(n-1) <= c < 2^n
        if (0 <= r && r < Math.pow(2, N-1) && 0 <= c && c < Math.pow(2, N-1)) {
            check(N-1, c, r, count);
        } else if (Math.pow(2, N-1) <= r && r < Math.pow(2, N) && 0 <= c && c < Math.pow(2, N-1)) {
            check(N-1, c, r - (long)Math.pow(2, N-1), count + (long)Math.pow(2, 2*N-2));
        } else if (0 <= r && r < Math.pow(2, N-1) && Math.pow(2, N-1) <= c && c < Math.pow(2, N)) {
            check(N-1, c - (long)Math.pow(2, N-1), r, count + 2 * (long)Math.pow(2, 2*N-2));
        } else {
            check(N-1, c - (long)Math.pow(2, N-1), r - (long)Math.pow(2, N-1), count + 3*(long)Math.pow(2, 2*N-2));
        }

    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long N = Long.parseLong(st.nextToken());
        Long r = Long.parseLong(st.nextToken());
        Long c = Long.parseLong(st.nextToken());

        check(N, r, c, (long)0);


    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
