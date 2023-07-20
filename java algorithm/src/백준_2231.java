import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2231 {

    public int getMom(int num) {
        //(1 ≤ num ≤ 1,000,000) -> 1 <= 자릿수 N <= 7
        int result = 0;

        //num 자릿수(N) 구하기
        int N = 0;
        int checkNum = num;
        while(checkNum != 0) {
            checkNum = checkNum/10;
            N++;
        }

        //num-N*9 ~ num-1까지 직접 체크. 체크 후 가능이면 result에 넣고, 없으면 num이 그대로 출력 되도록.
        for(int i = num-1; i >= num-N*9; i--) {
            String tempNum = Integer.toString(i);
            int sum = i;
            for(int j = 0; j < tempNum.length(); j++) {
                sum += Character.getNumericValue(tempNum.charAt(j));
            }

            if(sum == num) {
                result = i;
            }
        }

        return result;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int result;

        result = getMom(input);

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
