public class programmers_2022KAKAO_양궁대회 {
    class Solution {
        public int[] solution(int n, int[] info) {

            //time: 1:07:51
            //dp로 풀고, 탐색해서 화살 알아내는 방식으로 풀었는데,
            //점수 같은 경우 더 낮은 점수 맞춘 거 선별하는 edge case 해결 못함.

            int length = info.length;
            int initialScore = getInitial(info);
            System.out.println(initialScore);

            int[][] dp = new int[length][n+1];
            for (int i = 0; i < length; i++) {
                dp[i][0] = initialScore;
            }
            for (int i = 0; i < n+1; i++) {
                dp[length-1][i] = initialScore;
            }

            for (int i = length-2; i >= 0; i--) {
                for (int j = 1; j <= n; j++) {
                    if (j-info[i]-1 < 0) {
                        dp[i][j] = dp[i+1][j];
                        continue;
                    }
                    if (info[i] > 0) {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j-info[i]-1] + 2 * (length - 1 - i));
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j-info[i]-1] + (length - 1 - i));
                }
            }

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }

            if (dp[0][n] <= 0) {
                return new int[]{-1};
            }

            //dp 탐색
            int[] result = new int[length];
            int left = n;
            for (int i = 0; i < length; i++) {
                if (left <= 0) {
                    break;
                }
                if (i == length -1) {
                    result[i] = left;
                    break;
                }
                if (dp[i][left] == dp[i + 1][left]) {
                    continue;
                }

                result[i] = info[i] + 1;
                left -= info[i] + 1;
            }



            return result;
        }

        private int getInitial(int[] info) {
            int result = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i] > 0) {
                    result += info.length - 1 - i;
                }
            }
            return -1 * result;
        }
    }
}
