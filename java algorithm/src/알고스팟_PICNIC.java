import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 알고스팟_PICNIC {

    static int count;
    static List<Integer>[] friend;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //개선점
        //1. friend를 list 배열 말고, 2차원 배열에 해놓고, 모든 사람돌면서 friend 조건 확인으로 고칠 수 있음. m이 크면 이 방법이 나을지도.
        //2. connect parameter로 left 남은 사람들 전달해주는데, 배열로 해서, 짝지어진 사람, 아닌 사람 구분해도 좋음.
        //3. 친구 1명인 사람들 고르고, 고른 사람도 체크해서, 처음에 몇 명 지우고 시작하면 빠를 듯.
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

