import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_1766 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //방법
        //1. 자기보다 먼저 풀어야하는 문제 갯수 기록 - before = new int[]
        //2. child list 기록 child = new ArrayList[]
        //3. 한번돌면서 before 0인 노드들 우선순위큐에 넣기
        //4. 가장 작은값 poll해서, child값 -1 해주고, 만약 before값 0이되는 child는 큐에 넣기
        //5. 반복

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] before = new int[n+1];
        before[0] = -1;
        List<Integer>[] child = new ArrayList[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());

            before[childNode]++;
            if (child[parentNode] == null) {
                child[parentNode] = new ArrayList<>();
            }
            child[parentNode].add(childNode);
        }

//        System.out.println(Arrays.toString(before));
//        System.out.println(Arrays.toString(child));


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < n+1; i++) {
            if (before[i] == 0) {
                queue.add(i);
            }
        }
//        System.out.println("queue = " + queue);

        while (!queue.isEmpty()) {
            int elem = queue.poll();

            System.out.print(elem + " ");

            if (child[elem] == null) {
                continue;
            }
            for (Integer i : child[elem]) {
                before[i]--;
                if (before[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
