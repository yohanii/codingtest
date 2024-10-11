import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_1339_순열_시간초과 {

    static List<Character> chars;
    static Map<Character, Integer> charMap;
    static String[] inputs;

    static int max;
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //start : 15:40
        //end : 16:04

        //방법
        //1. 알파벳 개수 세기
        //2. 해당 길이로 permutation해서 0~9 숫자 뽑기
        //3. 계산해서 최대값 갱신
        int n = Integer.parseInt(br.readLine());

        inputs = new String[n];
        Set<Character> alphabets = new HashSet<>();
        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
            for (char c : inputs[i].toCharArray()) {
                alphabets.add(c);
            }
        }

        int k = alphabets.size();
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        chars = alphabets.stream()
                .sorted()
                .collect(Collectors.toList());
        max = Integer.MIN_VALUE;

        //k개 permutation
        permutation(nums, new int[k], new boolean[nums.length], 0, k);

        System.out.println(max);
    }

    public void permutation(int[] arr, int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
//            System.out.println(Arrays.toString(output));
            charMap = new HashMap<>();
            for (int i = 0; i < output.length; i++) {
                charMap.put(chars.get(i), output[i]);
            }
//            System.out.println(charMap);

            calculateSum(inputs, charMap);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            output[depth] = arr[i];
            permutation(arr, output, visited, depth + 1, r);
            visited[i] = false;
        }
    }

    private void calculateSum(String[] inputs, Map<Character, Integer> charMap) {

        int sum = 0;
        for (String input : inputs) {
            String newStr = "";
            for (char c : input.toCharArray()) {
                newStr += charMap.get(c);
            }
            sum += Integer.parseInt(newStr);
        }

        if (sum > max) {
            max = sum;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
