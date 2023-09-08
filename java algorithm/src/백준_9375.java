import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_9375 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //map에 옷 종류별로 갯수 세주기
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            Map<String, Integer> map = new HashMap<>();

            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String wear = st.nextToken();

                map.put(wear, map.getOrDefault(wear, 0) + 1);
            }

            Integer result = map.values().stream().reduce(1, (x, y) -> x * (y + 1));
            System.out.println(--result);
        }

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
