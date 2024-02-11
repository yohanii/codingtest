import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_2623_메모리초과 {
    static int n, m;
    static Set<Integer>[] parent, child;
    static boolean[] visited;
    static StringBuilder sb;
    static boolean flag;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new HashSet[n+1];
        child = new HashSet[n+1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = new HashSet<>();
            child[i] = new HashSet<>();
        }

        int[] input = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nums = Integer.parseInt(st.nextToken());
            for (int j = 0; j < nums; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < nums - 1; j++) {
                for (int k = j + 1; k < nums; k++) {
                    Integer start = input[j];
                    Integer end = input[k];
                    parent[end].add(start);
                    child[start].add(end);
                }
            }

//            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            for (int j = 1; j < input.length - 1; j++) {
//                for (int k = j + 1; k < input.length; k++) {
//                    Integer start = input[j];
//                    Integer end = input[k];
//                    parent[end].add(start);
//                    child[start].add(end);
//                }
//            }
        }

        flag = false;
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dfs(i, i);
        }

        if (flag) {
            System.out.println(0);
            return;
        }
        System.out.println(sb);
    }

    private void dfs(int index, int startIndex) {
        if (visited[index]) {
            return;
        }

        for (Integer parentIndex : parent[index]) {
            if (parentIndex == startIndex && !visited[startIndex]) {
                flag = true;
//                System.out.println("parentIndex = " + parentIndex);
                return;
            }
            if (!visited[parentIndex]) {
                dfs(parentIndex, startIndex);
            }
        }

        if (visited[index]) {
            return;
        }

        visited[index] = true;
        sb.append(index).append("\n");

        for (Integer childIndex : child[index]) {
            if (!visited[childIndex]) {
                dfs(childIndex, startIndex);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
