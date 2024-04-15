public class programmers_2018KAKAO_프렌즈4블록 {
    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;

            //27:36
            //1. 2*2에 해당하는 칸 표시 30*30*4
            //2. 제거 및 개수 세기 30*30
            //3. 떨어지기 30*30
            //4. 1~3 반복

            //빈칸 '0'
            char[][] map = getMap(board, m, n);
            int result = 0;

            while (true) {
                boolean[][] toRemove = checkRemove(map, m, n);
                int count = removeBlocks(map, toRemove, m, n);
                if (count == 0) {
                    break;
                }
                answer += count;
                fall(map, m, n);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }



            return answer;
        }

        public char[][] getMap(String[] board, int m, int n) {
            char[][] result = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = board[i].charAt(j);
                }
            }

            return result;
        }

        public boolean[][] checkRemove(char[][] map, int m, int n) {
            boolean[][] result = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < m-1 && j < n-1
                            && map[i][j] != '0'
                            && map[i][j] == map[i + 1][j]
                            && map[i][j] == map[i][j+1]
                            && map[i][j] == map[i+1][j+1]) {
                        result[i][j] = true;
                        result[i+1][j] = true;
                        result[i][j+1] = true;
                        result[i+1][j+1] = true;
                    }
                }
            }
            return result;
        }

        public int removeBlocks(char[][] map, boolean[][] toRemove, int m, int n) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j]) {
                        count++;
                        map[i][j] = '0';
                    }
                }
            }
            return count;
        }

        public void fall(char[][] map, int m, int n) {
            for (int j = 0; j < n; j++) {
                int space = 0;
                for (int i = m-1; i >=0; i--) {
                    if (map[i][j] == '0') {
                        space++;
                        continue;
                    }
                    char temp = map[i][j];
                    map[i][j] = '0';
                    map[i+space][j] = temp;
                }
            }
        }
    }
}
