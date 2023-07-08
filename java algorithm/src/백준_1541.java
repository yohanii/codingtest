import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Stream;



public class 백준_1541 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr =br.readLine().split("-");

        ArrayList<Integer> saveArr = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(i==0){
                saveArr.add(-Arrays.stream(arr[i].split("\\+")).mapToInt(x->Integer.parseInt(x)).sum());
                continue;
            }
            saveArr.add(Arrays.stream(arr[i].split("\\+")).mapToInt(x->Integer.parseInt(x)).sum());
        }
        System.out.println(-saveArr.stream().mapToInt(Integer::intValue).sum());
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
