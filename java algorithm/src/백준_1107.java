import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_1107 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //0 ~ 999,999까지 탐색
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int min = Math.abs(n - 100);

        if(m == 0) {
            int result = String.valueOf(n).length();

            if(result < min)
                min = result;
            System.out.println(min);
            return;
        }

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> numList = new ArrayList<>();
        while(m-- > 0) {
            int ele = Integer.parseInt(st.nextToken());
            numList.add(ele);
        }

        for(int i = 0; i <= 999999; i++) {
            String iStr = String.valueOf(i);

            boolean canMake = true;
            for(int j = 0; j < iStr.length(); j++) {
                if(numList.contains(iStr.charAt(j) - '0')) {
                    canMake = false;
                    break;
                }
            }

            if(!canMake)
                continue;

            int result = iStr.length() + Math.abs(n - i);
            if(result < min)
                min = result;
        }
        System.out.println(min);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
