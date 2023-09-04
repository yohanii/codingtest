import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class 백준_1764 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. 이름을 map에 받아서 개수가 2인 key 출력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N+M; i++){
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

//        System.out.println(map);

        long size = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .count();
        System.out.println(size);

        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> System.out.println(entry.getKey()));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
