import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {

    static int t, n;
    static int[] goal;
    static List<Integer> save;
    static int[] visited;
    static int count;

    static int[] finished;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            goal = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                goal[i] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            finished = new int[n + 1];
            visited = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                save = new ArrayList<>();
                find(i);
            }

//            int count = 0;
//            for (int i : visited) {
////                System.out.print(i + " ");
//                if (i == 2) {
//                    count++;
//                }
//            }
//            System.out.println();
//            System.out.println(count);
            sb.append(n - count).append("\n");
        }
        System.out.println(sb);


    }

    public void find(int index) {
        if (visited[index] != 0) {
            return;
        }
        visited[index] = 1;

        if (visited[goal[index]] == 0) {
            find(goal[index]);
        } else if (finished[goal[index]] == 0) {
            count++;
            for (int i = goal[index]; i!=index; i = goal[i]) {
                count++;
            }
//            System.out.println("count = " + count);
        }
        finished[index] = 1;
    }

//    public void find(int index) {
//        if (visited[index] != 0) {
//            fillVisitedOfSave(save, 2);
//            return;
//        }
//        if (goal[index] == index) {
//            visited[index] = 1;
//            fillVisitedOfSave(save, 2);
//            return;
//        }
//
//        save.add(index);
//        if (save.contains(goal[index])) {
//            int pos = save.indexOf(goal[index]);
//            fillVisitedOfSave(save.subList(0, pos), 2);
//            fillVisitedOfSave(save.subList(pos, save.size()), 1);
//            return;
//        }
//
//        find(goal[index]);
//    }

    private static void fillVisitedOfSave(List<Integer> save, int x) {
        save.forEach(i -> visited[i] = x);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
