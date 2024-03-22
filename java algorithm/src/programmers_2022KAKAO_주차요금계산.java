import java.util.*;

public class programmers_2022KAKAO_주차요금계산 {
    class Solution {
        public int[] solution(int[] fees, String[] records) {

            //풀이시간 : 47m 40s

            //fees : [180, 5000, 10, 600]
            //records : ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
            //result : [14600, 34400, 5000]

            //1. 차량 번호별로 누적 주차 시간 구하기
            Map<String, Integer> times = getTimes(records);
            //2. 각 차 마다 주차 요금 구하기
            Map<Integer, Integer> prices = getPrices(times, fees);
            //3. 차량번호 오름차순으로 출력
            return getResult(prices);
        }

        private Map<String, Integer> getTimes(String[] records) {
            Map<String, Integer> result = new HashMap<>();
            Map<String, String> park = new HashMap<>();

            for (String record: records) {
                StringTokenizer st = new StringTokenizer(record);
                String time = st.nextToken();
                String car = st.nextToken();
                String status = st.nextToken();

                // System.out.println(time);
                // System.out.println(car);
                // System.out.println(status);

                if (status.equals("IN")) {
                    park.put(car, time);
                } else {
                    //OUT
                    int gap = getGap(park.get(car), time);
                    park.remove(car);
                    result.put(car, result.getOrDefault(car, 0) + gap);
                    // System.out.println(result);
                }
            }

            if (!park.isEmpty()) {
                for (String car: park.keySet()) {
                    int gap = getGap(park.get(car), "23:59");
                    result.put(car, result.getOrDefault(car, 0) + gap);
                }
            }

            System.out.println(park);
            System.out.println(result);

            return result;
        }

        private int getGap(String in, String out) {
            return changeTimeToMin(out) - changeTimeToMin(in);
        }

        private int changeTimeToMin(String time) {
            String[] elems = time.split(":");
            return Integer.parseInt(elems[0]) * 60 + Integer.parseInt(elems[1]);
        }

        private Map<Integer, Integer> getPrices(Map<String, Integer> times, int[] fees) {
            Map<Integer, Integer> result = new HashMap<>();

            for (String car: times.keySet()) {
                result.put(Integer.parseInt(car), calculatePrice(times.get(car), fees));
            }
            System.out.println(result);
            return result;
        }

        private int calculatePrice(int time, int[] fees) {
            int minTime = fees[0];
            int minPrice = fees[1];
            int unitTime = fees[2];
            int unitPrice = fees[3];

            if (time <= minTime) {
                return minPrice;
            }

            return (int) Math.ceil((time - minTime) / (double) unitTime) * unitPrice + minPrice;
        }

        private int[] getResult(Map<Integer, Integer> prices) {
            List<Integer> keys = new ArrayList<>(prices.keySet());
            Collections.sort(keys);

            int[] result = new int[keys.size()];
            for (int i = 0; i < keys.size(); i++) {
                result[i] = prices.get(keys.get(i));
            }
            return result;
        }
    }
}
