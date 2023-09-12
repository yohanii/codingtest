import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_17626 {
    static int[] arr;

    public static int check(int n){
        if(arr[n] != 0)
            return arr[n];

        int num = (int) Math.sqrt(n);
        int result = 5;


        for(int i = num; i > 0; i--) {
            int answer;
            if(arr[n - i*i] == 0){
                answer = 1 + check(n - i*i);
            }else{
                answer = 1 + arr[n - i*i];
            }

            if(answer < result){
                arr[n] = answer;
                result = answer;
            }
        }

        return result;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        arr = new int[50001];

        //n을 넘지 않는 최대 제곱수 구하고, 모든 경우 중 최소 가져오기
        //그 중 2있으면 바로 탈출.
        int n = Integer.parseInt(br.readLine());

        int num = (int) Math.sqrt(n);
//        System.out.println(num);

        if(num*num == n){
            System.out.println(1);
            return;
        }

        for(int i = 1; i < num+1; i++){
            arr[i*i] = 1;
        }

        System.out.println(check(n));


    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
