import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class 백준_2252 {
    static int n, m;
    static List<Integer>[] parent, child;
    static boolean[] visited;
    static StringBuilder sb;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new ArrayList[n+1];
        child = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = new ArrayList();
            child[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            parent[end].add(start);
            child[start].add(end);
        }

        visited = new boolean[n + 1];
        for (int i = 1; i < n+1; i++) {
            dfs(i);
        }
        System.out.println(sb);
    }

    private void dfs(int index) {
//        System.out.println("index = " + index);
        if (visited[index]) {
            return;
        }

        dfsForList(parent[index]);

        if (visited[index]) {
            return;
        }

        visited[index] = true;
//        System.out.print(index + " ");
        sb.append(index).append(" ");

        dfsForList(child[index]);
    }

    private void dfsForList(List<Integer> indexs) {
        for (Integer index : indexs) {
            if (!visited[index]) {
                dfs(index);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
