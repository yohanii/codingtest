import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class 백준_20040_시간초과 {

    static int n, m;
    static boolean isSuccess;
    static List<Integer>[] graph;
    static Set<Integer> appear;
    static int[] visited;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //가장 작은 수 parent로 하고,
        //새로운 선 그을 때, parent 같으면 종료

        //visited 한점을 기록해두고
        //새로 선 그을때마다 visited 점들 돌면서 한바뀌 돌아지는지 체크
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int count = 0;
        isSuccess = false;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        appear = new HashSet<>();

        int[][] lines = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }


        while (count < m) {
            int start = lines[count][0];
            int end = lines[count][1];
            graph[start].add(end);
            graph[end].add(start);
            appear.add(start);
            appear.add(end);

            visited = new int[n];
            for (Integer node : appear) {
                dfs(node, -1);
            }
            if (isSuccess) {
                break;
            }
            count++;
        }

        if (count == m) {
            System.out.println(0);
            return;
        }
        System.out.println(count + 1);

    }

    public void dfs(int index, int prev) {
//        System.out.println("index = " + index);
        if (visited[index] == 1) {
            return;
        }
        visited[index] = 1;

        for (Integer next : graph[index]) {
            if (visited[next] == 1) {
                if (next == prev) {
                    continue;
                }
                isSuccess = true;
                return;
            }

            dfs(next, index);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
