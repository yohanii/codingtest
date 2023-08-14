import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


public class 백준_5639 {
    class Node {
        private int value;
        private Node left, right;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue(){
            return this.value;
        }

        public void insert(int value) {
            if(value < this.value){
                if(this.left == null){
                    this.left = new Node(value);
                    return;
                }
                this.left.insert(value);
            } else {
                if(this.right == null){
                    this.right = new Node(value);
                    return;
                }
                this.right.insert(value);
            }
        }
    }

    public void printOrder(Node node) {
        if(node == null)
            return;

        printOrder(node.left);
        printOrder(node.right);
        System.out.println(node.getValue());
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rootValue = Integer.parseInt(br.readLine());
        Node root = new Node(rootValue);

        while(true){
            String input = br.readLine();
            if(input == null || input.equals(""))
                break;

            root.insert(Integer.parseInt(input));
        }

        printOrder(root);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
