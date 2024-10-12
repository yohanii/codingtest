import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_1759 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //start : 21:19
        //end : 21:36 (17m)

        //방법
        //1. C개의 문자들 sorting
        //2. C개의 문자 중 L개 문자 combination
        //3. 최소 한 개의 모음, 최소 두 개의 자으로 구성되었는지 확인 후 출력
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] chars = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken();
        }

        Arrays.sort(chars);
//        System.out.println(Arrays.toString(chars));

        combination(chars, new boolean[chars.length], 0, 0, L);
    }

    public void combination(String[] arr, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
//            System.out.println(Arrays.toString(visited));
            if (isSatisfied(arr, visited)) {
                printWord(arr, visited);
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            combination(arr, visited, i + 1, depth + 1, r);
            visited[i] = false;
        }
    }

    public boolean isSatisfied(String[] chars, boolean[] visited) {
        int moum = 0;
        int jaum = 0;
        Set<String> moums = Set.of("a", "e", "i", "o", "u");

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                String elem = chars[i];
                if (moums.contains(elem)) {
                    moum++;
                    continue;
                }
                jaum++;
            }
        }

        if (moum >= 1 && jaum >= 2) {
            return true;
        }
        return false;
    }

    public void printWord(String[] arr, boolean[] visited) {
        String result = "";
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                result += arr[i];
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
