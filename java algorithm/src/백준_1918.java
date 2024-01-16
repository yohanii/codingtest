import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class 백준_1918 {

    static List<Character> operator = List.of('+', '-', '*', '/');

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(divide(br.readLine()));
    }

    //연산자, 피산자 분리하고, 괄호는 divide 씌우기
    public String divide(String str) {
        if (str.isEmpty()) {
            return "";
        }

        List<String> victims = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        int index = 0;
        int stack = 0;
        int startIndex = -1;

        while (index < str.length()) {
            char c = str.charAt(index);
            if (c == '(') {
                if (stack == 0) {
                    startIndex = index;
                }
                stack++;
                index++;
                continue;
            }

            if (c == ')') {
                stack--;
                if (stack == 0) {
                    String substring = str.substring(startIndex + 1, index);
//                    System.out.println("substring = " + substring);
                    victims.add(divide(substring));
                }
                index++;
                continue;
            }

            index++;

            if (stack > 0) {
                continue;
            }

            if (operator.contains(c)) {
                operators.add(String.valueOf(c));
                continue;
            }
            victims.add(String.valueOf(c));
        }
//        System.out.println("victims = " + victims);
//        System.out.println("operators = " + operators);

        return parse(victims, operators);
    }

    //연산자 list, 피산자 list로 후위 표기식 반환
    public String parse(List<String> victims, List<String> operators) {
        //곱, 나누기 앞에서 부터
        int index = 0;
        while (index < operators.size()) {
            String op = operators.get(index);

            if (op.charAt(0) == '*' || op.charAt(0) == '/') {
                List<String> newOperators = new ArrayList<>(operators);
                List<String> newVictims = new ArrayList<>(victims);
                newOperators.remove(index);
                String val1 = victims.get(index);
                String val2 = victims.get(index + 1);
                newVictims.remove(index + 1);
                newVictims.remove(index);

                newVictims.add(index, val1 + val2 + op);
                victims = newVictims;
                operators = newOperators;
                continue;
            }
            index++;
        }
//        System.out.println("victims = " + victims);
//        System.out.println("operators = " + operators);

        //더하기, 빼기 앞에서 부터
        for (int i = 0; i < operators.size(); i++) {
            String value = victims.get(0) + victims.get(1) + operators.get(i);
            victims.remove(1);
            victims.remove(0);
            victims.add(0, value);
        }

        return victims.get(0);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
