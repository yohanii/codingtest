public class programmers_2018KAKAO_n진수게임 {
    class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";

            //9:39
            //1. 0부터 1씩 높여가면서, 해당 수를 n진법으로 바꾸고, String 에 더해준다.
            //2. String의 길이가 p+m*(t-1)보다 크거나 같으면 중지
            //3. p자리, p+m 자리, ..., p+m*t자리를 뽑아낸다.
            String nums = "";
            int num = 0;
            while (nums.length() < p + m * (t-1)) {
                nums += Integer.toString(num, n);
                num++;
            }
            System.out.println(nums);
            nums = nums.toUpperCase();

            for (int i = 0; i < t; i++) {
                answer += nums.charAt(i*m + p - 1);
            }

            return answer;
        }
    }
}
