import java.util.*;

public class programmers_2024KAKAO_가장많이받은선물 {

    class Solution {
        public int solution(String[] friends, String[] gifts) {

            Map<String, Integer> indexs = getIndexs(friends);
            System.out.println(indexs);
            //1. gifts 돌면서, 선물지수 구하기 + 서로 몇 개씩 주고받았는지 배열 만들기
            int[] score = new int[friends.length];
            int[][] view = new int[friends.length][friends.length];
            for (String gift: gifts) {
                String[] spl = gift.split(" ");
                int giver = indexs.get(spl[0]);
                int receiver = indexs.get(spl[1]);

                score[giver]++;
                score[receiver]--;
                view[giver][receiver]++;
            }

            System.out.println("score");
            for (int i: score) {
                System.out.print(i + " ");
            }
            System.out.println();

            System.out.println("view");
            for (int[] ints: view) {
                for (int i: ints) {
                    System.out.print(i + " ");

                }
                System.out.println();

            }


            //2. friends 돌면서, 다음달 선물 개수 구하기
            int[] result = new int[friends.length];
            for (int i = 0 ; i < friends.length; i++) {
                for (int j = i + 1 ; j < friends.length; j++) {
                    if (view[i][j] > view[j][i]) {
                        result[i]++;
                        continue;
                    }
                    if (view[i][j] < view[j][i]) {
                        result[j]++;
                        continue;
                    }
                    if (score[i] > score[j]) {
                        result[i]++;
                        continue;
                    }
                    if (score[i] < score[j]) {
                        result[j]++;
                        continue;
                    }
                }
            }

            System.out.println("result");
            for (int i: result) {
                System.out.print(i + " ");
            }
            System.out.println();

            //2-1. 같은 경우 선물 지수 비교
            int maxValue = Integer.MIN_VALUE;
            for (int i: result) {
                if (i > maxValue) {
                    maxValue = i;
                }
            }

            //3. 가장 많이 받은 수 구하기
            return maxValue;
        }

        private Map<String, Integer> getIndexs(String[] friends) {
            Map<String, Integer> indexs = new HashMap<>();
            for (int i = 0; i < friends.length; i++) {
                indexs.put(friends[i], i);
            }
            return indexs;
        }
    }
}
