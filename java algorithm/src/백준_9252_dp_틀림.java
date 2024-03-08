import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_9252_dp_틀림 {

    static Map<Character, List<Integer>> map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //recursive
        //last index와 선택된 수열 parameter
        //끝나면 수열 길이 반환
        String first = br.readLine();
        String second = br.readLine();

        String result1 = getResult(first, second);
        String result2 = getResult(second, first);
//        System.out.println("result1 = " + result1);
//        System.out.println("result2 = " + result2);

        if (result1.length() >= result2.length()) {
            System.out.println(result1.length());
            System.out.println(result1);
            return;
        }
        System.out.println(result2.length());
        System.out.println(result2);


    }

    private String getResult(String first, String second) {
        //find에 걸리는 시간 줄이기 위해
        //second word들의 first index값 map에 저장
        map = new HashMap<>();
        saveMap(first, second, map);
//        System.out.println(map);

        Map<Character, Word> dp = new HashMap<>();
        for (int i = 0; i < second.length(); i++) {
            char secondChar = second.charAt(i);

            //dp 돌면서 secondChar이 붙을 수 있는 것 중 가장 긴 것 골라서, Word 업데이트
            //붙을 수 있는 것 아무것도 없을 시 한 문자 put
            int maxLength = 0;
            String maxString = "";
            int maxIndex = -1;
            for (Character c : dp.keySet()) {
                Word word = dp.get(c);
                int lastIndex = word.lastIndex;
                String wordStr = word.str;

                if (wordStr.length() + 1 <= maxLength) {
                    continue;
                }

                int findIndex = find(lastIndex + 1, i, second);
                if (findIndex == -1) {
                    continue;
                }

                maxLength = wordStr.length() + 1;
                maxString = wordStr + secondChar;
                maxIndex = findIndex;
            }

            if (maxLength == 0) {
                if (!dp.containsKey(secondChar)) {
                    dp.put(secondChar, new Word(find(0, i, second), "" + secondChar));
//                    System.out.println(dp);
                    continue;
                } else {
//                    System.out.println(dp);
                    continue;
                }
            }

            dp.put(secondChar, new Word(maxIndex, maxString));
//            System.out.println(dp);
        }

        String result = dp.values().stream()
                .map(w -> w.str)
                .max(Comparator.comparingInt(String::length))
                .get();
        return result;
    }

    class Word {
        int lastIndex;
        String str;

        public Word(int lastIndex, String str) {
            this.lastIndex = lastIndex;
            this.str = str;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "lastIndex=" + lastIndex +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

    private void saveMap(String first, String second, Map<Character, List<Integer>> map) {
        for (int i = 0; i < second.length(); i++) {
            char word = second.charAt(i);
            if (map.containsKey(word)) {
                continue;
            }

            List<Integer> indexs = new ArrayList<>();
            for (int j = 0; j < first.length(); j++) {
                if (first.charAt(j) == word) {
                    indexs.add(j);
                }
            }
            map.put(word, indexs);
        }
    }

    private int find(int firstIndex, int secondIndex, String second) {
        char word = second.charAt(secondIndex);
        List<Integer> indexs = map.get(word);
        for (Integer index : indexs) {
            if (index >= firstIndex) {
                return index;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
