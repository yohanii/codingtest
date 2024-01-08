import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_16236 {

    static int n;
    static int[][] graph;
    static int[][] map;
    static Shark shark;
    static List<Fish> fishes;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        fishes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    shark = new Shark(i, j);
                    continue;
                }
                if (graph[i][j] != 0) {
                    fishes.add(new Fish(i, j, graph[i][j]));
                }
            }
        }
        graph[shark.x][shark.y] = 0;

        while (true) {
            //먹을 수 있는 fish list 구하기
            List<Fish> ableFishes = fishes.stream()
                    .filter(fish -> fish.size < shark.size)
                    .collect(Collectors.toList());

            if (ableFishes.isEmpty()) {
                System.out.println(shark.totalTime);
                return;
            }

            //여러 마리일 경우, bfs 돌려서 최단 거리 구하기  //가장 가까운 fish 먹기
            boolean isSuccess = bfs(ableFishes);

            if (!isSuccess) {
                System.out.println(shark.totalTime);
                return;
            }

//            System.out.println(shark);
        }
    }

    private boolean bfs(List<Fish> ableFishes) {
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(shark.x, shark.y, 0));

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (map[pos.x][pos.y] <= pos.distance) {
                continue;
            }
            map[pos.x][pos.y] = pos.distance;

            for (int i = 0; i < 4; i++) {
                int newX = pos.x + dx[i];
                int newY = pos.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && graph[newX][newY] <= shark.size) {
                    queue.add(new Pos(newX, newY, pos.distance + 1));
                }
            }
        }

        PriorityQueue<Fish> pq =  new PriorityQueue<>(ableFishes);
        Fish fish = pq.poll();

        if (map[fish.x][fish.y] == Integer.MAX_VALUE) {
            return false;
        }
        //eat
        shark.eatFish(fish, map[fish.x][fish.y]);
        return true;
    }

    class Pos {
        int x;
        int y;
        int distance;

        public Pos(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    class Fish implements Comparable<Fish> {
        int x;
        int y;
        int size;

        public Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public int compareTo(Fish fish) {
            if (map[x][y] < map[fish.x][fish.y]) {
                return -1;
            }

            if (map[x][y] > map[fish.x][fish.y]) {
                return 1;
            }

            if (x < fish.x) {
                return -1;
            }

            if (x == fish.x && y < fish.y) {
                return -1;
            }

            return 1;
        }
    }

    class Shark extends Fish {
        int eatStack;
        int totalTime;

        public Shark(int x, int y) {
            super(x, y, 2);
            this.eatStack = 0;
            this.totalTime = 0;
        }

        public void eatFish(Fish fish, int time) {
            eatStack++;
            if (eatStack >= size) {
                size++;
                eatStack = 0;
            }
            graph[fish.x][fish.y] = 0;
            x = fish.x;
            y = fish.y;
            totalTime += time;
            fishes.remove(fish);
        }

        @Override
        public String toString() {
            String str = "";
            str += "shark.x = " + shark.x + "\n";
            str += "shark.y = " + shark.y + "\n";
            str += "shark.eatStack = " + shark.eatStack + "\n";
            str += "shark.totalTime = " + shark.totalTime + "\n";

            return str;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
