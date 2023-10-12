import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_10026 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        countColor(n, map, false);
        System.out.print(" ");
        countColor(n, map, true);

    }

    private void countColor(int n, char[][] map, boolean hasProblem) {
        //0,0 ~ n-1, n-1 Pos 추가
        int[][] visited = new int[n][n];
        int result = 0;

        while(true) {
            int[] elem = getUnvisited(visited);
            if(elem == null)
                break;
            visit(elem, map, visited, hasProblem);
            result++;
        }
        System.out.print(result);
    }

    private int[] getUnvisited(int[][] visited) {
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited.length; j++) {
                if(visited[i][j] == 0)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    private void visit(int[] elem, char[][] map, int[][] visited, boolean hasProblem) {
        int x = elem[0];
        int y = elem[1];
        char color = map[x][y];
        ArrayList<Character> ableColor = new ArrayList<>();

        if(hasProblem && color != 'B') {
            ableColor.add('R');
            ableColor.add('G');
        } else {
            ableColor.add(color);
        }

        visited[x][y] = 1;
        int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] moveEle: move) {
            int newX = x + moveEle[0];
            int newY = y + moveEle[1];

            if(newX >= 0 && newX < map.length && newY >= 0 && newY < map.length && visited[newX][newY] == 0 && ableColor.contains(map[newX][newY])) {
                visit(new int[]{newX, newY}, map, visited, hasProblem);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
