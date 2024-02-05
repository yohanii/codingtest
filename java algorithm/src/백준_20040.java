import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class 백준_20040 {

    static int n, m;
    static boolean isSuccess;

    static Node[] nodes;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //가장 작은 수 parent로 하고,
        //새로운 선 그을 때, parent 같으면 종료


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isSuccess = false;

        int[][] lines = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }


        nodes = new Node[n];
        Node root = new Node(lines[0][0], -1);
        Node node = new Node(lines[0][1], lines[0][0]);
        nodes[lines[0][0]] = root;
        nodes[lines[0][1]] = node;
//        System.out.println("nodes[lines[0][0]].parent = " + nodes[lines[0][0]].parent);
//        System.out.println("nodes[lines[0][1]].parent = " + nodes[lines[0][1]].parent);
//        System.out.println("nodes[lines[0][0]].find() = " + nodes[lines[0][0]].find());
//        System.out.println("nodes[lines[0][1]].find() = " + nodes[lines[0][1]].find());

        int count = 1;
        while (count < m) {
            int start = lines[count][0];
            int end = lines[count][1];

            if (nodes[start] != null && nodes[end] != null) {
//                System.out.println("case1");
                if (nodes[start].find() == nodes[end].find()) {
                    break;
                }
                nodes[nodes[end].find()].parent = nodes[start].find();
                nodes[end].find();
                count++;
                continue;
            }

            if (nodes[start] == null && nodes[end] == null) {
//                System.out.println("case2");
                nodes[start] = new Node(start, -1);
                nodes[end] = new Node(end, start);
                count++;
                continue;
            }

            if (nodes[start] == null) {
//                System.out.println("case3");
                nodes[start] = new Node(start, nodes[end].find());
            }
            if (nodes[end] == null) {
//                System.out.println("case4");
                nodes[end] = new Node(end, nodes[start].find());
            }

            count++;
        }

        if (count == m) {
            System.out.println(0);
            return;
        }
        System.out.println(count + 1);

    }

    class Node {
        int index;
        int parent;

        public Node(int index, int parent) {
            this.index = index;
            this.parent = parent;
        }

        public int find() {
            if (parent == -1) {
                return index;
            }
            parent = nodes[parent].find();
            return parent;
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
