import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class 백준_16953 {

    private static void bfs(Long A, Long B) {
        Queue<Long[]> queue = new LinkedList<>();
        queue.add(new Long[]{A, (long)0});

        while(!queue.isEmpty()){
            Long[] elem = queue.poll();
            Long temp = elem[0];
            Long depth = elem[1];

            if(temp.equals(B)){
                System.out.println(depth+1);
                return;
            } else if (temp > B) {
                continue;
            }

            queue.add(new Long[]{2*temp, depth+1});
            queue.add(new Long[]{10*temp + 1, depth+1});
        }

        System.out.println(-1);
        return;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());


        bfs(A, B);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
