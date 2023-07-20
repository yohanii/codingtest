import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Stream;



public class 백준_11659 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        arr.add(0);
        arr.add(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()) + arr.get(i));
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(arr.get(end) - arr.get(start-1));
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
