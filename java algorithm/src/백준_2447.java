import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;



public class 백준_2447 {

    public void draw(int i, int j, int num) {
        if((i/num)%3 == 1 && (j/num)%3 == 1) {
            System.out.print(" ");
        }else {
            if(num/3 == 0) {
                System.out.print("*");
            }else{
                draw(i, j, num/3);
            }
        }


    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                draw(i, j, n);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
