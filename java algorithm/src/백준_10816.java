import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_10816 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //map에 담고 출력
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = map.getOrDefault(num, 0);
            sb.append(result).append(" ");
        }
        System.out.println(sb);

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
