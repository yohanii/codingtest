import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_2239_시간초과 {

    static int[][] map;
    static List<Integer>[] row;
    static List<Integer>[] column;
    static List<Integer>[] square;
    static Queue<Pos> zero;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[9][9];
        row = new ArrayList[9];
        column = new ArrayList[9];
        square = new ArrayList[9];
        zero = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            row[i] = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            column[i] = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            square[i] = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        }

        for (int i = 0; i < 9; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                row[i].remove((Integer) map[i][j]);
                column[j].remove((Integer) map[i][j]);
                square[3 * (i / 3) + j / 3].remove((Integer) map[i][j]);

                if (map[i][j] == 0) {
                    zero.add(new Pos(i, j));
                }
            }
        }

//        System.out.println("row");
//        for (List<Integer> integers : row) {
//            System.out.println(integers);
//        }
//
//        System.out.println("column");
//        for (List<Integer> integers : column) {
//            System.out.println(integers);
//        }
//
//        System.out.println("square");
//        for (List<Integer> integers : square) {
//            System.out.println(integers);
//        }

        List<Integer>[][] retain = new ArrayList[9][9];

        for (Pos pos : zero) {
            List<Integer> retainList = new ArrayList<>(row[pos.x]);
            retainList.retainAll(column[pos.y]);
            retainList.retainAll(square[3 * (pos.x / 3) + pos.y / 3]);
            retain[pos.x][pos.y] = retainList;
        }

        while (!zero.isEmpty()) {
            Pos pos = zero.poll();
//            System.out.println(pos.x + ", " + pos.y);
//            System.out.println("retainList = " + retainList);

            if (retain[pos.x][pos.y].size() == 1) {
                Integer value = retain[pos.x][pos.y].get(0);
                map[pos.x][pos.y] = value;
                for (Pos other : zero) {
                    if (other.x == pos.x || other.y == pos.y || 3 * (other.x / 3) + other.y / 3 == 3 * (pos.x / 3) + pos.y / 3) {
                        retain[other.x][other.y].remove(value);
                    }
                }
                continue;
            }
            zero.add(pos);
        }

        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }


//        System.out.println("success");


    }

    class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
