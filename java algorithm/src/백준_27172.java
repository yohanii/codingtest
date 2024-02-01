import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_27172 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<>();

        int[] indexSave = new int[n + 1];
        int[] indexs = new int[1_000_001];
        int[] score = new int[1_000_001];
        int maxValue = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int input = Integer.parseInt(st.nextToken());
            indexSave[i] = input;
            indexs[input] = i;
            nums.add(input);
            if (input > maxValue) {
                maxValue = input;
            }
        }

        for (Integer num : nums) {
            for (int mul = 2 * num; mul < maxValue + 1; mul += num) {
                if (indexs[mul] != 0) {
                    score[mul]--;
                    score[num]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {

            sb.append(score[indexSave[i]]).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
