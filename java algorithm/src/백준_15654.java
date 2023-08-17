import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_15654 {
    static int N, M;
    static int[] numSave;
    static int[] dfsArr;
    static StringBuilder sb;

    public void dfs(int at, int depth) {
        if(depth == M){
            //dfsArr에 저장된 index로 출력
            for(int i = 0; i < M; i++) {
                sb.append(numSave[dfsArr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            boolean isContain = false;

            for(int j = 0; j < depth; j++){
                if(i == dfsArr[j]) isContain = true;
            }

            if(!isContain){
                dfsArr[depth] = i;
                dfs(i, depth + 1);
            }
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numSave = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numSave[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numSave);

        sb = new StringBuilder();

        dfsArr = new int[M];
        Arrays.fill(dfsArr, -1);
        dfs(-1, 0);

        System.out.println(sb);


    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
