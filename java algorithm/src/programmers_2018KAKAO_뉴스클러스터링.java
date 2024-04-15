import java.util.*;

public class programmers_2018KAKAO_뉴스클러스터링 {

    class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;

            //1. 두 글자씩 끊어서 다중집합 2개를 만든다.
            //1-1. toLowerCase()
            //1-2. 아스키 'a' < ~ < 'z'에 들어있는지 체크
            //2. 두 집합을 합친 set을 만든다.
            //3. 각 str에 대한 map을 돌면서, 합집합 count, 교집합 count를 구한다.
            //4. 자카드 값 구하고, 답을 구한다.

            List<String> list1 = getWords(str1);
            List<String> list2 = getWords(str2);
            System.out.println(list1);
            System.out.println(list2);

            int result = getJacade(list1, list2);
            System.out.println(result);
            return result;
        }

        private int getJacade(List<String> list1, List<String> list2) {
            Set<String> keys = new HashSet<>(list1);
            keys.addAll(list2);
            System.out.println("keys: " + keys);

            Map<String, Integer> count1 = new HashMap<>();
            Map<String, Integer> count2 = new HashMap<>();

            for (String word: list1) {
                count1.put(word, count1.getOrDefault(word, 0) + 1);
            }
            for (String word: list2) {
                count2.put(word, count2.getOrDefault(word, 0) + 1);
            }
            System.out.println("count1: " + count1);
            System.out.println("count2: " + count2);

            int intersection = 0;
            int union = 0;
            for (String k: keys) {
                int v1 = count1.getOrDefault(k, 0);
                int v2 = count2.getOrDefault(k, 0);

                intersection += Math.min(v1, v2);
                union += Math.max(v1, v2);
            }
            System.out.println("intersection: " + intersection);
            System.out.println("union: " + union);

            if (union == 0) {
                return 65536;
            }

            return intersection * 65536 / union;
        }

        private List<String> getWords(String str) {
            List<String> list = new ArrayList<>();
            String lowerStr = str.toLowerCase();
            for (int i = 0; i < str.length() - 1; i++) {
                char char1 = lowerStr.charAt(i);
                char char2 = lowerStr.charAt(i + 1);

                if ('a' <= char1 && char1 <= 'z' && 'a' <= char2 && char2 <= 'z') {
                    list.add("" + char1 + char2);
                }
            }
            return list;
        }
    }
}
