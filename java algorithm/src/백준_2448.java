import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_2448 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int n = 1;
        while (Math.pow(2, n) <= input/3) {
            n++;
        }

        List<String> madeString = makeString(n);
        printStar(madeString);
    }

    private List<String> makeString(int n) {
        if (n == 1) {
            return List.of("  *  ", " * * ", "*****");
        }

        List<String> prev = makeString(n - 1);
        List<String> upPart = new ArrayList<>(prev).stream()
                .map(line -> " ".repeat((int) (3 * Math.pow(2, n-2))) + line + " ".repeat((int) (3 * Math.pow(2, n-2))))
                .collect(Collectors.toList());
        List<String> downPart = new ArrayList<>();
        for (int i = 0; i < prev.size(); i++) {
            downPart.add(prev.get(i) + " " + prev.get(i));
        }

        List<String> listSum = new ArrayList<>();
        listSum.addAll(upPart);
        listSum.addAll(downPart);
        return listSum;
    }

    private void printStar(List<String> madeString) {
        madeString.stream()
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
