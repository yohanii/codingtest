import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_12015 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //시간초과
        //LIS 사용해야한다.
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            input[i] = num;
        }

//        System.out.println(Arrays.toString(input));

        List<Elem> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int dp = 1;
            //dp 계산
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).num < input[i]) {
                    dp = list.get(j).dp + 1;
//                    System.out.println(dp);
                    break;
                }
            }

            //리스트에 추가
            list.add(new Elem(dp, input[i]));
            //소팅
            Collections.sort(list, (e1, e2) -> e2.dp - e1.dp);
//            System.out.println("list = " + list);
        }

//        System.out.println(Arrays.toString(dp));

        int result = list.get(0).dp;
        System.out.println(result);

    }

    class Elem {
        int dp;
        int num;
        public Elem(int dp, int num) {
            this.dp = dp;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Elem{" +
                    "dp=" + dp +
                    ", num=" + num +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
