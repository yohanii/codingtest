import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class 백준_10815 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> playerArr = new HashSet<>();
        for(int i = 0; i < N; i++) {
            playerArr.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            if(playerArr.contains(Integer.parseInt(st.nextToken()))) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
//        System.out.println("\b");
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
