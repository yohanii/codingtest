import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 코딩인터뷰준비 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //1. Reverse Integer
        //# Given an integer, return the integer with reversed digits.
        //# Note: The integer could be either positive or negative.
        //ex) 123 -> 321 / -123 -> -321 / 1,000,000,009 -> -1
        List<Integer> input1 = List.of(123, -123, 1_000_000_009, Integer.MAX_VALUE, Integer.MIN_VALUE);
        for (Integer i : input1) {
//            Integer result = reverseInteger(i);
//            System.out.println("result = " + result);
        }

        //2. 평균 단어 길이
        //# For a given sentence, return the average word length.
        //# Note: Remember to remove punctuation first.
        String sentence1 = "Hi all, my name is Tom,,,I am originally from Australia.";
        String sentence2 = "I need to work very hard to learn more about algorithms in Python!";
        List<String> input2 = List.of(sentence1, sentence2);
        for (String s : input2) {
//            double result = getAvg(s);
//            System.out.printf("result = %.2f\n", result);
        }

        //3. Add String
        //# Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
        //# You must not use any built-in BigInteger library or convert the inputs to integer directly.
        //#Notes:
        //#Both num1 and num2 contains only digits 0-9.
        //#Both num1 and num2 does not contain any leading zero.
        //num1 = ‘364’
        //num2 = ‘1836’

        //1. 두 수를 String -> Integer 변환
        //2. 더해서 반환
        List<List<String>> input = List.of(List.of("123", "4567"), List.of("1", "2"), List.of("2000", "0"));

        for (List<String> strings : input) {
//            int sum = getSum(strings.get(0), strings.get(1));
//            System.out.println("sum = " + sum);
        }

        //4. First Unique Character
        //# Given a string, find the first non-repeating character in it and return its index.
        //# If it doesn’t exist, return -1. # Note: all the input strings are already lowercase.
        //ex) abcdabc -> 3 / abcddbcda -> -1

        //1. 한번 돌면서, Set에 char 포함했는지 체크
        //2. 포함X -> set에 추가 / 포함O -> repeatSet에 추가
        //3. 다시 한번 돌면서, repeatSet에 포함되어있지 않은 char의 index를 반환합니다.
        List<String> input4 = List.of("abcdabc", "abcddbcda");
        for (String s : input4) {
//            int result = getFirstUniqueCharIndex(s);
//            System.out.println("result = " + result);
        }

        //5. Valid Palindrome
        //# Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
        //# The string will only contain lowercase characters a-z.
        //ex) abcddcba -> true, abcddcbba -> true, abcddcdcba -> true, abdcddcdcba -> true, abddcddcdcba -> false

        //완전탐색
        //1. 팰린드롬 체크
        //2. 하나씩 지워가면서 팰린드롬 체크

        //1. 양쪽 끝의 투포인터를 잡고, 둘 다 안쪽으로 한칸씩 땡겨오면서, 두 character가 다를때까지 움직입니다. -> 계속 이상없으면 true
        //2. 다른 지점이 발생하면, 왼쪽, 오른쪽 각각 한 문자씩 없애고, 팰린드롬인지 체크합니다. -> 둘 중 하나 true이면 true -> or
        List<String> input5 = List.of("abcddcba", "abcddcbba", "abcddcdcba", "abdcddcdcba", "abddcddcdcba");
        for (String s : input5) {
//            boolean result = judgePal(s);
//            System.out.println("result = " + result);
        }

        //6. Monotonic Array
        //# Given an array of integers, determine whether the array is monotonic or not.
        //A = [6, 5, 4, 4] -> true
        //B = [1,1,1,3,3,4,3,2,4,2] -> false
        //C = [1,1,2,3,7] -> true
        int[] A = {6, 5, 4, 4};
        int[] B = {1,1,1,3,3,4,3,2,4,2};
        int[] C = {1,1,2,3,7};

        //증가 또는 감소
        //1. length 0, 1, 2이면 true
        //2. index 0 1 로 증가 또는 감소인지 판단 isPlus
        //3. isPlus에 위반되면 false, 끝까지 이상없으면 true
        List<int[]> input6 = List.of(A, B, C);
        for (int[] ints : input6) {
//            boolean result = isMonotinic(ints);
//            System.out.println("result = " + result);
        }

        //7. Move Zeroes
        //#Given an array nums, write a function to move all zeroes to the end of it while maintaining the relative order of
        //#the non-zero elements.
        int[] array1 = {0,1,0,3,12};
        int[] array2 = {1,7,0,0,8,0,10,12,0,4};

        //1. 새로운 배열 만든다.
        //2. 0이 아닌 원소만 앞에서부터 채운다.
        List<int[]> input7 = List.of(array1, array2);
        for (int[] ints : input7) {
//            int[] result = moveZero(ints);
//            for (int i : result) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
        }

        //8. Fill The Blanks
        //# Given an array containing None values fill in the None values with most recent
        //# non None value in the array
        //array1 = [1,None,2,3,None,None,5,None]
        //1. 한번 돌면서, None 아닌 값이면 저장해두고, None이면 저장해둔 값을 대신 넣어준다.

        //9. Matched & Mismatched Words
        //#Given two sentences, return an array that has the words that appear in one sentence and not
        //#the other and an array with the words in common.
        String s1 = "We are really pleased to meet you in in our city";
        String s2 = "The city was hit by a really heavy storm storm";

        //1. map : word - count를 만들어 문장마다 한번씩 돌면서 저장한다.
        //2. map의 key값 돌면서, count == 1인 것, 아닌 것 나눠서 반환
