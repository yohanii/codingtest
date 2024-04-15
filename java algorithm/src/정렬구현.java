import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 정렬구현 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] arr1 = new int[]{4, 1, 2, -1, -3};
        Arrays.sort(arr1);
        printArr(arr1);

        int[] arr2 = new int[]{4, 1, 2, -1, -3};
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        list2.sort(Comparator.naturalOrder());
        arr2 = list2.stream().mapToInt(Integer::intValue).toArray();
        printArr(arr2);

        int[] arr3 = new int[]{4, 1, 2, -1, -3};
        selectionSort(arr3);
        printArr(arr3);

        int[] arr4 = new int[]{4, 1, 2, -1, -3};
        bubbleSort(arr4);
        printArr(arr4);

        int[] arr5 = new int[]{4, 1, 2, -1, -3};
        insertSort(arr5);
        printArr(arr5);

        int[] arr6 = new int[]{4, 1, 2, -1, -3};
        int[] result = mergeSort(arr6);
        printArr(result);

    }

    private int[] mergeSort(int[] arr) {
        //arr -> arr1, arr2
        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

//        printArr(arr1);
//        printArr(arr2);
        if (arr1.length == 0) {
            return arr2;
        }
        if (arr2.length == 0) {
            return arr1;
        }
//        return new int[]{0};
        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int p1 = 0;
        int p2 = 0;
        while (p1 < arr1.length || p2 < arr2.length) {
//            System.out.println("p1, p2= " + p1 + ", " + p2);
            if (p1 == arr1.length) {
                result[p1+p2] = arr2[p2];
                p2++;
                continue;
            }
            if (p2 == arr2.length) {
                result[p1+p2] = arr1[p1];
                p1++;
                continue;
            }

            if (arr1[p1] < arr2[p2]) {
                result[p1+p2] = arr1[p1];
                p1++;
            } else {
                result[p1+p2] = arr2[p2];
                p2++;
            }
//            System.out.println("result[p1+p2-1] = " + result[p1 + p2 - 1]);
        }

        return result;
    }

    private void insertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int temp = arr[i];

            int index = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < temp) {
                    index = j;
                    break;
                }
                arr[j+1] = arr[j];
            }
            arr[index + 1] = temp;
        }
    }

    private void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private void selectionSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = i; j < length; j++) {
                if (arr[j] < minValue) {
                    minIndex = j;
                    minValue = arr[j];
                }
                swap(arr, i, minIndex);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr3) {
        for (int i : arr3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
