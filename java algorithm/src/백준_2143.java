import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.IntStream;

public class 백준_2143 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] aArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] bArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        //aArr, bArr에서 value : count map을 만든다.
        Map<Integer, Long> aMap = getValueCount(aArr);
        Map<Integer, Long> bMap = getValueCount(bArr);
//        System.out.println(aMap);
//        System.out.println(bMap);

        long sum = 0;
        for (Integer aKey : aMap.keySet()) {
//            System.out.println("aKey = " + aKey);
//            System.out.println("t - (int) aMap.get(aKey) = " + (t - aKey));
            long value = aMap.getOrDefault(aKey, 0L) * bMap.getOrDefault(t - aKey, 0L);
//            System.out.println("value = " + value);
            sum += value;
        }
        System.out.println(sum);

    }

    private Map<Integer, Long> getValueCount(int[] aArr) {
        int length = aArr.length;
        Map<Integer, Long> result = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int value = 0;
            for (int j = i; j < length; j++) {
                value += aArr[j];
                result.put(value, result.getOrDefault(value, 0L) + 1);
            }
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
