import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1181 {

    public boolean compare(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if (aLen < bLen) {
            return false;
        } else if (aLen > bLen) {
            return true;
        }

        int index = 0;
        while (true) {
            int aNum = (int) a.charAt(index);
            int bNum = (int) b.charAt(index);

            if (aNum < bNum) {
                return false;
            } else if (aNum > bNum) {
                return true;
            } else if (aLen == index + 1) {
                return false;
            }
            index++;
        }
    }
    public String[] bubble_sort(String[] arr) {
        String[] result = arr;

        for(int i = result.length; i>1; i--) {
            for(int j=0; j<i-1; j++) {
                if(compare(result[j], result[j+1])) {
                    String temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }

        return result;
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        String[] resultArr = bubble_sort(arr);

        for(int i = 0; i < n; i++) {
            System.out.println(resultArr[i]);
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
