import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_1389 {

    static int n, m;
    static ArrayList<Integer>[] graph;

    public int kebin(int start) {
        int answer = 0;
        int[] visited = new int[n+1];
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = 1;
        queue.add(new int[]{start, 0});

        while(!queue.isEmpty()){
            int[] elem = queue.poll();
            int index = elem[0];
            int dis = elem[1];
            answer += dis;

            //친구 추가
            for(int i : graph[index]){
                if(visited[i] == 0){
                    visited[i] = 1;
                    queue.add(new int[]{i, dis+1});
                }
            }
        }
        return answer;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++)
            graph[i] = new ArrayList<Integer>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        //모든 사람의 케빈 베이컨 합의 값 구해준다.
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for(int i = 1; i < n+1; i++){
            int cur = kebin(i);

//            System.out.println(cur);

            if(min > cur){
                min = cur;
                minIndex = i;
            }
        }

        System.out.println(minIndex);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
