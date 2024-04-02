import java.util.*;

public class programmers_2024KAKAO_도넛과막대그래프 {
    static boolean[] totalVisited;
    static List<Integer> visited;
    static int root;
    static List<Integer>[] next, prev;
    static int[] result;
    class Solution {
        public int[] solution(int[][] edges) {

            //특징
            //막대는 방문한 점을 재방문 하지 않음.
            //막대는 막대임이 밝혀지면, 추적해서 뒷부분까지 파악하기
            //도넛은 재방문 시점까지 도는 동안, 두 갈래길이 없음
            //8자는 재방문 시점까지 도는 중에, 두 갈래길이 있음.
            //가는 곳 2이상, 받는 곳 2이상이면 중앙점


            //0. edges 돌면서, arr에 저장 + max index 구하기
            //1. 방문하지 않은 곳 중 아무 점이나 선택한다
            //2. 이동하며 체크한다. 이미 방문한 곳인지 & 가는곳2이상, 받는곳 2이상인지
            //3. 추적해서 해당 방문한 곳들을 방문 표시한다.
            //4. 루트 발견한다. + 이후 1번은 루트의 남은 길 중 선택하고 반복.

            int maxIndex = Integer.MIN_VALUE;
            for(int[] edge: edges) {
                if (edge[0] > maxIndex) {
                    maxIndex = edge[0];
                }
                if (edge[1] > maxIndex) {
                    maxIndex = edge[1];
                }
            }

            next = new ArrayList[maxIndex + 1];
            prev = new ArrayList[maxIndex + 1];
            for (int i = 1; i < maxIndex + 1; i++) {
                next[i] = new ArrayList<>();
                prev[i] = new ArrayList<>();
            }
            for(int[] edge: edges) {
                next[edge[0]].add(edge[1]);
                prev[edge[1]].add(edge[0]);
            }

            System.out.println(maxIndex);

            totalVisited = new boolean[maxIndex + 1];

            result = new int[4];
            //index : 1에서 시작
            root = -1;
            visited = new ArrayList<>();
            move(1);

            for (int i: next[root]) {
                if (!totalVisited[i]) {
                    move(i);
                }
            }

            result[0] = root;
            return result;
        }

        private void move(int index) {
            visited.add(index);

            List<Integer> nexts = next[index];
            List<Integer> prevs = prev[index];

            if (nexts.isEmpty()) {
                //일자
                traceLine(index);
                putVisited(visited);
                result[2]++;
                return;
            }

            if (nexts.size() >= 2 && prevs.size() >= 2) {
                //8자 중앙점
                traceEight(index);
                putVisited(visited);
                result[3]++;
                return;
            }

            if (nexts.size() >= 2 && prevs.size() == 0) {
                root = index;
                move(nexts.get(0));
                return;
            }

            // if (prevs.size() >= 2) {
            //     for (int prv: prev[index]) {
            //         if (prev[prv].size() == 0) {
            //             root = prv;
            //         }
            //     }
            // }

            if (visited.contains(nexts.get(0))) {
                //도넛
                traceDonut(index);
                putVisited(visited);
                result[1]++;
                return;
            }

            move(nexts.get(0));
        }

        private void traceLine(int i) {
            // System.out.println("trace: " + i);

            visited = new ArrayList<>();
            int index = i;
            while (true) {
                // System.out.println("while index: " + index);

                visited.add(index);
                List<Integer> prevs = prev[index];

                if (prevs.size() == 0) {
                    break;
                }

                if (root == -1 && prevs.size() >= 2) {
                    //root포함
                    if (next[prevs.get(0)].size() == 1) {
                        index = prevs.get(0);
                        root = prevs.get(1);
                    } else {
                        index = prevs.get(1);
                        root = prevs.get(0);
                    }
                    continue;
                }
                index = prevs.get(0);
            }
            if (root == -1) {
                root = index;
            }
        }

        private void traceEight(int i) {
            // System.out.println("trace: " + i);

            visited = new ArrayList<>();
            visited.add(i);
            if (prev[i].size() >= 3) {
                for (int prv: prev[i]) {
                    if (prev[prv].size() == 0) {
                        root = prv;
                    }
                }
            }

            for (int nxt: next[i]) {
                int index = nxt;

                while (true) {
                    // System.out.println("while index: " + index);

                    visited.add(index);

                    if (root == -1 && prev[index].size() >= 2) {
                        for (int prv: prev[index]) {
                            if (prev[prv].size() == 0) {
                                root = prv;
                            }
                        }
                    }

                    if (visited.contains(next[index].get(0))) {
                        break;
                    }
                    index = next[index].get(0);
                }
            }
        }

        private void traceDonut(int i) {
            // System.out.println("trace: " + i);

            visited = new ArrayList<>();
            int index = i;
            while (true) {
                // System.out.println("while index: " + index);

                visited.add(index);

                if (root == -1 && prev[index].size() >= 2) {
                    for (int prv: prev[index]) {
                        if (prev[prv].size() == 0) {
                            root = prv;
                        }
                    }
                }

                if (visited.contains(next[index].get(0))) {
                    break;
                }
                index = next[index].get(0);
            }
        }

        private void putVisited(List<Integer> visited) {
            for (int i: visited) {
                totalVisited[i] = true;
            }
        }
    }
}
