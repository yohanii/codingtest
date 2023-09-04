import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class 백준_1620 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int index = 1;
        //1. 두 개의 map 만든다.
        //2. 입력이 숫자인지 구분은 try catch로
        Map<String, Integer> NameToIndex = new HashMap<>();
        Map<Integer, String> IndexToName = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            NameToIndex.put(str, index);
            IndexToName.put(index, str);
            index++;
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();

            try{
                int inputNum = Integer.parseInt(input);
                System.out.println(IndexToName.get(inputNum));
            }catch (NumberFormatException e){
                System.out.println(NameToIndex.get(input));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
