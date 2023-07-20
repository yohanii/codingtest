import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 백준_9086 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i =0; i < n; i++) {
            String str = br.readLine();
            System.out.println(Character.toString(str.charAt(0)) + str.charAt(str.length()-1));
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
