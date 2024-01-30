import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_10942_시간초과 {

    static int n, m;
    static int[] nums;
    static Set<Elem> pell;

    static int[][] question;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;


        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //각 숫자 돌면서
        //얼마나 뻗어나갈 수 있는지 체크
        //팰린드롬이면 리스트에 저장
        pell = new HashSet<>();

        for (int index = 1; index < n + 1; index++) {
            findPell(index, 0);
            if (index < n && nums[index] == nums[index + 1]) {
                findPell(index, 1);
            }
//            System.out.println("index = " + index);
//            System.out.println("pell = " + pell);
        }

        sb = new StringBuilder();
        m = Integer.parseInt(br.readLine());
        question = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(question[i], -1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (question[start][end] != -1) {
                sb.append(question[start][end]).append("\n");
                continue;
            }

            if (pell.contains(new Elem(start, end))) {
//                System.out.println(1);
                sb.append("1\n");
                question[start][end] = 1;
                continue;
            }
//            System.out.println(0);
            sb.append("0\n");
            question[start][end] = 0;
        }
        System.out.println(sb);
    }

    private void findPell(int index, int dis) {
        int round = 0;

        while (true) {
            int start = index - round;
            int end = index + round + dis;

            if (start < 1 || end > n) {
                break;
            }

            if (start == end) {
                pell.add(new Elem(start, end));
                round++;
                continue;
            }

            if (nums[start] == nums[end]) {
                pell.add(new Elem(start, end));
                round++;
                continue;
            }
            break;
        }
    }

    class Elem {
        int s;
        int e;
        public Elem(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public boolean equals(Object obj) {
            Elem elem = (Elem) obj;

            return elem.hashCode() == this.hashCode();
        }

        @Override
        public int hashCode() {
            return Objects.hash(s + " " + e);
        }

        @Override
        public String toString() {
            return "[" + s + "," + e + "] ";
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
