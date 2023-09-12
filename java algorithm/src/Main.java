import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //d의 개수를 세고, 원소 개수보다 작으면 error
        //D나올때 마다, 지우게 될 index만 파악하고, 마지막에 해당 index아닌 것들만 한번돌면서 출력
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String fun = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            //D의 개수 세기
            int dCount = 0;
            for(int i = 0; i < fun.length(); i++){
                if(fun.charAt(i) == 'D')
                    dCount++;
            }

            if(dCount > len) {
                System.out.println("error");
                continue;
            }

            //arrStr 배열로 만들기
            String[] arr = arrStr.split(",");
            arr[0] = arr[0].substring(1);
            arr[arr.length-1] = arr[arr.length-1].substring(0, arr[arr.length-1].length()-1);
            for(String str : arr)
                System.out.println(str);

        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
