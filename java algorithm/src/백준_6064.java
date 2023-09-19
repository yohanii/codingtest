import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_6064 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //M, N 중 큰 걸로 돌리면서, 값이 맞는지 체크한다.
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean isSuccess = false;

            long num = (long) x;
//            System.out.println("------------");
            while(num <= m * n) {
//                System.out.println(num);
                if(num % n == y % n) {
                    System.out.println(num);
                    isSuccess = true;
                    break;
                }
                num += m;
            }
            if(!isSuccess)
                System.out.println(-1);
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
