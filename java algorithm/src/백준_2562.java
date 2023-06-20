import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 백준_2562 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxNum = -1;
        int position = -1;

        for(int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > maxNum) {
                maxNum = num;
                position = i;
            }
        }
        position++;
        System.out.println(maxNum);
        System.out.println(position);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
