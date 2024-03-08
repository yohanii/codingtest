import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_9252_메모리초과 {

    static String first, second;
    static Map<Character, List<Integer>> map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //recursive
        //last index와 선택된 수열 parameter
        //끝나면 수열 길이 반환
        first = br.readLine();
        second = br.readLine();

        //find에 걸리는 시간 줄이기 위해
        //second word들의 first index값 map에 저장
        map = new HashMap<>();
        saveMap(first, second, map);
//        System.out.println(map);

        Map<Character, Integer> visited = new HashMap<>();
        List<Word> words = new ArrayList<>();
        for (int i = 0; i < second.length(); i++) {
            visited.put(second.charAt(i), visited.getOrDefault(second.charAt(i), 0) + 1);
            int firstIndex = find(0, i);
            boolean status = true;

            List<Word> addWords = new ArrayList<>();
            for (Word word : words) {
                int findIndex = find(word.lastIndex + 1, i);
                if (findIndex == -1) {
                    continue;
                }

//                System.out.println("findIndex = " + findIndex);
//                System.out.println("firstIndex = " + firstIndex);
                if (findIndex < firstIndex) {
                    status = false;
                }

                if (findIndex == word.lastIndex + 1) {
                    word.lastIndex = findIndex;
                    word.str += second.charAt(i);
                    continue;
                }
                addWords.add(new Word(findIndex, word.str + second.charAt(i)));
            }

            words.addAll(addWords);
            if (visited.get(second.charAt(i)) <= 1 && status) {
                words.add(new Word(firstIndex, "" + second.charAt(i)));
            }
//            System.out.println("words = " + words);
        }


        int maxLength = 0;
        String maxString = "";
        for (Word word : words) {
            if (word.str.length() > maxLength) {
                maxLength = word.str.length();
                maxString = word.str;
            }
        }
        System.out.println(maxLength);
        System.out.println(maxString);

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

    private int find(int firstIndex, int secondIndex) {
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
