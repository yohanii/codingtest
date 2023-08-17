import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_15666 {
    static int N, M;
    static int[] numSave;
    static int[] dfsArr;
    static StringBuilder sb;
    static ArrayList<int[]> history = new ArrayList<>();

    public void dfs(int at, int depth) {
        if(depth == M){
            int[] temp = new int[M];

            for(int i = 0; i < M; i++) {
                temp[i] = numSave[dfsArr[i]];
            }

            //contains check
            boolean isContain = false;
            for(int[] ele: history){
                if(Arrays.equals(temp, ele))
                    isContain = true;
            }

            if(!isContain) {
                //dfsArr에 저장된 index로 출력
                for(int i = 0; i < M; i++) {
                    sb.append(numSave[dfsArr[i]]).append(" ");
                }
                sb.append("\n");
                history.add(temp);
            }
            return;
        }

        for(int i = at; i < N; i++) {
            dfsArr[depth] = i;
            dfs(i, depth + 1);
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
        dfs(0, 0);

        System.out.println(sb);


    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
