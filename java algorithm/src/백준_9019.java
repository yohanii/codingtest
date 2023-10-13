import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_9019 {

    static String[] actList = new String[]{"D", "S", "L", "R"};
    static int[] result;

    class Elem {
        int value;
        String history;
        int depth;

        public Elem(int value, String history, int depth) {
            this.value = value;
            this.history = history;
            this.depth = depth;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            result = new int[10001];

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            String result = bfs(start, end);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private String bfs(int start, int end) {
        Queue<Elem> queue = new LinkedList<>();
        queue.add(new Elem(start, "", 1));

        while(!queue.isEmpty()) {
            Elem elem = queue.poll();
            int value = elem.value;
            String history = elem.history;
            int depth = elem.depth;

            if(value == end) {
                return history;
            }

            if(result[value] > 1)
                continue;

            result[value] = depth;

            Arrays.stream(actList)
                    .forEach(str -> queue.add(new Elem(getResult(str, value), history + str, depth + 1)));

        }

        return null;
    }

    private int getResult(String str, int value) {
        switch (str) {
            case "D":
                return getD(value);
            case "S":
                return getS(value);
            case "L":
                return getL(value);
            case "R":
                return getR(value);
            default:
                return -1;
        }
    }

    private int getR(int value) {
        int remain = value / 10;
        int d4 = value % 10;

        return 1000*d4 + remain;
    }

    private int getL(int value) {
        int d1 = value / 1000;
        int remain = value % 1000;

        return 10*remain + d1;
    }

    private int getS(int value) {
        return value == 0 ? 9999 : value-1;
    }

    private int getD(int value) {
        return 2*value%10000;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
