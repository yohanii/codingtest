import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.util.*;
import java.util.stream.Collectors;


public class programmers_2024KAKAO_coin {

    public static void main(String[] args) throws Exception {

        new Main().solution();
    }

    public void solution() {
        int coin = 3;
//        int[] cards = new int[]{3,6,7,2,1,10,5,9,8,12,11,4};
        int[] cards = new int[]{1, 2, 3, 4, 5, 6};

        List<Integer> cardList = Arrays.stream(cards)
                .boxed()
                .collect(Collectors.toList());

        int n = cards.length;
        int heart = 0;
        int[] status = new int[n + 1];
        int round = 1;
        int index = n / 3 + 1;

        List<Integer> currentCards = new ArrayList<>(cardList.subList(0, n / 3));
        for (int card : currentCards) {
            status[card] = 1;
        }

        System.out.println("currentCards = " + currentCards);

        //초기 heart 수 파악
        for (int card : currentCards) {
            if (currentCards.contains(n + 1 - card)) {
                heart++;
                status[card] = 2;
            }
        }
        heart /= 2;
        index += heart * 2;

        //반복
        while (true) {
            if (heart >= round) {
                round++;
                continue;
            }

            System.out.println("heart = " + heart);
            System.out.println("round = " + round);
            System.out.println("index = " + index);
            System.out.println("currentCards = " + currentCards);
            System.out.println("cardList = " + cardList);

            //한 장만 사기
            List<Integer> addedCards = new ArrayList<>();
            for (int card : currentCards) {
                if (card == 2) {
                    System.out.println("Main.solution");
                    System.out.println(status[card]);
                    System.out.println(status[n + 1 - card]);
                    System.out.println(cardList.indexOf(n + 1 - card));
                }
                if (coin > 0 && status[card] == 1 && status[n + 1 - card] == 0 && cardList.indexOf(n + 1 - card) <= index) {
                    heart++;
                    index += 2;
                    coin--;
                    status[card] = 2;
                    status[n + 1 - card] = 2;
                    addedCards.add(n + 1 - card);
                    break;
                }
            }
            currentCards.addAll(addedCards);

            if (heart < round) {
                //두 장 사기
                int searchIndex = Math.min(index, cardList.size() - 1);
                for (int i = 0; i < searchIndex; i++) {
                    int card = cardList.get(i);
                    if (coin >= 2 && status[card] == 0 && status[n + 1 - card] == 0 && cardList.indexOf(n + 1 - card) <= index) {
                        heart++;
                        index += 2;
                        coin -= 2;
                        currentCards.add(card);
                        currentCards.add(n + 1 - card);
                        break;
                    }
                }
            }

            if (heart < round) {
                break;
            }
        }
    }
}

