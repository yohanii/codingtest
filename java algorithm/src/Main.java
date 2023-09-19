import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //List로 구현
        //값 들어오면 적절한 위치 찾아서 넣기
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String act = st.nextToken();
                if(act.equals("I")) {
                    int elem = Integer.parseInt(st.nextToken());
                    map.put(elem, map.getOrDefault(elem, 0) + 1);
                }else {
                    if(map.size() > 0) {
                        if(st.nextToken().equals("1")) {
                            if(map.getOrDefault(map.lastKey(), 1) == 1)
                                map.remove(map.lastKey());
                            else
                                map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                        }else {
                            if(map.getOrDefault(map.firstKey(), 1) == 1)
                                map.remove(map.firstKey());
                            else
                                map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                        }
                    }
                }
//                map.forEach((key, value) -> System.out.print(key + " "));
//                System.out.println("");
            }
//            sb.append(list);
            if(map.size() > 0) {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }else {
                sb.append("EMPTY").append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
