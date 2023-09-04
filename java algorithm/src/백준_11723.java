import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class 백준_11723 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int S = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;

            switch (str) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    S = S|(1<<num-1);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    S = S&~(1<<num-1);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
//                    System.out.println((S>>num-1)%2);
                    sb.append((S>>num-1)%2).append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    S = S^(1<<num-1);
                    break;
                case "all":
                    S = (1<<20)-1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
