import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_5430 {

    public static StringBuilder sb = new StringBuilder();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //d 개수가 길이보다 길면 error
        //r마다 status 바꿔줌
        //한번돌면서 앞에서 지울 개수, 뒤에서 지울 개수 세주기
        //반영하기

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            boolean isForward = true;
            int frontDeleteCount = 0;
            int endDeleteCount = 0;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isForward = !isForward;
                } else {
                    if (isForward) {
                        frontDeleteCount++;
                        continue;
                    }
                    endDeleteCount++;
                }
            }
//            System.out.println("isForward = " + isForward);
//            System.out.println("frontDeleteCount = " + frontDeleteCount);
//            System.out.println("endDeleteCount = " + endDeleteCount);

            if (frontDeleteCount + endDeleteCount > n) {
//                System.out.println("error");
                sb.append("error\n");
                continue;
            }


            String[] nums = input.substring(1, input.length() - 1).split(",");
//            System.out.print("[");
            sb.append("[");
            if (isForward) {
                for (int i = frontDeleteCount; i < n - endDeleteCount; i++) {
//                    System.out.print(nums[i]);
                    sb.append(nums[i]);
                    if (i != n - endDeleteCount - 1) {
//                        System.out.print(",");
                        sb.append(",");
                    }
                }
            } else {
                for (int i = n - endDeleteCount - 1; i >= frontDeleteCount; i--) {
//                    System.out.print(nums[i]);
                    sb.append(nums[i]);
                    if (i != frontDeleteCount) {
//                        System.out.print(",");
                        sb.append(",");
                    }
                }
            }
//            System.out.println("]");
            sb.append("]\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
