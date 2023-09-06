import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class 백준_2630 {

    static int white, blue = 0;
    static int[][] graph;

    static void dfs(int x, int y, int k){
        //한 색깔로 통일되어있는지 체크
        if(check(x, y, k) == 0) {
            white++;
            return;
        }else if(check(x, y, k) == 1) {
            blue++;
            return;
        }

        //섞여있을 시 나누기
        int newK = k/2;
        dfs(x, y, newK);
        dfs(x + newK, y, newK);
        dfs(x, y + newK, newK);
        dfs(x + newK, y + newK, newK);
    }

    static int check(int x, int y, int k){
        //모두 0일 경우 1 리턴, 모두 1일 경우 2 리턴, 나머지 -1
        //일단 set에 담아서 개수 세기. 0, 1 섞여있을 때 중간에 탈출하지 않아서 손해긴함.
        //그래서, 첫번째 원소 값 저장하고, 다른 거 나오면 바로 탈출할 수 있게 하면 더 좋음.
        Set<Integer> set = new HashSet<>();

        for(int i = x; i < x + k; i++){
            for(int j = y; j < y + k; j++){
                set.add(graph[i][j]);
            }
        }

        if(set.size() == 1){
            if(set.contains(0)){
                return 0;
            } else {
                return 1;
            }
        }

        return -1;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //dfs(좌표x, 좌표y, 길이 k)
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
