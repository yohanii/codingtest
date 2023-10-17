import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_11404 {

    static ArrayList<Bus>[] map;
    static boolean[] visited;
    static int[][] result;

    class Bus {
        private int target;
        private int cost;

        public Bus(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];
        for(int i = 0; i < map.length; i++) {
            map[i] = new ArrayList();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start].add(new Bus(end, cost));
        }

        visited = new boolean[n+1];
        result = new int[n+1][n+1];

//        dijkstra(2);

        IntStream.range(1, n+1).forEach(i -> {
            Arrays.fill(result[i], Integer.MAX_VALUE);
            Arrays.fill(visited, false);
            dijkstra(i);
        });

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(result[i][j] == Integer.MAX_VALUE)
                    sb.append(0).append(" ");
                else
                    sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void dijkstra(int start) {
        visited[0] = true;
        visited[start] = true;
        result[start][0] = 0;
        result[start][start] = 0;

        int index = start;
        while(true) {
//            System.out.println(index);
            visited[index] = true;

            //거리 업데이트
            final int tempIndex = index;
            map[index].stream()
//                    .filter(bus -> !visited[bus.getTarget()])
                    .filter(bus -> result[start][bus.getTarget()] > result[start][tempIndex] + bus.getCost())
                    .forEach(bus -> result[start][bus.getTarget()] = result[start][tempIndex] + bus.getCost());

            //다음 이동 지점 업데이트
            index = IntStream.range(1, result.length)
                    .boxed()
                    .filter(i -> !visited[i])
                    .min(Comparator.comparingInt(i -> result[start][i]))
                    .orElse(-1);

            //visited 모두 true면 break
            if(checkVisited() || result[start][index] == Integer.MAX_VALUE)
                break;


//            for(int i = 1; i < result.length; i++) {
//                System.out.print(result[start][i] + " ");
//            }
//            System.out.println("");
        }
    }

    private boolean checkVisited() {
        for(boolean tf: visited) {
            if(!tf)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
