import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_13549 {

    static int n, k;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //n>k이면 -1
        //n<k이면 -1, +1, *2
        //*2할 때는 2*n-k < k-n 일때만
        //0일때 예외
        //bfs
        //times arr에 시간 저장해두기
        int result = bfs();
        System.out.println(result);
    }

    public int bfs() {
        int[] times = new int[200000];
        Arrays.fill(times, Integer.MAX_VALUE);

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(n, 0));

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
//            System.out.println("current.index = " + current.index);

            if (times[current.index] <= current.time) {
                continue;
            }
            times[current.index] = current.time;

            if (current.index < k) {
                queue.add(new Pos(current.index + 1, current.time + 1));

                if (current.index != 0 && 2 * current.index - k < k - current.index) {
                    queue.add(new Pos(current.index * 2, current.time));
                }
            }

            if (current.index != 0) {
                current.index -= 1;
                current.time++;
                queue.add(current);
            }
//            System.out.println(queue);
        }
        return times[k];
    }

    class Pos {
        int index;
        int time;

        public Pos(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public String toString() {
            return "[" + index + ", " + time + "]";
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
