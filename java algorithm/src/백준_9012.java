import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class 백준_9012 {

    private String checkVPS(String str) {
        int len = str.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.size() == 0) return "NO";
                stack.pop();
            }
        }

        if(stack.size() == 0) return "YES";
        return "NO";

    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            System.out.println(checkVPS(str));
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
