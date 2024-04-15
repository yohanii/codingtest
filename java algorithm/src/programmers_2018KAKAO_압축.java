import java.util.*;

public class programmers_2018KAKAO_압축 {
    class Solution {
        public int[] solution(String msg) {

            //47:38
            int lastIndex = 27;
            //word - index
            Map<String, Integer> dict = new HashMap<>();
            //dict에 문자 추가
            for (int i = 0 ;i < 26; i++) {
                dict.put("" + (char)('A'+i), i+1);
            }
            System.out.println(dict);

            //1. msg for문 돌기
            //2. word + 선택된 char 가 map에 있는지 체크하면서 제일 긴 거 가져오기 + 출력
            //3. 사전 등록
            //4. 2~3반복
            List<Integer> result = new ArrayList<>();
            int cur = 0;
            while (cur < msg.length()) {
                String word = "";
                int index = cur;

                while (index < msg.length()) {
                    word += msg.charAt(index);
                    if (!dict.containsKey(word)) {
                        break;
                    }
                    index++;
                }

                if (!dict.containsKey(word)) {
                    //단어 추가
                    dict.put(word, lastIndex++);
                }

                if (index >= msg.length()) {
                    result.add(dict.get(word));
                    cur += word.length();
                    continue;
                }

                result.add(dict.get(word.substring(0, word.length()-1)));
                cur += word.length() - 1;
                // System.out.println(dict);
            }


            return result.stream().mapToInt(Integer::valueOf).toArray();
            // return new int[1];
        }
    }
}
