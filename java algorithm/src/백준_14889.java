import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_14889 {

    static int[][] power;
    static int minGap;
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //start : 14:34
        //end : 15:01 (27m)

        //방법
        //완전탐색, 순열
        //1. n명 중 n/2 명 순열로 뽑는다.
        //2. 각 팀의 능력치의 차이를 구한다.
        int n = Integer.parseInt(br.readLine());
        power = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int[] ints: power) {
//            System.out.println(Arrays.toString(ints));
//        }


        minGap = Integer.MAX_VALUE;
        combination(new boolean[n], 0, 0, n/2);

        System.out.println(minGap);

    }

    public void combination(boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
//            System.out.println(Arrays.toString(visited));
            int trueScore = getScoreWithTF(visited, true);
            int falseScore = getScoreWithTF(visited, false);

            int gap = Math.abs(trueScore - falseScore);
            if (gap < minGap) {
                minGap = gap;
            }

            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            combination(visited, i + 1, depth + 1, r);
            visited[i] = false;
        }
    }

    private int getScoreWithTF(boolean[] visited, boolean tf) {
        List<Integer> elems = new ArrayList<>();
        for (int index = 0; index < visited.length; index++) {
            if (visited[index] == tf) {
                elems.add(index);
            }
        }
//        System.out.println("elems: " + elems);

        int score = 0;
        for (int i = 0; i < elems.size(); i++) {
            for (int j = 0; j < elems.size(); j++) {
                score += power[elems.get(i)][elems.get(j)];
            }
        }
//        System.out.println("score: " + score);
        return score;
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
