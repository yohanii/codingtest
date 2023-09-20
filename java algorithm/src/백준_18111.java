import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_18111 {
    public int getTime(int[][] map, int height, int b) {
        int time = 0;
        int block = b;
        for(int[] r: map){
            for(int c: r) {
                if(c > height) {
                    time += 2 * (c - height);
                    block += c - height;
                }else if (c < height){
                    time += height - c;
                    block -= height - c;
                }
            }
        }

        if(block < 0)
            return -1;

        return time;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //최소 h부터 올라가면서 값 구하기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;
        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] < minH)
                    minH = map[i][j];
                if(map[i][j] > maxH)
                    maxH = map[i][j];
            }
        }

//        System.out.println(minH + " " + maxH);

        int result = Integer.MAX_VALUE;
        int saveHeight = -1;
        for(int height = minH; height <= maxH; height++) {
            int time = getTime(map, height, b);

//            if(time == -1)
//                break;
            if(time != -1 && time <= result) {
                result = time;
                saveHeight = height;
            }
        }
        System.out.println(result + " " + saveHeight);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
