import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class 백준_11286 {

    class Num implements Comparable<Num> {
        int n;

        public Num(int n){
            this.n = n;
        }

        @Override
        public int compareTo(Num o) {
            if(Math.abs(n) < Math.abs(o.n))
                return -1;
            else if(Math.abs(n) > Math.abs(o.n))
                return 1;
            else {
                if(n < o.n)
                    return -1;
                else
                    return 1;
            }
        }
    }
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //PriorityQueue.
        //우선순위 : 1. 절댓값, 2. 작은 수
        PriorityQueue<Num> queue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        while(n-- != 0){
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                if(queue.size() == 0) {
                    System.out.println(0);
                }else if(queue.size() == 1){
                    System.out.println(queue.poll().n);
                }else{
                    System.out.println(queue.poll().n);
                }
            }else{
                queue.add(new Num(num));
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
