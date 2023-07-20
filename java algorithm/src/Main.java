import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Stream;



public class Main {
    static void check(int n, int start, int end, ArrayList<Integer> arr) {
        // 0 ~ len/2, len/2+1 ~ len-1
        // start ~ (start+end)/2, (start+end)/2+1 ~ end
        int len = arr.size();

        if(n == arr.get((start+end)/2)){
            System.out.println("1");
        } else if (start == end) {
            System.out.println("0");
        } else if (n < arr.get((start+end)/2)) {
            check(n, start, (start+end)/2, arr);
        } else if (n > arr.get((start+end)/2)) {
            check(n,(start+end)/2 + 1, end, arr);
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            check(Integer.parseInt(st.nextToken()), 0, arr.size()-1, arr);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
