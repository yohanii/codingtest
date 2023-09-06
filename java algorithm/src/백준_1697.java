import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


public class 백준_1697 {

    static int bfs(int start, int end){
        int time = 0;
        int[] arr = new int[1000000];
        Arrays.fill(arr, -1);
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});
        arr[start] = 0;

        while(!queue.isEmpty()){
            int[] elem = queue.poll();
            int pos = elem[0];
            int current = elem[1];

            if(pos == end)
                return arr[end];

            if(pos > end){
                if(arr[pos-1] == -1){
                    queue.add(new int[]{pos - 1, current + 1});
                    arr[pos - 1] = current + 1;
                }
            }else{
                if(pos > 0 && arr[pos-1] == -1) {
                    queue.add(new int[]{pos - 1, current + 1});
                    arr[pos - 1] = current + 1;
                }

                if(arr[pos+1] == -1) {
                    queue.add(new int[]{pos + 1, current + 1});
                    arr[pos + 1] = current + 1;
                }
                if(arr[pos*2] == -1){
                    queue.add(new int[]{pos * 2, current + 1});
                    arr[pos * 2] = current + 1;
                }
            }

//            System.out.print("[");
//            for(int[] i : queue){
//                System.out.print("[" + i[0] + ", " + i[1] + "], ");
//            }
//            System.out.println("]");

        }

        return arr[end];
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //bfs
        //배열[위치] = 걸린 최소 시간
        //queue<위치, 현재 시간>
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, m));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
