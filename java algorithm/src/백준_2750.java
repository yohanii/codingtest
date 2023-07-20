import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2750 {

    public int[] bubble_sort(int[] arr) {
        int[] result = arr;

        for(int i = result.length; i>1; i--) {
            for(int j=0; j<i-1; j++) {
                if(result[j] > result[j+1]) {
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }

        return result;
    }

    public int[] selection_sort(int[] arr) {
        int[] result = arr;

        int min;
        int minIndex;
        for(int i = 0; i < result.length; i++) {
            min = result[i];
            minIndex = i;
            for(int j = i+1; j< result.length; j++) {
                if(result[j] < min) {
                    min = result[j];
                    minIndex = j;
                }
            }
            int temp = result[minIndex];
            result[minIndex] = result[i];
            result[i] = temp;
        }

        return result;
    }

    public ArrayList<Integer> insertion_sort(int[] arr) {
        int[] saveArr = arr;
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(saveArr[0]);
        if(saveArr.length == 1) {
            return result;
        }
        for(int i = 0; i < saveArr.length-1; i++) {
            int index = 0;
            while(index <= i) {
                if(saveArr[i+1] < result.get(index)) {
                    break;
                }
                index++;
            }

            result.add(index, Integer.valueOf(saveArr[i+1]));
        }

        return result;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] resultArr = selection_sort(arr);

        for(int i = 0; i < n; i++) {
            System.out.println(resultArr[i]);
        }


//        ArrayList<Integer> resultArr = insertion_sort(arr);
//
//        for(int i = 0; i < n; i++) {
//            System.out.println(resultArr.get(i));
//        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
