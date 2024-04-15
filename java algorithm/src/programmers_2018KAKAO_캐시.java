import java.util.*;

public class programmers_2018KAKAO_캐시 {

    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            //cache : map (도시 - 실행한 index)
            //cacheSize < Max CacheSize : cache에 추가만
            //cacheSize == Max CacheSize : 실행한 index 가장 작은 값 제거 + 새로운 값 추가

            //1. cities 돌면서, city 이름 가져온다.
            //2. cache에 key로 들어가 있는지 체크
            //3. 체크 여부에 따라 행동 : 있으면 +1 / 없으면 추가하고 +5
            //4. 없을 때, 현재 캐시 사이즈 확인하고, 행동

            Map<String, Integer> cache = new HashMap<>();
            for (int i = 0; i < cities.length; i++) {
                if (cache.containsKey(cities[i].toLowerCase())) {
                    cache.put(cities[i].toLowerCase(), i);
                    answer++;
                    continue;
                }

                if (cacheSize == 0) {
                    answer += 5;
                    continue;
                }

                if (cache.keySet().size() >= cacheSize) {
                    //remove old
                    removeOld(cache);
                    // System.out.println("max");
                }
                cache.put(cities[i].toLowerCase(), i);
                // System.out.println(cache);
                answer += 5;
            }

            return answer;
        }

        private void removeOld(Map<String, Integer> cache) {

            List<Integer> values = new ArrayList<>(cache.values());
            Collections.sort(values);
            int minIndex = values.get(0);

            String removeKey = "";
            for (String key: cache.keySet()) {
                if (cache.get(key) == minIndex) {
                    removeKey = key;
                }
            }
            cache.remove(removeKey);
        }
    }
}
