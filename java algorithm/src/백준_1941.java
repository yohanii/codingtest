import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_1941 {

    static int count;
    static String[][] map;
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //start : 23:39
        //end : 24:29 (50m)

        //방법1
        //dfs depth 7
        //dfs를 통해 7글자를 만들고, S의 개수를 체크한다.
        //bigVisited, visited를 만들어, 이중 for문 돈 것은 bigVisited에 기록하고, 다신 접근하지 않는다.
        //visited는 매번 초기화해서 진행

        //방법2
        //5*5 25자리만 있으므로, 25자리 중 7개 combination
        //S가 4개 이상인 경우만, dfs로 인접한지 확인
        map = new String[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().split("");
//            System.out.println(Arrays.toString(map[i]));
        }

        int[][] points = new int[25][2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0 ; j < 5; j++) {
                points[5*i+j] = new int[]{i, j};
            }
        }


        count = 0;
        combination(points, new boolean[points.length], 0, 0, 7);
        System.out.println(count);
    }

    private void combination(int[][] arr, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
//            System.out.println(Arrays.toString(visited));
            if (valid(arr, visited)) {
//                System.out.println(Arrays.toString(visited));
                List<int[]> selected = new ArrayList<>();
                for (int i = 0; i < visited.length; i++) {
                    if (visited[i]) {
                        selected.add(arr[i]);
                    }
                }

                boolean[] nears = new boolean[selected.size()];
                dfs(0, selected, nears);

//                System.out.println("nears : " + Arrays.toString(nears));
                for (int i = 0; i < nears.length; i++) {
                    if (!nears[i]) {
                        return;
                    }
                }
                count++;
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            combination(arr, visited, i + 1, depth + 1, r);
            visited[i] = false;
        }
    }

    private void dfs(int index, List<int[]> selected, boolean[] visited) {
        visited[index] = true;

        for (int i = 0; i < selected.size(); i++) {
            if (!visited[i] && isNear(selected.get(index), selected.get(i))) {
                dfs(i, selected, visited);
            }
        }
    }

    private boolean isNear(int[] arr1, int[] arr2) {
//        System.out.println(Arrays.toString(arr1) + Arrays.toString(arr2));
        return Math.abs(arr1[0] - arr2[0]) + Math.abs(arr1[1] - arr2[1]) == 1;
    }

    private boolean valid(int[][] arr, boolean[] visited) {

        int sCount = 0;
        for (int i= 0; i < visited.length; i++) {
            if (visited[i]) {
                String value = map[arr[i][0]][arr[i][1]];
                if (value.equals("S")) {
                    sCount++;
                    if (sCount >= 4) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
