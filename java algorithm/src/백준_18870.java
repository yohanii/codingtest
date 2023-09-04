import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class 백준_18870 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        //1. 입력을 배열에도 저장해두고, PriorityQueue에도 저장한다.
        //2. queue 돌면서 값에 대한 index값 map에 저장.
        //3. 배열 돌면서 map에서 값 가져온다.
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sorted;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            arr[i] = num;
        }
//        System.out.println(queue);
        Map<Integer, Integer> map = new HashMap<>();
        sorted = arr.clone();
        Arrays.sort(sorted);
        int index = 0;
        for(int i : sorted){
            if(!map.containsKey(i)) {
                map.put(i, index);
                index++;
            }
        }

//        System.out.println(map);
        for(int i = 0; i < n; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);


    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
