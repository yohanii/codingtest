import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_2239 {

    static int[][] map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //dfs recursive
        //1. 순서대로 돌면서 0 찾는다. -> 0 없으면 종료
        //2. 1~9 도는데 들어갈 수 있는지 체크
        //3. 들어갈 수 있으면 넣고, 1~2 반복
        //개선하려면,
        //1. 0인 좌표를 stack에 넣고 관리해서, 실패 시 stack에 다시 쌓고 반복지점으로 돌아간다. -> 매번 0인 좌표 찾을 필요 없음.
        //2. check에서 27번 계산하는데, 겹치는 부분 제거할 수 있다.
        //3. fill에 성공한다면, 빈칸 한 개인 부분 연계로 채울 수 있게한다.

        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        if (fill()) {
            for (int[] ints : map) {
                for (int anInt : ints) {
                    System.out.print(anInt);
                }
                System.out.println();
            }
            return;
        }
        System.out.println("fail");
    }

    public boolean fill() {
        int[] pos = findZero(map);
        if (pos == null) {
            return true;
        }

        for (int v = 1; v <= 9; v++) {
            if (check(v, pos)) {
                map[pos[0]][pos[1]] = v;

                if (fill()) {
                    return true;
                }

                map[pos[0]][pos[1]] = 0;
            }
        }
        return false;
    }

    private boolean check(int v, int[] pos) {
        int r = pos[0];
        int c = pos[1];

        for (int i = 0; i < 9; i++) {
            //가로
            if (map[r][i] == v) {
                return false;
            }

            //세로
            if (map[i][c] == v) {
                return false;
            }
        }

        //사각형
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[3*(r/3) + i][3*(c/3) + j] == v) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[] findZero(int[][] map) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (map[r][c] == 0) {
                    return new int[]{r, c};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
