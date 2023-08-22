import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class Main {

    class Song implements Comparable<Song> {

        @Override
        public int compareTo(Song o) {
            return 0;
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 1;

        String[][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        answer = Arrays.stream(arr)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;

        System.out.println();

        ArrayList<Integer> arrr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Character chr;
        stack.size();
        Queue<Integer> queue = new LinkedList<>();
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
