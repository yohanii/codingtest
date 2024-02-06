import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.IntStream;

public class 백준_1644 {
    static int n;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //n이하의 소수 리스트 뽑기
        //큰 수부터 돌면서 만들어지는지 체크
        n = Integer.parseInt(br.readLine());
        List<Integer> prime = getPrime(n);
//        System.out.println("prime = " + prime);

        int count = getCount(prime);

        System.out.println(count);
    }

    private int getCount(List<Integer> prime) {
        if (prime.isEmpty()) {
            return 0;
        }

        int count = 0;
        int start = 0;
        int end = 1;
        int sum = prime.get(start);

        while (end <= prime.size()) {
            if (sum < n) {
                if (end >= prime.size()) {
                    break;
                }
                sum += prime.get(end);
                end++;
                continue;
            }
            if (sum > n) {
                sum -= prime.get(start);
                start++;
                continue;
            }
            if (sum == n) {
                count++;
                if (end >= prime.size()) {
                    break;
                }
                sum += prime.get(end);
                end++;
            }
        }

        return count;
    }

    private int checkAble(int index, List<Integer> prime) {
        int cur = index;
        int sum = 0;
        while (sum < n && cur >= 0) {
            sum += prime.get(cur);
            if (sum == n) {
                return 1;
            }
            cur--;
        }
        return 0;
    }

    private List<Integer> getPrime(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        List<Integer> prime = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = 2*i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                prime.add(i);
            }
        }

        return prime;
    }

    private static boolean isPrime(int i, List<Integer> prime) {
        return IntStream.range(0, prime.size()).noneMatch(num -> i % prime.get(num) == 0);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
