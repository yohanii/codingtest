import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2342_greedy_실패 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //가장 가까운 곳에 있는 발로 움직인다.
        //하지만, 두 곳이 반복되면 두 발을 위치시키는게 더 좋다.
        //1(오)-3(왼)-2-1-2-1-2-1이면 2에 왼발이 가야한다.
        //앞의 수열 2개씩 보면서 어떤 발을 써야할지 계산
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = nums.length;

        int right = 0;
        int left = 0;
        int cost = 0;
        for (int index = 0; index < length; index++) {
//            System.out.println("right, left = " + right + ", " + left);
            if (index == length - 1) {
                continue;
            }

            if (nums[index] == right) {
                cost += 1;
                continue;
            }
            if (nums[index] == left) {
                cost += 1;
                continue;
            }

            if (right == 0) {
                right = nums[index];
                cost += 2;
                continue;
            }
            if (left == 0) {
                left = nums[index];
                cost += 2;
                continue;
            }

            if (getDistance(right, nums[index]) == 1 && find(index, nums) != right) {
                right = nums[index];
                cost += 3;
                continue;
            }

            if (getDistance(left, nums[index]) == 1 && find(index, nums) != left) {
                left = nums[index];
                cost += 3;
                continue;
            }

            if (getDistance(right, nums[index]) == 2) {
                right = nums[index];
                cost += 4;
                continue;
            }

            if (getDistance(left, nums[index]) == 2) {
                left = nums[index];
                cost += 4;
                continue;
            }

        }
        System.out.println(cost);
    }

    private int find(int index, int[] nums) {
        int indexValue = nums[index];
        int length = nums.length;

        for (int i = index + 1; i < length - 1; i++) {
            if (nums[i] != indexValue) {
                return nums[i];
            }
        }
        return indexValue;
    }

    private int getDistance(int x, int y) {
        if (x == 4) {
            return Math.min(Math.abs(y-4), Math.abs(y-0));
        }
        if (y == 4) {
            return Math.min(Math.abs(x-4), Math.abs(x-0));
        }

        return Math.abs(x-y);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

