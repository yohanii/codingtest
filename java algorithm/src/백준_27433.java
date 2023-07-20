import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;



public class 백준_27433 {

    private Long pactorial(Long n) {
        Long result;
        if(n == 1 || n == 0) return new Long(1);

        result = n * pactorial(n-1);
        return result;
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());
        System.out.println(pactorial(n));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
