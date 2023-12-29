//import java.util.*;
//
//public class programmers_2023KAKAO_표현가능한이진트리 {
//
//    private static boolean isSatisfied(String fullBinary) {
//        int length = fullBinary.length();
////        System.out.println("length = " + length);
//        if (length == 1) {
////            System.out.println("Main.isSatisfied : End");
//            return true;
//        }
//        if (length % 2 == 0) {
////            System.out.println("Main.isSatisfied : EVEN");
//            return false;
//        }
//        int rootIndex = (length - 1) / 2;
//
////        System.out.println("rootIndex = " + rootIndex);
//        if (fullBinary.substring(rootIndex, rootIndex + 1).equals("1")) {
//            return isSatisfied(fullBinary.substring(0, rootIndex)) && isSatisfied(fullBinary.substring(rootIndex + 1));
//        }
//        return fullBinary.equals("0".repeat(length));
//    }
//
//    private static int getFullLength(int binaryLength) {
//        int result = 1;
//
//        while (result < binaryLength) {
//            result = 2 * result + 1;
//        }
//        return result;
//    }
//
//    private static String numToBinary(long number) {
//        String result = "";
//        long remain = number;
//
//        while (remain != 0) {
//            long l = remain % 2;
//            result = l + result;
//            remain /= 2;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) throws Exception {
//        new Main().solution();
//    }
//
//    public void solution() throws Exception {
//
//        long[] numbers = new long[]{7, 42, 5, 63, 111, 95};
////        long[] numbers = new long[]{42};
//
//        Solution.solution(numbers);
//    }
//
//    class Solution {
//        public static int[] solution(long[] numbers) {
//            int[] result = new int[numbers.length];
//            for (int i = 0; i < numbers.length; i++) {
//                long number = numbers[i];
//                String binary = numToBinary(number);
//                int binaryLength = binary.length();
//                int fullLength = getFullLength(binaryLength);
//                String fullBinary = "0".repeat((fullLength - binaryLength)) + binary;
//
////                System.out.println(fullBinary);
//
//                boolean status = isSatisfied(fullBinary);
////                System.out.println(status);
//                result[i] = status ? 1 : 0;
//            }
//
//            return result;
//        }
//    }
//}
//
