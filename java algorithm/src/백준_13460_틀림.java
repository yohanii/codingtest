import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_13460_틀림 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //1. 벽 위치, 구멍 위치, 공 위치 받기
        //queue : red, blue, direction
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
//        System.out.println(n + ", " + m);

        int[][] map = new int[n][m];
        Pos red = null;
        Pos blue = null;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                switch (line[j]) {
                    case "#":
                        map[i][j] = 1;
                        break;
                    case "O":
                        map[i][j] = 2;
                        break;
                    case "R":
                        red = new Pos(i, j);
                        break;
                    case "B":
                        blue = new Pos(i, j);
                        break;
                }
            }
        }

//        System.out.println("map");
//        for (int i = 0; i < n; i++) {
//            for(int j = 0 ; j < m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

//        System.out.println("red: "+ red);
//        System.out.println("blue: "+ blue);

        int result = bfs(n, m, map, red, blue);
        System.out.println(result);
    }

    public int bfs(int n, int m, int[][] map, Pos red, Pos blue) {

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<Elem> queue = new LinkedList<>();
        queue.add(new Elem(red, blue, 0));

        while (!queue.isEmpty()) {

            Elem elem = queue.poll();
            Pos redPos = elem.red;
            Pos bluePos = elem.blue;
            int curCount = elem.count;

            if (curCount > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                boolean blueFail = false;
                boolean isSuccess = false;
                Pos redCase = new Pos(redPos.x, redPos.y);
                Pos blueCase = new Pos(bluePos.x, bluePos.y);

                while(true) {
                    int newRedX = redCase.x + dx[i];
                    int newRedY = redCase.y + dy[i];
                    if (map[newRedX][newRedY] == 1 || (newRedX == blueCase.x && newRedY == blueCase.y)) {
                        newRedX = redCase.x;
                        newRedY = redCase.y;
                    }

                    if (map[newRedX][newRedY] == 2) {
                        isSuccess = true;
                    }
                    if (map[redCase.x][redCase.y] == 2) {
                        newRedX = redCase.x;
                        newRedY = redCase.y;
                    }

                    int newBlueX = blueCase.x + dx[i];
                    int newBlueY = blueCase.y + dy[i];
                    if (map[newBlueX][newBlueY] == 2) {
                        blueFail = true;
                        break;
                    }

                    if (map[newBlueX][newBlueY] == 1) {
                        newBlueX = blueCase.x;
                        newBlueY = blueCase.y;
                    }

                    boolean stopByRed = false;
                    if (newBlueX == redCase.x && newBlueY == redCase.y) {
                        stopByRed = true;
                        newBlueX = blueCase.x;
                        newBlueY = blueCase.y;
                    }

                    if (newRedX == redCase.x && newRedY == redCase.y && newBlueX == blueCase.x && newBlueY == blueCase.y) {
                        break;
                    }

                    redCase.x = newRedX;
                    redCase.y = newRedY;
                    blueCase.x = newBlueX;
                    blueCase.y = newBlueY;
                }

                if (blueFail) {
                    continue;
                }

                if (isSuccess) {
                    return curCount + 1;
                }

                queue.add(new Elem(redCase, blueCase, curCount + 1));
            }

        }

        return -1;
    }



    class Elem {
        int count;
        Pos red;
        Pos blue;

        public Elem(Pos red, Pos blue, int count) {
            this.red = red;
            this.blue = blue;
            this.count = count;
        }
    }

    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x, y : " + x + ", " + y;
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
