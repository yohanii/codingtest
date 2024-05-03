import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_9527 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //A <= x <= B 인 모든 수의 이진수 1의 개수 합
        //방법
        //1. 모든 수에 대해 2진수로 바꾸고, 1의 개수 세어준다. 더해준다. -> 제일 긴 수의 길이 m일 때, O(nm)
        //2. 다음 수로 넘어갈 때, 변화만 감지한다.
        //3. 1의 개수 f(2x) = f(x), f(2x+1) = f(x) + 1
        //10101 -> 3
        //10110 -> 3 - 1 + 1
        //10111 -> 3 + 1
        //11000 -> 4 - 3 + 1
        //1만나면 -1 후 앞자리, 0만나면 +1 후 끝


        //2번 방법 + 3번 방법
        //1. 첫 수를 string에 기억하고, 1의 갯수를 구한다.
        //2. countArr[x/2]이 0이 아닌지 확인. 0이 아니면 홀수, 짝수인지에 따라 바로 값 넣기
        //3. countArr[x/2]이 0일 경우, 따로 처리해준다.
        //4. B-A번 반복

        //4번 방법
        //A<= x <= B의 1의 개수는 (A/2 <= x <= B/2의 1의 개수) * 2 + (B-A+1)/2
        //ex) 100, 101, 110, 111, 1000, 1001
        //-> 10, 10, 11, 11, 100, 100 + 3
        //A, B 짝홀이 기준. A홀수이거나, B짝수인 경우 추가로 더해주기

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = countOne(a, b);
        System.out.println(result);
    }

    private long countOne(long start, long end) {
//        System.out.println("start, end = " + start + " " + end);
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return countOneByNum(end);
        }
        long newStart = start;
        long newEnd = end;

        long result =  0L;

        if (start % 2 == 1) {
            result += countOneByNum(start);
            newStart++;
        }
        if (end % 2 == 0) {
            result += countOneByNum(end);
            newEnd--;
        }
        result += 2 * countOne(newStart / 2, newEnd / 2) + (newEnd - newStart + 1) / 2;

        return result;
    }

    private long countOneByNum(long num) {
        String numStr = Long.toString(num, 2);
        long count = 0L;
        for (int i = 0; i < numStr.length(); i++){
            if (numStr.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
