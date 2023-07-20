import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class 백준_10828 {

    public void push(ArrayList<Integer> inputArr, int num) {
        inputArr.add(num);
    }
    public void pop(ArrayList<Integer> inputArr) {
        if (inputArr.size() == 0) {
            System.out.println("-1");
            return;
        }

        System.out.println(inputArr.get(inputArr.size() - 1));
        inputArr.remove(inputArr.size() - 1);
    }
    public int size(ArrayList<Integer> inputArr) {
        return inputArr.size();
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> result = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            switch (arr[0]) {
                case "push" :
                    push(result, Integer.parseInt(arr[1]));
                    break;
                case "pop" :
                    pop(result);
                    break;
                case "size":
                    System.out.println(size(result));
                    break;
                case "empty":
                    if (size(result) == 0) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if (size(result) == 0) {
                        System.out.println("-1");
                    } else {
                        System.out.println(result.get(size(result)-1));
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
