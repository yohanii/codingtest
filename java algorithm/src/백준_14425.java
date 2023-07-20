import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class 백준_14425 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> NArr = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            NArr.add(str);
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            String str = br.readLine();

            if(NArr.contains(str)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
