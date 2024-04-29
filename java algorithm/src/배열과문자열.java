import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 배열과문자열 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //코딩인터뷰 배열과 문자열 9문제

        //1. String 중복 확인
        //문자열에 같은 문자가 중복되어 등장하는지 확인.
        //자료구조를 추가로 사용하지 말것.
//        String str1 = "abcdefg";
//        String str2 = "abcde fgh";
//        String str3 = "abcd efga";
//        for (String str : List.of(str1, str2, str3)) {
//            //true, true, false
//            boolean result = checkDuplicate(str);
//            System.out.println("result = " + result);
//        }

//        //2. 두 문자열이 순열관계인지 확인
//        //순열관계 : 두 문자열에서 사용된 문자는 같은데 문자의 순서만 다른 형태라는 것을 의미
//        String str1 = "abcdefg";
//        String str2 = "gfdebca";
//        String str3 = "hi yohan";
//        String str4 = "yohan hi";
//        String str5 = "helolo";
//        String str6 = "lleohe";
//
//        boolean result1 = checkPermutation(str1, str2);
//        boolean result2 = checkPermutation(str3, str4);
//        boolean result3 = checkPermutation(str5, str6);
//        System.out.println("result1 = " + result1); //true
//        System.out.println("result2 = " + result2); //true
//        System.out.println("result3 = " + result3); //false

//        //3. URL화
//        //문자열 공백을 %20으로 바꾸기
//        String str = "Mr John Smith";
//        String result = toURL(str);
//        System.out.println("result = " + result);

//        //4. 회문 순열인지 판단
//        //대소문자 구분 안함. 공백 무시. 입력 String, 출력 boolean
//        //Tact Coa -> tacocat -> true
//        //Colalao -> alocola -> true
//        //Cola -> false
//        //홀수번 등장하는 문자가 한 개 이하이면된다.
//        String str1 = "Tact Coa";
//        String str2 = "Colalao";
//        String str3 = "Cola";
//        for (String str : List.of(str1, str2, str3)) {
//            boolean result = checkPalindrome(str);
//            System.out.println("result = " + result);
//        }

//        //5. 하나 빼기
//        //두 문자열이 주어졌을 때, 같게 만들기 위한 편집 횟수가 1회 이하인지 확인
//        //편집 : 문자 삽입, 삭제, 교체
//
//        //1. 길이 차이 1이하인지 체크. 같을 때, 다를 때 다르게 행동. stack = 0을 만들고, 1까지만 가능
//        //2. 같을 경우, 다른 문자인 경우 1번만 넘어간다.
//        //3. 다를 경우, 긴 쪽 index만 한 번 넘긴다.
//        //O(n)
//        String[][] input = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"}, {"pale", "bake"}};
//        for (String[] strings : input) {
//            boolean result = isOneDiff(strings[0], strings[1]);
//            System.out.println("result = " + result);
//        }

//        //6. 문자열 압축
//        //반복된 문자를 숫자로 변환한다.
//        //기존 문자열 보다 길다면 기존 문자열을 반환
//        //aabccccaaa -> a2b1c4a3
//        //abcd -> abcd
//        for (String str: List.of("aabccccaaa", "abcd")) {
//            String result = changeStr(str);
//            System.out.println("result = " + result);
//        }

//        //7. 행렬 돌리기
//        //int[][] n * n
//        //i, j ->  j, n-i-1
//        int[][] input = {{1,2,3,4}, {5,6,7,8}, {1,2,3,4}, {5,6,7,8}};
//        int[][] result = rotate(rotate(rotate(rotate(input))));
//        for (int[] ints : result) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        //8. 행렬 0
//        //n*m int[][]의 한 원소가 0일 때, 해당 원소의 가로, 세로를 0으로 만들기
//        int[][] input = {{1,2,3,4}, {5,6,0,8}, {1,2,3,4}, {5,6,7,8}, {5,6,7,8}};
//        int[][] result = changeToZero(input);
//        for (int[] ints : result) {
//            for (int i : ints) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

//        //9. 문자열 회전
//        //isSubstring : 한 단어가 다른 문자열에 포함되어 있는지 판별
//        //두 문자열이 주어졌을 때, s2가 s1을 회전시켜서 만들 수 있는지 판별할 것.
//        //단, isSubstring을 한 번만 사용해서 구현
//        boolean result = checkRotate("waterbottle", "erbottlewat");
//        System.out.println("result = " + result);
//        "aaa".contains("aa");
    }

