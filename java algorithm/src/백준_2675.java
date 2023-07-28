import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class 백준_2675 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int repeatNum = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            IntStream.range(0, str.length()).forEach(index -> sb.append(Character.toString(str.charAt(index)).repeat(repeatNum)));
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
