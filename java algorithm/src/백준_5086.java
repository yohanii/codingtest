import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_5086 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0) break;

            if(a % b == 0) {
                System.out.println("multiple");
            } else if (b % a == 0) {
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
