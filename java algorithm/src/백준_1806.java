import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_1806 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //start, end index를 조절하는 방식
        //start+1 할 수 있는 만큼 한다.
        //불가능하면 end + 1한다.
        //반복하며 최소 길이 갱신. end = length - 1이고, start 최대로 갔을 때 종료
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] map = new int[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            totalSum += map[i];
        }

        if (totalSum < s) {
            System.out.println(0);
            return;
        }

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = map[start];
        int length = 1;

        while (true) {
//            System.out.println("start, end = " + start + ", " + end);

            while (sum - map[start] >= s) {
                length--;
                sum -= map[start];
                start++;
            }

            if (sum >= s && length < minLength) {
                minLength = length;
            }

            length++;
            end++;
            if (end >= n) {
                break;
            }
            sum += map[end];
        }
        System.out.println(minLength);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
