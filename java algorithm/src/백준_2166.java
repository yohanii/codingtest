import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_2166 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //첫 점 root
        //다음 두 점씩 삼각형 넓이 구해줌
        //root-second 기울기 < root-first이면 넓이 마이너스
        //반복 후 넓이 절대값 구해줌
        int n = Integer.parseInt(br.readLine());

        int[][] pos = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        pos[n][0] = pos[0][0];
        pos[n][1] = pos[0][1];

        double totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += pos[i][0] * pos[i + 1][1] - pos[i][1] * pos[i + 1][0];
        }


        totalSum = Math.abs(totalSum) / 2.0 ;
        System.out.printf("%.1f", totalSum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
