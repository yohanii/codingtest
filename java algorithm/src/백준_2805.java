import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_2805 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //나무 길이 정렬 후 짤라도 되는 최소길이 구하기
        //하나씩 높여가며 정답 찾기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] tree = new long[n];
        st = new StringTokenizer(br.readLine());
        long total = 0;
        for(int i = 0; i < n; i++){
            tree[i] = Long.parseLong(st.nextToken());
            total += tree[i];
        }

        Arrays.sort(tree);

        int index = 0;
        long len = 0l;
        long trash = 0l;
        for(int i = 0; i < n; i++){
            len = total - (n - i) * tree[i];
            len -= trash;
            trash += tree[i];

            if(len <= m) {
                index = i;
                break;
            }
        }

        long h = tree[index];

        //System.out.println(m + " " + len + " " + index);
        //System.out.println(h);
        h -= Math.ceil((double)(m-len)/(n-index));

        System.out.println(h);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
