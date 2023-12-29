import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_12851 {
    static int n, k;
    static int minTime, ableCount;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //bfs
        //n > k이면 -1
        //n < k이면 +1, -1, *2
        minTime = Integer.MAX_VALUE;
        ableCount = 0;
        bfs();

        System.out.println(minTime);
        System.out.println(ableCount);
    }

    private void bfs() {
        int[] visited = new int[100001];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(n, 0));

        while(true) {
//            System.out.println(queue);
            if (queue.isEmpty()) {
                break;
            }

            Pos pos = queue.poll();

            if (pos.moveCount > minTime) {
                break;
            }

            if (pos.index == k) {
                minTime = pos.moveCount;
                ableCount++;
                continue;
            }

            if (pos.index > k && pos.index - 1 >= 0) {
                if (visited[pos.index - 1] == pos.moveCount || visited[pos.index - 1] == 0) {
                    pos.moveMinusOne(visited);
                    queue.add(pos);
                    continue;
                }
            }

            if (pos.index + 1 <= 100000) {
                if (visited[pos.index + 1] == pos.moveCount || visited[pos.index + 1] == 0) {
                    Pos newPos1 = new Pos(pos.index, pos.moveCount);
                    newPos1.movePlusOne(visited);
                    queue.add(newPos1);
                }
            }

            if (pos.index - 1 >= 0) {
                if (visited[pos.index - 1] == pos.moveCount || visited[pos.index - 1] == 0) {
                    Pos newPos2 = new Pos(pos.index, pos.moveCount);
                    newPos2.moveMinusOne(visited);
                    queue.add(newPos2);
                }
            }

            if (pos.index * 2 <= 100000) {
                if (visited[pos.index * 2] == pos.moveCount || visited[pos.index * 2] == 0) {
                    Pos newPos3 = new Pos(pos.index, pos.moveCount);
                    newPos3.moveDouble(visited);
                    queue.add(newPos3);
                }
            }
        }

    }

    class Pos {
        int index;
        int moveCount;

        public Pos(int index, int moveCount) {
            this.index = index;
            this.moveCount = moveCount;
        }

        @Override
        public String toString() {
            return "[" + index + ", " + moveCount + "]";
        }

        public void movePlusOne(int[] visited) {
            index++;
            visited[index] = moveCount;
            moveCount++;
        }

        public void moveMinusOne(int[] visited) {
            index--;
            visited[index] = moveCount;
            moveCount++;
        }

        public void moveDouble(int[] visited) {
            index *= 2;
            visited[index] = moveCount;
            moveCount++;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
