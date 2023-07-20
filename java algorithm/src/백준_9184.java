import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;



public class 백준_9184 {

    private Integer get(Integer[][][] w, Integer a, Integer b, Integer c) {
        if(a<=0 || b<=0 || c<=0) {
//            System.out.println("case 1 " + a + " " + b + " " + c);
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
//            System.out.println("case 2 " + a + " " + b + " " + c);

            if(w[20][20][20] == null) {
                w[20][20][20] = get(w, 20, 20, 20);
            }
            return w[20][20][20];
        } else if (a < b && b < c){
//            System.out.println("case 3 " + a + " " + b + " " + c);

            if(w[a][b][c] == null) {
                w[a][b][c] = get(w, a, b, c-1) + get(w, a, b-1, c-1) - get(w, a, b-1, c);
            }
            return w[a][b][c];
        } else {
//            System.out.println("case 4 " + a + " " + b + " " + c);

            if(w[a][b][c] == null) {
                w[a][b][c] = get(w, a-1, b, c) + get(w, a-1, b-1, c) + get(w, a-1, b, c-1) - get(w, a-1, b-1, c-1);
            }
            return w[a][b][c];
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[][][] save = new Integer[21][21][21];

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Integer a = Integer.parseInt(st.nextToken());
            Integer b = Integer.parseInt(st.nextToken());
            Integer c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) break;
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + get(save, a, b, c));
        }


    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
