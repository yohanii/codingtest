import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_2473 {
    static int n;
    static List<Long> liquids;
    static long minValue;
    static List<Integer> resultIndexs;

    static boolean token;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //용액들 오름차순 정렬
        //첫번째 용액 - 탈출하고 한번까지만 탐색
        //첫, 둘 용액 전체 돌면서, 세번째 용액은 가장 큰 + 용액에서 앞으로 한칸씩 오며, 결과값 한번 커지면 끝
        n = Integer.parseInt(br.readLine());
        liquids = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toList());
        Collections.sort(liquids);
//        System.out.println("liquids = " + liquids);

        minValue = Long.MAX_VALUE;
        resultIndexs = new ArrayList<>();
        for (int first = 0; first < n - 2; first++) {
            search(first);
        }
        for (Integer index : resultIndexs) {
            System.out.print(liquids.get(index) + " ");
        }
    }

    private void search(int first) {
        int start = first + 1;
        int end = n - 1;

        while (start < end) {
            long sum = liquids.get(first) + liquids.get(start) + liquids.get(end);
            long absSum = Math.abs(sum);
            if (absSum < minValue) {
                minValue = absSum;
                resultIndexs = new ArrayList<>(List.of(first, start, end));
//                System.out.println("minValue = " + minValue);
//                System.out.println("resultIndexs = " + resultIndexs);
            }

            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
