import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 백준_1107_오답버전 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //고장 나지 않은 버튼으로 가장 가까운 수를 만든다.
        //원래 수와 차이를 더해준다.
        //원래 수보다 원래값, 작은값, 큰값 총 5개 구해서 차이 절대값의 min을 출력하자
        String nStr = br.readLine();
        int m = Integer.parseInt(br.readLine());
        ArrayList<int[]> answer = new ArrayList<>();
        answer.add(new int[]{Math.abs(Integer.parseInt(nStr) - 100), 100});

        if(m==0){
            System.out.println(nStr.length());
            return;
        }
        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for(int i = 0; i < m; i++) {
            arr.remove((Integer) Integer.parseInt(st.nextToken()));
        }

        String smallStr1 = "";
        String smallStr2 = "";
        String bigStr1 = "";
        String bigStr2 = "";
        for(int i = 0; i < nStr.length(); i++) {
            int elem = Integer.valueOf(nStr.charAt(i)) - 48;
//            System.out.println("elem : " + elem);

            for(int j = arr.size()-1; j >=0; j--) {
                if(i == 0){
                    if(arr.get(j) == elem){
                        smallStr1 += String.valueOf(arr.get(j));
                        break;
                    }
                }else {
                    if(arr.get(j) <= elem){
                        smallStr1 += String.valueOf(arr.get(j));
                        break;
                    }
                }
            }

            for(int j = arr.size()-1; j >=0; j--) {
                if(i == 0){
                    if(arr.get(j) < elem){
                        smallStr2 += String.valueOf(arr.get(j));
                        break;
                    }
                }else {
                    smallStr2 += arr.get(arr.size() - 1);
                    break;
                }
            }

            for(int j = 0; j < arr.size(); j++) {
                if(i == 0){
                    if(arr.get(j) == elem){
                        bigStr1 += String.valueOf(arr.get(j));
                        break;
                    }
                }else {
                    if(arr.get(j) >= elem){
                        bigStr1 += String.valueOf(arr.get(j));
                        break;
                    }
                }
            }

            for(int j = 0; j < arr.size(); j++) {
                if(i == 0){
                    if(arr.get(j) > elem){
                        bigStr2 += String.valueOf(arr.get(j));
                        break;
                    }
                }else {
                    bigStr2 += arr.get(0);
                    break;
                }
            }
        }

//        System.out.println(arr);
//        System.out.println(smallStr1);
//        System.out.println(smallStr2);
//        System.out.println(bigStr1);
//        System.out.println(bigStr2);
//        System.out.println("");

        int smallGap1 = Integer.MAX_VALUE;
        int smallGap2 = Integer.MAX_VALUE;
        int bigGap1 = Integer.MAX_VALUE;
        int bigGap2 = Integer.MAX_VALUE;

        if(!smallStr1.equals("")) {
            smallGap1 = Integer.parseInt(nStr) - Integer.parseInt(smallStr1);
            int alpha = 0;
            if(smallStr1.length() < nStr.length())
                alpha = -1;

            answer.add(new int[]{smallGap1 + nStr.length() + alpha, Integer.parseInt(smallStr1)});
        }
        if(!smallStr2.equals("")) {
            smallGap2 = Integer.parseInt(nStr) - Integer.parseInt(smallStr2);

            int alpha = 0;
            if(smallStr2.length() < nStr.length())
                alpha = -1;
            answer.add(new int[]{smallGap2 + nStr.length() + alpha, Integer.parseInt(smallStr2)});
        }
        if(!bigStr1.equals("")) {
            bigGap1 = Integer.parseInt(bigStr1) - Integer.parseInt(nStr);
            int alpha = 0;
            if(bigStr1.length() > nStr.length())
                alpha = 1;
            answer.add(new int[]{bigGap1 + nStr.length() + alpha, Integer.parseInt(bigStr1)});
        }
        if(!bigStr2.equals("")) {
            bigGap2 = Integer.parseInt(bigStr2) - Integer.parseInt(nStr);
            int alpha = 0;
            if(bigStr2.length() > nStr.length())
                alpha = 1;
            answer.add(new int[]{bigGap2 + nStr.length() + alpha, Integer.parseInt(bigStr2)});
        }

        int min = Integer.MAX_VALUE;
        for(int[] i: answer){
//            System.out.println(i[0] + " " + i[1]);

            if(Math.abs(i[0]) < min){
                min = Math.abs(i[0]);
            }
        }
        System.out.println(min);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
