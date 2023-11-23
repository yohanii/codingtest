import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


    public class programmers_2023KAKAO_이모티콘할인행사 {

        public void solution() throws Exception {
            int[][] users = new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
            int[] emoticons = new int[]{1300, 1500, 1600, 4900};

            Solution.solution(users, emoticons);
        }

        class Solution {
            private static int[] discountsArr;
            private static List<Integer> discounts = List.of(10, 20, 30, 40);
            private static int maxCount = Integer.MIN_VALUE;
            private static int maxPrice = Integer.MIN_VALUE;

            public static int[] solution(int[][] users, int[] emoticons) {
                discountsArr = new int[emoticons.length];
                dfs(0, users, emoticons);

                return new int[]{maxCount, maxPrice};
            }

            private static void dfs(int index, int[][] users, int[] emoticons) {


                if (index == emoticons.length) {
                    List<List<Integer>> emoticonList = new ArrayList<>();

                    for (int i = 0; i < emoticons.length; i++) {
                        emoticonList.add(List.of(discountsArr[i], emoticons[i]));
                    }

                    int userCount = 0;
                    int totalPrice = 0;

                    for (int[] user : users) {
                        Integer priceSum = emoticonList.stream()
                                .filter(e -> e.get(0) >= user[0])
                                .map(e -> e.get(1) * (100 - e.get(0)) / 100)
                                .reduce((x, y) -> x + y)
                                .orElse(0);
                        if (priceSum >= user[1]) {
                            userCount++;
                        } else {
                            totalPrice += priceSum;
                        }
                    }

                    if (userCount > maxCount) {
                        maxCount = userCount;
                        maxPrice = totalPrice;
                    } else if (userCount == maxCount){
                        if (totalPrice > maxPrice) {
                            maxPrice = totalPrice;
                        }
                    }

                    return;
                }
                for (int discount : discounts) {
                    discountsArr[index] = discount;
                    dfs(index + 1, users, emoticons);
                }
            }
        }




        public static void main(String[] args) throws Exception {
            new Main().solution();
        }
    }