//    private boolean checkRotate(String s1, String s2) {
//        //시간복잡도 : O(n + isSubstring(n*mx) )
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//
//        String doubleS1 = s1 + s1;
//        return isSubstring(s2, doubleS1);
//    }


    private int[][] changeToZero(int[][] input) {

        //방법
        //1. 먼저 0을 찾고, 가로, 세로 바꿔준다. 최악 : O(n*m), 최적: O(n+m) 0이 빨리 발견될 때, 최적

        int n = input.length;
        int m = input[0].length;
        int[] zero = searchZero(input);

        for (int i = 0; i < n; i++) {
            input[i][zero[1]] = 0;
        }
        for (int i = 0; i < m; i++) {
            input[zero[0]][i] = 0;
        }

        return input;
    }

    private int[] searchZero(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    private int[][] rotate(int[][] input) {
        //방법
        //1. 새 배열을 만들고, i, j ->  j, n-i-1 로 집어 넣어준다.
        //2. 배열을 추가로 사용하지 않고, 4개 씩 묶어서 처리. visited를 사용해 중복 방지

        //2번 방법
        int n = input.length;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                rotateSmall(input, i, j, visited, input[i][j]);
            }
        }

        return input;
    }

    private void rotateSmall(int[][] input, int i, int j, boolean[][] visited, int value) {
        int targetX = j;
        int targetY = input.length - i - 1;

        if (visited[targetX][targetY]) {
            return;
        }


        visited[targetX][targetY] = true;
        int newValue = input[targetX][targetY];
        input[targetX][targetY] = value;
        rotateSmall(input, targetX, targetY, visited, newValue);

    }

    private String changeStr(String str) {
        //방법
        //1. 문자를 쭉 돌면서, result에 바로바로 추가해준다. O(n)
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = '0';
        for (char c : str.toCharArray()) {
            if (c == prev) {
                count++;
                continue;
            }

            if (count != 0) {
                sb.append(count);
            }
            count = 1;
            prev = c;
            sb.append(c);
        }
        sb.append(count);

        if (sb.length() > str.length()) return str;

        return sb.toString();
    }

    private boolean isOneDiff(String s1, String s2) {

        int length1 = s1.length();
        int length2 = s2.length();
        if (Math.abs(length1 - length2) > 1) {
            return false;
        }

        if (length1 == length2) {
            int stack = 0;

            for (int i = 0; i < length1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    stack++;
                }
            }
            if (stack > 1) {
                return false;
            }
            return true;
        }

        String small = "";
        String big = "";
        if (length1 < length2) {
            small = s1;
            big = s2;
        } else {
            small = s2;
            big = s1;
        }

        int stack = 0;
        for (int i = 0; i < small.length(); i++) {
            if (stack > 1) {
                return false;
            }
            if (small.charAt(i) != big.charAt(i + stack)) {
                stack++;
            }
        }

        return true;
    }

    private boolean checkPalindrome(String str) {
        //1. map으로 count 세서, 홀수개인 문자 개수 세기 O(n)

        Map<Character, Integer> counts = new HashMap<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == ' ') {
                continue;
            }
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        System.out.println(counts);

        long count = counts.values().stream()
                .filter(x -> x % 2 == 1)
                .count();
        if (count > 1) {
            return false;
        }
        return true;
    }

    private String toURL(String str) {

        //방법
        //1. String 배열을 만들고, 한 글자씩 넣으면서, 공백처리해준다.
        //2. chars를 공백 만날때마다 %20넣고, 뒤로 민다.

        char[] chars = str.toCharArray();

//        //1번 방법
//        StringBuilder sb = new StringBuilder();
//        for (char c : chars) {
//            if (c == ' ') {
//                sb.append("%20");
//                continue;
//            }
//            sb.append(c);
//        }
//
//        return sb.toString();

        //2번 방법
        //index--
        //size
        char[] save = new char[200];
        for (int i = 0; i < chars.length; i++) {
            save[i] = chars[i];
        }

        int size = chars.length;
        int index = chars.length - 1;
        while (index >= 0) {
            if (save[index] == ' ') {
                //index+1 부터 size-1를 각 +2 자리에 넣기
                for (int i = size - 1; i >= index+1; i--) {
                    save[i+2] = save[i];
                }
                save[index] = '%';
                save[index+1] = '2';
                save[index+2] = '0';
                size += 2;
            }
            index--;
        }

        return new String(save, 0, size);
    }


    private boolean checkPermutation(String str1, String str2) {
        //문자열의 길이가 같아야함
        //사용한 문자가 같아야함
        //각 문자의 갯수가 같아야함
        //하지만, 같은 문자열이면 안된다.

        //방법
        //1. ascii를 index로 count를 센다. O(n)
        //2. 정렬 후 탐색 O(nlogn)

        //1번 방법

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] counts1 = new int[255];
        int[] counts2 = new int[255];
        boolean isSame = true;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                isSame = false;
            }
            counts1[str1.charAt(i)]++;
            counts2[str2.charAt(i)]++;
        }
        if (isSame) {
            return false;
        }

        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }

        return true;
    }

    //중복된 문자 등장 시 false, 이외 true
    private boolean checkDuplicate(String str) {

        //1. map으로 count - O(n)
        //2. 하나의 문자마다 뒷부분 탐색 - O(n^2)
        //3. 문자로 정렬 후 확인 - O(nlogn)
        //4. Set에 추가 후 길이 줄었는지 확인 - O(n)
        //5. 배열 만들고, ascii를 인덱스로, count 세준다. O(n)

        //5번 방법
        int[] counts = new int['z' + 1];
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (counts[cur] > 0) {
                return false;
            }
            counts[cur]++;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
