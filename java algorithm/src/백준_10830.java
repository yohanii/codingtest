import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_10830 {

    static int n;
    static long b;
    static int nSquare;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        nSquare = (int) Math.pow(n, 2);

        //행렬 곱을 리스트에 저장
        //List<List<Integer>>
        //2^0, 2^1, 2^2, ... 해놓고 나중에 빼서 곱해주기
        //행렬곱 method - 길이 n^2의 리스트 2개 받아서 결과 반환
        List<Integer> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix.add(Integer.parseInt(st.nextToken()) % 1000);
            }
        }

        String binary = Long.toBinaryString(b);
//        System.out.println("binary = " + binary);

        List<List<Integer>> squareList = getSquareList(matrix, binary);
//        System.out.println("squareList = " + squareList);

        List<List<Integer>> multiplyMatrixList = getMultiplyMatrixList(binary, squareList);
//        System.out.println("multiplyMatrixList = " + multiplyMatrixList);

        List<Integer> resultMatrix = getResultMatrix(multiplyMatrixList);
//        System.out.println("resultMatrix = " + resultMatrix);

        printResultMatrix(resultMatrix);
    }

    private void printResultMatrix(List<Integer> resultMatrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(resultMatrix.get(n * i + j));
                if (j != n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    private List<Integer> getResultMatrix(List<List<Integer>> multiplyMatrixList) {
        List<Integer> result = new ArrayList<>(multiplyMatrixList.get(0));
        for (int i = 1; i < multiplyMatrixList.size(); i++) {
            result = calculate(result, multiplyMatrixList.get(i));
        }
        return result;
    }

    private List<List<Integer>> getSquareList(List<Integer> matrix, String binary) {
        List<List<Integer>> squareList = new ArrayList<>();
        squareList.add(matrix);
        int binaryLength = binary.length();

        for (int i = 0; i < binaryLength - 1; i++) {
            squareList.add(calculate(squareList.get(i), squareList.get(i)));
        }
        return squareList;
    }

    private List<List<Integer>> getMultiplyMatrixList(String binary, List<List<Integer>> squareList) {
        int binaryLength = binary.length();
        List<List<Integer>> multiplyMatrixList = new ArrayList<>();
        for (int i = 0; i < binaryLength; i++) {
            if (binary.charAt(i) == '1') {
                multiplyMatrixList.add(squareList.get(binaryLength - i - 1));
            }
        }
        return multiplyMatrixList;
    }

    private List<Integer> calculate(List<Integer> matrixA, List<Integer> matrixB) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < nSquare; index++) {
            int r = index / n;
            int c = index - (r * n);

            int value = 0;
            for (int i = 0; i < n; i++) {
                value += matrixA.get(n * r + i) * matrixB.get(n * i + c);
            }
            result.add(value % 1000);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
