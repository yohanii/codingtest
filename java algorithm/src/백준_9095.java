import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class 백준_9095 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1->1
        //2->2
        //3->4
        //4->7
        //5->13
        //6->24
        //7->44
        int T = Integer.parseInt(br.readLine());

        int[] result = new int[11];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        IntStream.range(4, 11).forEach(x -> result[x] = result[x-1] + result[x-2] + result[x-3]);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            sb.append(result[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
