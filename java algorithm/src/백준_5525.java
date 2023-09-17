import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_5525 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //S돌면서 equal로 비교
        //substring 안쓰는 방법으로 해야 효율이 좋다. 50점짜리 정답.
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String nStr = "I";
        while(n-- > 0)
            nStr += "OI";

        int[] arr = new int[m];
        int lastUpIndex = -10;

        for(int i = nStr.length()-1; i < arr.length; i++){
            if(S.charAt(i) == 'I'){
                if(lastUpIndex == i - 2 && S.charAt(i-1) == 'O'){
                    arr[i] = arr[i-1] + 1;
                    lastUpIndex = i;
//                    System.out.println("repeat" + i);
                }else{
                    //substring 안쓰는 방법으로 해야 효율이 좋다. 50점짜리 정답.
                    if(nStr.equals(S.substring(i - nStr.length() + 1, i + 1))) {
                        arr[i] = arr[i-1] + 1;
                        lastUpIndex = i;
//                        System.out.println("find" + i);
                    }
                    else
                        arr[i] = arr[i-1];
                }
            }else {
                arr[i] = arr[i-1];
            }
        }

        System.out.println(arr[m-1]);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
