import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static String[] string1, string2;
    static List<List<Integer>> sequences;

    static List<List<Integer>> addLists;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        string1 = br.readLine().split("");
        string2 = br.readLine().split("");

        //str2 한번씩 돌면서
        //1. str1에 자기 문자 위치들 찾기
        //2. 수열 리스트들에 넣을 수 있으면 넣고, 없으면 수열 리스트 만들기
        //다 돌면 제일 긴 수열 리스트 출력
        sequences = new ArrayList<>();
        makeSequences();

        int maxSize = Integer.MIN_VALUE;
        List<Integer> maxSequence = null;
        for (List<Integer> sequence : sequences) {
            if (sequence.size() > maxSize) {
                maxSize = sequence.size();
                maxSequence = sequence;
            }
        }
        System.out.println(maxSize);
        for (Integer i : maxSequence) {
            System.out.print(string1[i]);
        }
    }

    private void makeSequences() {
        for (int index = 0; index < string2.length; index++) {
            String cur = string2[index];
            List<Integer> indexs = new ArrayList<>();
            for (int i = 0; i < string1.length; i++) {
                if (string1[i].equals(cur)) {
                    indexs.add(i);
                }
            }

//            System.out.println("cur = " + cur);
//            System.out.println("indexs = " + indexs);

            if (indexs.isEmpty()) {
                continue;
            }

            addLists = new ArrayList<>();
            for (List<Integer> sequence : sequences) {
                addToSequence(sequence, indexs);
            }
            sequences.addAll(addLists);
            sequences.add(new ArrayList<>(List.of(indexs.get(0))));
        }
    }

    private static void addToSequence(List<Integer> sequence, List<Integer> indexs) {
        if (sequence.isEmpty()) {
            return;
        }

        Integer maxIndex = sequence.get(sequence.size() - 1);
        for (Integer i : indexs) {
            if (i > maxIndex) {
                sequence.add(i);
                return;
            } else {
                List<Integer> collect = sequence.stream()
                        .filter(elem -> elem < i)
                        .collect(Collectors.toList());
                collect.add(i);
                addLists.add(collect);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
