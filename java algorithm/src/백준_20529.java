import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_20529 {

    public int score(int[] arr){
        int len = arr.length;
        ArrayList<Integer> scoreList = new ArrayList<>();

        for(int i = 0; i < len-2; i++){
            for(int j = i + 1; j < len-1; j++){
                for(int t = j + 1; t < len; t++){
                    int score = 0;

                    //xor
                    int temp1 = arr[i] ^ arr[j];
                    int temp2 = arr[j] ^ arr[t];
                    int temp3 = arr[t] ^ arr[i];

                    //1개수 세기
                    for (int k = 0; k < 4; k++) {
                        score += (temp1 / Math.pow(2, k)) % 2;
                        score += (temp2 / Math.pow(2, k)) % 2;
                        score += (temp3 / Math.pow(2, k)) % 2;
                    }

                    if(score == 0)
                        return 0;
                    scoreList.add(score);
                }
            }
        }

        Collections.sort(scoreList);
        return scoreList.get(0);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            int num = Integer.parseInt(br.readLine());

            if(num > 32){
                System.out.println(0);
                br.readLine();
                continue;
            }

            int[] arr = new int[num];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < num; i++){
                String str = st.nextToken();
                int mbti = 0;
                if(str.charAt(0) == 'E'){
                    mbti += 0B1000;
                }
                if(str.charAt(1) == 'S'){
                    mbti += 0B0100;
                }
                if(str.charAt(2) == 'T'){
                    mbti += 0B0010;
                }
                if(str.charAt(3) == 'J'){
                    mbti += 0B0001;
                }
                arr[i] = mbti;
            }

            System.out.println(score(arr));
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
