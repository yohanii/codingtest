import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_10974 {

    static int[][] power;
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //start : 15:24
        //end : 15:28

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        permutation(nums, new int[n], new boolean[n], 0, n);
    }

    private void permutation(int[] arr, int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
//            System.out.println(Arrays.toString(output));
            for (int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int index = 0; index < arr.length; index++) {
            if (visited[index]) {
                continue;
            }

            visited[index] = true;
            output[depth] = arr[index];
            permutation(arr, output, visited, depth + 1, r);
            visited[index] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
