import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_1182 {

    static int s;
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //start : 15:29
        //end : 15:41

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[1];

        for (int r = 1; r < n + 1; r++) {
            combination(nums, new boolean[n], 0, 0, r, result);
        }
        System.out.println(result[0]);
    }

    public void combination(int[] arr, boolean[] visited, int start, int depth, int r, int[] result) {
        if (depth == r) {
//            System.out.println(Arrays.toString(visited));
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if (sum == s) {
//                System.out.println("success: " + Arrays.toString(visited));
                result[0]++;
            }
            return;
        }

        for (int index = start; index < arr.length; index++) {
            if (visited[index]) {
                continue;
            }

            visited[index] = true;
            combination(arr, visited, index + 1, depth + 1, r, result);
            visited[index] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
