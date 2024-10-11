import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_1339 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //start : 16:05
        //end : 16:12

        //방법
        //1. 알파벳 별로, Map에 자리수 반영한 합 기록
        //2. value가 가장 큰 순서대로 높은 수 배정
        //3. 합 구하기
        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> alphabets = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            //뒤에서 부터
            for (int j = 0; j < input.length(); j++) {
                int index = input.length() - 1 - j;
                char cur = input.charAt(index);
                int value = (int) Math.pow(10, j);
                alphabets.put(cur, alphabets.getOrDefault(cur, 0) + value);
            }
        }
//        System.out.println(alphabets);

        List<Character> sortedKeys = alphabets.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
//        System.out.println(sortedKeys);

        int sum = 0;
        for (int i = 0; i < sortedKeys.size(); i++) {
            int value = 9 - i;
            sum += value * alphabets.get(sortedKeys.get(i));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
