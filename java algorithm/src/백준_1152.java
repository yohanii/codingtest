import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 백준_1152 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = 0;

        String[] strList = str.split(" ");
        for(int i=0;i<strList.length;i++) {
            if(strList[i].length() == 0) {
                num++;
            }
        }
        System.out.println(strList.length - num);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
