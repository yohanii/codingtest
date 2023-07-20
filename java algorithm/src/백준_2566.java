import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2566 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] inputArr = new int[9][9];
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 9; j++) {
                inputArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;
        int xPos = 0;
        int yPos = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(inputArr[i][j] > max) {
                    max = inputArr[i][j];
                    xPos = i;
                    yPos = j;
                }
            }
        }
        xPos++;
        yPos++;
        System.out.println(max);
        System.out.println(xPos + " " + yPos);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
