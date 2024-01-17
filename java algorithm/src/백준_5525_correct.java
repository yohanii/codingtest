import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_5525_correct {

    static char[] words = new char[]{'I', 'O'};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int index = 0;
        int count = 0;
        int stack = 0;
        while (index < s.length()) {

            char correct = words[stack % 2];
            if (stack < 2 * n) {
                if (correct == s.charAt(index)) {
                    stack++;
                } else {
                    if (s.charAt(index) == 'I') {
                        stack = 1;
                    } else {
                        stack = 0;
                    }
                }
            } else {
                if (correct == s.charAt(index)) {
                    stack++;
                    if (s.charAt(index) == 'I') {
//                        System.out.println("index = " + index);
                        count++;
                    }
                } else {
                    if (s.charAt(index) == 'I') {
                        stack = 1;
                    } else {
                        stack = 0;
                    }
                }
            }

//            System.out.println("stack = " + stack);
            index++;
        }

        System.out.println(count);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
