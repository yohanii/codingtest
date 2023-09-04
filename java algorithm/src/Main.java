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

        String str1 = "00000";
        String str2 = "hel";

        System.out.println(str1.contains(str2));
        System.out.println(str1.contains("helle"));

        System.out.println(Integer.parseInt(str1));
        Integer[] arr = {1,2,3,4,5};
        Arrays.sort(arr);
        Integer[] abc = new Integer[]{1,3,2};
        Arrays.sort(abc);
        System.out.println(abc);

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        int[] ar = list.stream().mapToInt(i -> i.intValue()).toArray();
        Integer[] vv = list.toArray(new Integer[list.size()]);

        for(int i : vv){
            System.out.println(i);
        }
        Arrays.stream(ar).boxed().toArray(Integer[]::new);
        Arrays.stream(vv).mapToInt(i -> i.intValue()).toArray();

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
