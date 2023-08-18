import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_2467 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Long minVal = Long.MAX_VALUE;
        int start = 0;
        int end = n-1;
        int[] indexSave = new int[2];

        while(true) {
            if(start == end)
                break;

            Long sum = arr[start] + arr[end];

            if(Math.abs(sum) < minVal){
                minVal = Math.abs(sum);
                indexSave[0] = start;
                indexSave[1] = end;
            }

            if(sum < 0) {
                start++;
            } else if(sum > 0){
                end--;
            } else {
                break;
            }
        }

        System.out.print(arr[indexSave[0]] + " " + arr[indexSave[1]]);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
