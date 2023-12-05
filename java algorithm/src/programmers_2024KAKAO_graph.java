import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class programmers_2024KAKAO_graph {
    private static Map<Integer, List<Integer>> child;
    private static Map<Integer, List<Integer>> parent;
    private static int eightRoot;

    public static void main(String[] args) throws Exception {

        new Main().solution();
    }

    public void solution() {
//        int[][] edges = new int[][]{{4,1}, {1,2}, {2,3}, {3,5}, {4, 8}, {6, 7}, {7, 8}, {8, 9}}; //막대
//        int[][] edges = new int[][]{{4,1}, {1,2}, {2,3}, {3,5}, {4, 8}, {6, 7}, {7, 8}, {8, 9}, {10, 11}, {11, 12}, {12, 13}, {4, 13}}; //막대
//        int[][] edges = new int[][]{{4,1}, {1,2}, {2,3}, {3,1}, {4, 6}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 5}}; //도넛
//        int[][] edges = new int[][]{{4,1}, {1,2}, {2,3}, {3,2}, {2, 1}, {4, 5}, {5, 6}, {6, 7}, {7, 5}, {5, 8}, {8, 9}, {9, 5}}; //8자
        int[][] edges = new int[][]{{4, 1}, {1, 1}, {4, 2}, {2, 2}, {4, 10}, {4, 11}, {4, 12}, {12, 13}, {13, 14}, {14, 13}, {13, 12}}; //1크기 도넛2개 + 1크기 막대 2개 + 1크기 8자

        //1크기 도넛, 여러 모양 섞기

        int[] result = new int[4];
        child = new HashMap<>();
        parent = new HashMap<>();

        edgeToChildAndParent(edges, child, parent);

        int root = getRoot(child, parent);
        result[0] = root;

        System.out.println(child);
        System.out.println(parent);
        System.out.println(root);

        List<Integer> rootChild = child.get(root);

        for (Integer start : rootChild) {
            eightRoot = 0;
            Map<Integer, Integer> visitNodeCount = new HashMap<>();

            move(start, visitNodeCount);

            System.out.println("visitNodeCount = " + visitNodeCount);

            if (eightRoot > 0) {
                //8자
                result[3]++;
                continue;
            }
            if (isStickGraph(visitNodeCount)) {
                //막대
                result[2]++;
                continue;
            }
            if (isDonutGraph(visitNodeCount)) {
                //도넛
                result[1]++;
                continue;
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("result[i] = " + result[i]);
        }

    }

    private boolean isDonutGraph(Map<Integer, Integer> visitNodeCount) {
        return visitNodeCount.values().stream()
                .filter(v -> v >= 2)
                .count() == 1;
    }

    private boolean isStickGraph(Map<Integer, Integer> visitNodeCount) {
        return visitNodeCount.values().stream()
                .filter(v -> v >= 2)
                .count() == 0;
    }

    private void move(int start, Map<Integer, Integer> visitNodeCount) {
        visitNodeCount.put(start, visitNodeCount.getOrDefault(start, 0) + 1);
        List<Integer> childList = child.getOrDefault(start, new ArrayList<>());

        if (childList.size() == 2) {
            eightRoot = start;
        }

        if (childList.size() == 1) {
            if (visitNodeCount.get(start) > 1) {
                //도넛
                return;
            }
            move(childList.get(0), visitNodeCount);
        }
    }

    private int getRoot(Map<Integer, List<Integer>> child, Map<Integer, List<Integer>> parent) {
        List<Integer> rootList = new ArrayList<>();
        for (int node : child.keySet()) {
            int childCount = child.get(node).size();
            if (childCount > 2) {
                return node;
            }
            if (childCount == 2 && parent.getOrDefault(node, new ArrayList<>()).size() == 0) {
                return node;
            }
        }
        return -1;
    }

    private void edgeToChildAndParent(int[][] edges, Map<Integer, List<Integer>> child, Map<Integer, List<Integer>> parent) {
        for (int[] edge : edges) {
            List<Integer> childList = child.getOrDefault(edge[0], new ArrayList<>());
            childList.add(edge[1]);
            child.put(edge[0], childList);

            List<Integer> parentList = parent.getOrDefault(edge[1], new ArrayList<>());
            parentList.add(edge[0]);
            parent.put(edge[1], parentList);
        }
    }
}
