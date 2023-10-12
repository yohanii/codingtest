import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_16928 {

    static Map<Integer, Integer> map;
    static int[] visited;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //bfs
        //6 안에서 사다리 있으면 queue에 추가, 6 추가
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        for(int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            map.put(before, after);
        }

        int start = 1;
        int end = 100;

        visited = new int[101];
        bfs(start, end);
    }

    public void bfs(int start, int end) {
        boolean isAdded;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        while(!queue.isEmpty()) {
//            for(int[] i: queue) {
//                System.out.print("[" + i[0] + ", " + i[1] + "],");
//            }
//            System.out.println("");

            int[] elem = queue.poll();
            int pos = elem[0];
            int depth = elem[1];
            visited[pos] = 1;

            if(pos == end) {
                System.out.println(depth);
                return;
            }

            isAdded = false;
            for(int dice = 6; dice > 0; dice--) {
                int newPos = pos + dice;

                if(newPos > 100)
                    continue;

                if(visited[newPos] == 0) {
                    if (map.containsKey(newPos)) {
                        queue.add(new int[]{map.get(newPos), depth + 1});
                        continue;
                    }

                    if(!isAdded || newPos == end) {
                        queue.add(new int[]{newPos, depth + 1});
                        isAdded = true;
                    }
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
