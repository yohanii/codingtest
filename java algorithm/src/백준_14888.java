import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_14888 {

    static int n;
    static int[] nums, operators;
    static int minValue, maxValue;
    public void solution() throws IOException {

        //30m 19s
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                dfs(0, i, nums[0]);
                operators[i]++;
            }
        }
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private void dfs(int index, int operator, int sum) {
//        System.out.println("index, operator, sum = " + index + ", " + operator + ", " + sum);
        if (operators[operator] < 0) {
            return;
        }

        int newSum = calculateSum(sum, nums[index+1], operator);

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                dfs(index + 1, i, newSum);
                operators[i]++;
                continue;
            }
            count++;
        }

        if (count >= 4) {
            if (newSum < minValue) {
                minValue = newSum;
            }
            if (newSum > maxValue) {
                maxValue = newSum;
            }
        }
    }

    private int calculateSum(int sum, int num, int operator) {
        switch (operator) {
            case 0:
                return sum + num;
            case 1:
                return sum - num;
            case 2:
                return sum * num;
            case 3:
                return sum / num;
        }

        return -1;
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
