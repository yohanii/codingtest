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

        ArrayList<Integer> list = new ArrayList<>(List.of(3, 6, 2, 2, 2, 7));
        System.out.println(list);
        //3, 6, 2, 2, 2, 7

        HashSet<Integer> set = new HashSet<>(list);
        System.out.println(set);
        //2, 3, 6, 7
        TreeSet<Integer> test = new TreeSet<>(set);
        System.out.println(test);
        //2, 3, 6, 7
        Stack<Integer> stack = new Stack<>();
        stack.addAll(test);
        System.out.println(stack);

        System.out.println("----------");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }



    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
