import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_1874 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> outputList = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            outputList.add(Integer.parseInt(br.readLine()));
        }

//        System.out.println(outputList);

        //넣은 숫자 1 ~ n
        int index = 1;

        while(!outputList.isEmpty()) {
            int elem = outputList.poll();
//            System.out.println("elem : " + elem);
            while(index <= elem) {
//                System.out.println("index : " + index);
                stack.add(index);
                index++;
                sb.append("+\n");
            }

            int output = stack.pop();

            if(output != elem) {
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
        }
        System.out.println(sb);

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
