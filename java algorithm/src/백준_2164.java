import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class 백준_2164 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(true) {
            int a = queue.poll();

            if(queue.size() == 0) {
                System.out.println(a);
                break;
            }
            queue.add(queue.poll());
            if(queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
