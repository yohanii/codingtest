import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class 백준_27866 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int index = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(index-1));

        System.out.println(sb);




    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
