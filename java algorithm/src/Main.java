import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] arr1 = new int[]{5,2,4,3,1};
        List<Integer> list1 = new ArrayList<>(List.of(6,4,1,2,3));

        //int arr to Integer List
        List<Integer> result1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        System.out.println("result1 = " + result1);

        //Integer List to int arr
        int[] result2 = list1.stream().mapToInt(Integer::valueOf).toArray();
        for (int i : result2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
