import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 백준_9663_메모리초과 {

    static int result;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        //visited를 색칠해나가는 방식으로하면, newVisited를 계속 만들어야해서 메모리초과 날 수밖에 없다.
        //따라서, 해당 칸 (x, y)의 행, 열, 대각선을 체크하고 놓을 수 있는지 보는 식으로 고쳐야한다.
        int n = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[n][n];

        result = 0;

        dfs(visited, 0);
        System.out.println(result);
    }

    private void dfs(boolean[][] visited, int index) {
        int n = visited.length;

//        show(visited);

        if(index == n) {
            result++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[index][i]) {
                boolean[][] newVisited = checkVisited(visited, index, i);
                dfs(newVisited, index + 1);
            }
        }
    }

    private void show(boolean[][] visited) {
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited.length; j++) {
                if(visited[i][j])
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }

    private boolean[][] checkVisited(boolean[][] inputVisited, int x, int y) {
        boolean[][] visited = copy(inputVisited);
        int n = visited.length;

        for(int i = 0; i < n; i++) {
            visited[x][i] = true;
            visited[i][y] = true;

            int newX = i;
            int newY1 = i + y - x;
            int newY2 = x + y - i;

            if(newX >= 0 && newX < n && newY1 >= 0 && newY1 < n)
                visited[newX][newY1] = true;
            if(newX >= 0 && newX < n && newY2 >= 0 && newY2 < n)
                visited[newX][newY2] = true;
        }

        return visited;
    }

    public static boolean[][] copy(boolean[][] src) {
        if (src == null) {
            return null;
        }

        boolean[][] copy = new boolean[src.length][];

        for (int i = 0; i < src.length; i++) {
            copy[i] = new boolean[src[i].length];
            System.arraycopy(src[i], 0, copy[i], 0, src[i].length);
        }

        return copy;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
