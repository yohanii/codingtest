import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 백준_10775 {
    static int[] parent;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //방법
        //1. P개 받은 것을 오름차순으로 정렬하고, 작은 수부터 매칭해주는데, g가 더 작으면 다음것으로 넘어간다. g값갯수 n개 일때, O(nlogn)
        //2. g를 순차적으로 돌면서, 자기 값 이하의 최댓값에 매칭한다. 최댓값찾을때 시간걸릴듯 O(n^2) 시간초과
        //3. g값의 갯수를 map에 저장하고, 작은것부터 돌면서 가능한 갯수 체크하기 - g값갯수 n개 일때, O(nlogn)
        //4. 각 gate 마다 parent를 가진다.
        //비행기가 들어오면, parent를 통해 앞번호를 가리킨다.

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            boolean flag = union(g);
//            System.out.println(Arrays.toString(parent));
            if (!flag) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(P);
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    private boolean union(int i) {
        int p = find(i);
        if (p == 0) {
            return false;
        }

        parent[p] = find(parent[p-1]);
        find(i);
        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