//        List<List<String>> result = getWords(s1, s2);
//        System.out.println("result = " + result);


        //10. Prime Numbers Array
        //# Given k numbers which are less than n, return the set of prime number among them
        //# Note: The task is to write a program to print all Prime numbers in an Interval.
        //# Definition: A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
        //n = 35

        //k개 숫자 중 소수이며 중복된 값이 있을 수 있는데, 출력에 중복된 모든 수 출력하나? yes
        //n과 k 범위? Integer

        //1. n 보다 작은 소수를 모두 set에 저장
        //2. k개 숫자 돌면서 set에 포함되어있는지 체크
        //k가 작으면 비효율적임, k의 최댓값 작으면 비효율적임, n이 아주 크면 비효율적암


        //소수판별 : x^(1/2)보다 작은 수로 나눠보면서 체크 O(n^(1/2))
        //1. k개 수 돌면서 직접 소수 판별 -> O(n^(3/2))

        //1. n보다 작은 모든 수 소수 판별 -> 에라토스테네스의 체 O(nlog(logn))
        //2. k개 수 돌면서 체크 -> O(n)
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 10, 11, 13, 15, 19, 20, 25, 30, 31);
        int n = 35;
//        Set<Integer> result = getPrimes(nums, n);
//        System.out.println("result = " + result);

    }

    private Set<Integer> getPrimes(List<Integer> nums, int n) {

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i*i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = 2*i; j < n; j+=i) {
                isPrime[j] = false;
            }
        }

        Set<Integer> result = new HashSet<>();
        for (Integer num : nums) {
            if (isPrime[num]) {
                result.add(num);
            }
        }
        return result;
    }

    private List<List<String>> getWords(String s1, String s2) {
        Map<String, Integer> wordCounts = new HashMap<>();
        Set<String> set1 = Arrays.stream(s1.split(" ")).collect(Collectors.toSet());
        Set<String> set2 = Arrays.stream(s2.split(" ")).collect(Collectors.toSet());

        for (String s : set1) {
            wordCounts.put(s, wordCounts.getOrDefault(s, 0) + 1);
        }

        for (String s : set2) {
            wordCounts.put(s, wordCounts.getOrDefault(s, 0) + 1);
        }

        List<String> one = new ArrayList<>();
        List<String> duplicate = new ArrayList<>();

        for (String s : wordCounts.keySet()) {
            if (wordCounts.get(s) > 1) {
                duplicate.add(s);
                continue;
            }
            one.add(s);
        }

        return List.of(one, duplicate);

    }

    private int[] moveZero(int[] arr) {
        int[] result = new int[arr.length];

        int index = 0;
        for (int i : arr) {
            if (i != 0) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }

    private boolean isMonotinic(int[] arr) {
        //1. length 0, 1, 2이면 true
        //2. index 0 1 로 증가 또는 감소인지 판단 isPlus
        //3. isPlus에 위반되면 false, 끝까지 이상없으면 true
//        if (arr.length <= 2) {
//            return true;
//        }
//
//        boolean isPlus = true;
//        if (arr[0] > arr[1]) {
//            isPlus = false;
//        }
//
//        for (int i = 1; i < arr.length - 1; i++) {
//            if (isPlus) {
//                if (arr[i] > arr[i+1]) {
//                    return false;
//                }
//                continue;
//            }
//            if (arr[i] < arr[i+1]) {
//                return false;
//            }
//        }
//        return true;

        return IntStream.range(0, arr.length - 1)
                .allMatch(i -> arr[i] <= arr[i+1])
                || IntStream.range(0, arr.length - 1)
                .allMatch(i -> arr[i] >= arr[i+1]);
    }

    private boolean judgePal(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return checkPal(str.substring(start + 1, end + 1)) || checkPal(str.substring(start, end));
            }

            start++;
            end--;
        }
        return true;
    }

    private boolean checkPal(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int getFirstUniqueCharIndex(String str) {

        Set<Character> appear = new HashSet<>();
        Set<Character> repeat = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (appear.contains(cur)) {
                repeat.add(cur);
                continue;
            }
            appear.add(cur);
        }
        System.out.println("appear = " + appear);
        System.out.println("repeat = " + repeat);

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (!repeat.contains(cur)) {
                return i;
            }
        }
        return -1;
    }

    private int getSum(String s1, String s2) {
        return Integer.parseInt(s1) + Integer.parseInt(s2);
    }

    private double getAvg(String str) {
        //1. 특수문자를 공백으로 replace
        //2. 단어길이 계산
        String replaced = str.replaceAll("[.,/;'<>?:!@#$%^&*()_+-=]", " ");
        System.out.println("replaced = " + replaced);
        String[] split = replaced.split("\\s+");
        System.out.println("split = " + Arrays.toString(split));
        int count = 0;
        int totalSum = 0;
        for (String s : split) {
            count++;
            totalSum += s.length();
        }
        return totalSum / (double) count;

        //1. split에 특수문자들 넣기
        //2. 길이 0인 string 제외하고, 길이 구하기
//        String[] split = str.split("[.,/;'<>?:!@#$%^&*()_+-= ]");
//        System.out.println("split = " + Arrays.toString(split));
//        int count = 0;
//        int totalSum = 0;
//        for (String s : split) {
//            int length = s.trim().length();
//            if (length > 0) {
////                System.out.println("s, length = " + s + ", " + length);
//
//                count++;
//                totalSum += length;
//            }
//        }
//        return totalSum / (double) count;
    }

    private Integer reverseInteger(Integer num) {
        //0. 마이너스 빼놓기
        //1. Integer -> String
        //2. reverse
        //3. String -> Long
        //4. 범위 초과 체크 후 Long -> Integer
        boolean isMinus = false;
        if (num < 0) {
            isMinus = true;
        }

        String str = "";
        if (isMinus) {
            str = num.toString().substring(1);
        } else {
            str = num.toString();
        }

        String newStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr += str.charAt(i);
        }
        System.out.println("newStr = " + newStr);

        if (isMinus) {
            newStr = "-" + newStr;
        }

        long value = Long.parseLong(newStr);
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return -1;
        }
        return (int) value;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
