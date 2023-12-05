import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class programmers_2024KAKAO_dice {

    public static void main(String[] args) throws Exception {

        new Main().solution();
    }

    public void solution() {

        int[][] dice = new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};

        int n = dice.length;

        //winCount, index
        List<List<Integer>> winCount = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            int win = getWin(dice, n, winCount, index);
            winCount.add(List.of(win, index + 1));
        }

        Collections.sort(winCount, (x, y) -> y.get(0) - x.get(0));

        System.out.println(winCount);

        List<Integer> resultList = winCount.stream()
                .limit(n / 2)
                .map(ele -> ele.get(1))
                .collect(Collectors.toList());

        System.out.println(resultList);
        int[] result = resultList.stream()
                .sorted()
                .mapToInt(x -> x)
                .toArray();
        for (int i : result) {
            System.out.println(i);
        }
    }

    private int getWin(int[][] dice, int n, List<List<Integer>> winCount, int index) {
        int win = 0;
        for (int i = 0; i < n; i++) {
            if (i == index) {
                continue;
            }
            win += getWin(dice[index], dice[i]);
        }
        return win;
    }

    private int getWin(int[] mine, int[] partner) {
        int result = 0;
        for (int mineNum : mine) {
            for (int partnerNum : partner) {
                if (mineNum > partnerNum) {
                    result++;
                }
            }
        }
        return result;
    }
}

