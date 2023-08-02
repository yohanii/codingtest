import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_15686 {
    static ArrayList<Pos> house = new ArrayList<>();
    static ArrayList<Pos> chicken = new ArrayList<>();
    static int N, M;
    static boolean[] open;
    static int minVal;

    class Pos {
        private int xPos;
        private int yPos;

        Pos(int x, int y) {
            xPos = x;
            yPos = y;
        }

        public int[] getPos(){
            return new int[]{xPos, yPos};
        }

        public void setPos(int x, int y){
            xPos = x;
            yPos = y;
        }
    }

    private static int checkDis(ArrayList<Pos> from, ArrayList<Pos> to) {
        int sum = 0;
        int min;
        int temp;

        for(Pos start : from){
            min = Integer.MAX_VALUE;

            for(Pos end : to) {
                temp = 0;
                temp += Math.abs(start.getPos()[0] - end.getPos()[0]);
                temp += Math.abs(start.getPos()[1] - end.getPos()[1]);

                if(min > temp) min = temp;
            }
            sum += min;
        }

        return sum;
    }

    public static void dfs(int start, int cnt) {
        if (cnt == M) {
            ArrayList<Pos> temp = new ArrayList<>();
            for(int i = 0; i < chicken.size(); i++){
                if(open[i]) temp.add(chicken.get(i));
            }
            int dis = checkDis(house, temp);
            if(dis < minVal) {
                minVal = dis;
            }
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int temp;
            for(int j = 0; j < N; j++) {
                temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    house.add(new Pos(i, j));
                }else if(temp == 2){
                    chicken.add(new Pos(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];
        minVal = Integer.MAX_VALUE;

        dfs(0, 0);
        System.out.println(minVal);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
