import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 백준_10807 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[n];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }

        int compareNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            if (numList[i] == compareNum) result++;
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
