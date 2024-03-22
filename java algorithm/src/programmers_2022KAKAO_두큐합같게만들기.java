import java.util.*;
public class programmers_2022KAKAO_두큐합같게만들기 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {

            //총 합 구하고, goal 구하기
            long totalSum = getTotal(queue1, queue2);
            if (totalSum % 2 == 1) {
                return -1;
            }
            long goal = totalSum / 2;
            // System.out.println(goal);

            //이중포인터 사용해서, 찾기
            return getResult(goal, queue1, queue2);
        }

        private Long getTotal(int[] queue1, int[] queue2) {
            long result = 0L;

            for (int elem: queue1) {
                result += elem;
            }

            for (int elem: queue2) {
                result += elem;
            }
            return result;
        }

        private int getResult(long goal, int[] queue1, int[] queue2) {
            List<Integer> list = new ArrayList<>();
            long sum = 0;
            int count = 0;

            for (int elem: queue1) {
                list.add(elem);
                sum += elem;
            }
            for (int elem: queue2) {
                list.add(elem);
            }
            for (int elem: queue1) {
                list.add(elem);
            }
            // System.out.println(list);

            int p1 = 0;
            int p2 = queue1.length - 1;
            // System.out.println(p2);
            // System.out.println(sum);


            while (true) {
                if (sum == goal || p1 > p2 || p2 >= list.size() || p2 - p1 >= queue1.length + queue2.length) {
                    break;
                }

                count++;
                if (sum < goal) {
                    p2++;
                    if (p2 < list.size()) {
                        sum += list.get(p2);
                    }
                    continue;
                }

                sum -= list.get(p1);
                p1++;
            }
            // System.out.println(p1);
            // System.out.println(p2);
            if (sum != goal) {
                return -1;
            }

            return count;
        }
    }
}
