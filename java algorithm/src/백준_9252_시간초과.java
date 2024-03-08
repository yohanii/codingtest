import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_9252_시간초과 {

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

        String result = search(0, 0, "");
        System.out.println(result.length());
        System.out.println(result);
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

    private String search(int firstIndex, int secondIndex, String words) {
//        System.out.println("search : " + firstIndex + " " + secondIndex + " " + words);
        if (firstIndex >= first.length() || secondIndex >= second.length()) {
            return words;
        }

        //findIndex = (second.charAt(secondIndex)의 위치 중 firstIndex보다 크거나 같은 것 중 가장 작은 것)
        int findIndex = find(firstIndex, secondIndex);
//        System.out.println("findIndex = " + findIndex);
        if (findIndex == -1) {
            return search(firstIndex, secondIndex + 1, words);
        }

        //선택
        String select = search(findIndex + 1, secondIndex + 1, words + second.charAt(secondIndex));
//        System.out.println("select = " + select);
        //선택X
        String unSelect = search(firstIndex, secondIndex + 1, words);
//        System.out.println("unSelect = " + unSelect);

        //길이 더 긴 쪽 선택
        String choiceResult = choice(select, unSelect);
//        System.out.println("choiceResult = " + choiceResult);
        return choiceResult;
    }

    private String choice(String select, String unSelect) {
        if (select.length() >= unSelect.length()) {
            return select;
        }
        return unSelect;
    }

    //못 찾을 시 -1
//    private int find(int firstIndex, int secondIndex) {
//        char word = second.charAt(secondIndex);
//        for (int i = firstIndex; i < first.length(); i++) {
//            if (first.charAt(i) == word) {
//                return i;
//            }
//        }
//        return -1;
//    }

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
