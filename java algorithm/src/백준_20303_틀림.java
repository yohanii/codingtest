import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class 백준_20303_틀림 {
    static int n, m, k;
    static List<Group> groups;
    static int maxValue;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] candy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] groupIndex = new int[n + 1];
        Arrays.fill(groupIndex, -1);
        groups = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int personA = Integer.parseInt(st.nextToken());
            int personB = Integer.parseInt(st.nextToken());

            if (groupIndex[personA] >= 0) {
                Group findGroup = groups.get(groupIndex[personA]);
                findGroup.persons.add(personB);
                findGroup.candySum += candy[personB - 1];
                groupIndex[personB] = groupIndex[personA];
                continue;
            }
            if (groupIndex[personB] >= 0) {
                Group findGroup = groups.get(groupIndex[personB]);
                findGroup.persons.add(personA);
                findGroup.candySum += candy[personA - 1];
                groupIndex[personA] = groupIndex[personB];
                continue;
            }
            if (groupIndex[personA] < 0 && groupIndex[personB] < 0) {
                Group newGroup = new Group();
                newGroup.persons.add(personA);
                newGroup.persons.add(personB);
                newGroup.candySum += candy[personA - 1] + candy[personB - 1];
                groups.add(newGroup);
                int index = groups.indexOf(newGroup);
                groupIndex[personA] = index;
                groupIndex[personB] = index;
            }
        }
        groups.forEach(Group::calculateWeight);
//        System.out.println(groups);

//        maxValue = 0;
//        for (int i = 0; i < groups.size(); i++) {
//            dfs(i, 0, 0);
//        }
//        System.out.println(maxValue);

        int[][] dp = new int[groups.size()][k];
        //dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight] + value)
        for (int i = groups.get(0).weight; i < k; i++) {
            dp[0][i] = groups.get(0).candySum;
        }
        for (int i = 1; i < groups.size(); i++) {
            for (int j = 1; j < k; j++) {
                if (j-groups.get(i).weight < 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-groups.get(i).weight] + groups.get(i).candySum);
            }
        }

        System.out.println(dp[groups.size() - 1][k-1]);
    }

//    private void dfs(int index, int wSum, int value) {
////        System.out.println(index + ", " + wSum + ", " + value);
//        if (wSum + groups.get(index).weight < k && value + groups.get(index).candySum > maxValue) {
//            maxValue = value + groups.get(index).candySum;
//        }
//
//        for (int i = index + 1; i < groups.size(); i++) {
//            if (wSum + groups.get(index).weight + groups.get(i).weight< k) {
//                dfs(i, wSum + groups.get(index).weight, value + groups.get(index).candySum);
//            }
//        }
//    }


    class Group {
        List<Integer> persons;
        int candySum;
        int weight;

        public Group() {
            persons = new ArrayList<>();
            candySum = 0;
        }

        public void calculateWeight() {
            weight = persons.size();
        }

        @Override
        public String toString() {
            return "Group{" +
                    "weight=" + weight +
                    ", candySum=" + candySum +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
