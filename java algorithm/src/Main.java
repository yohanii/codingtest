import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static int count;
    static List<Integer>[] friend;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            //입력받아서, List[] 에 친구 적기
            friend = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                friend[i] = new ArrayList();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());

                friend[p1].add(p2);
                friend[p2].add(p1);
            }

            count = 0;
            connect(IntStream.range(0, n).boxed().collect(Collectors.toList()));
            System.out.println(count);
        }




    }

    //첫 사람을 친구와 짝짓고 connect 호출
    public void connect(List<Integer> left) {
//        System.out.println("left = " + left);
        if (left.isEmpty()) {
            count++;
            return;
        }

        List<Integer> lefts = new ArrayList<>(left);
        Integer first = left.get(0);
        lefts.remove(first);
        for (Integer second : friend[first]) {
            if (left.contains(second)) {
                lefts.remove(second);
                connect(lefts);
                lefts.add(second);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
