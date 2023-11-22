import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class programmers_2023KAKAO_택배배달과수거하기 {

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        //전략 끝에서 부터 처리한다

        //stack이용
        int cap = 4;
        int n = 5;
        int[] deliveries = new int[]{1, 0, 3, 1, 2};
        int[] pickups = new int[]{0, 3, 0, 4, 0};

        System.out.println(solve(cap, n, deliveries, pickups));

    }

    public long solve(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<List<Integer>> deliveryStack = new Stack<>();
        Stack<List<Integer>> pickupStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                deliveryStack.add(List.of(i + 1, deliveries[i]));
            }
            if (pickups[i] != 0) {
                pickupStack.add(List.of(i + 1, pickups[i]));
            }
        }

//        System.out.print("deliveryStack : ");
//        for (List<Integer> integers : deliveryStack) {
//            System.out.print(integers);
//        }
//        System.out.println();
//
//        System.out.print("pickupStack : ");
//        for (List<Integer> integers : pickupStack) {
//            System.out.print(integers);
//        }
//        System.out.println();

        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            List<Integer> deliveryPop = new ArrayList<>(List.of(0, 0));
            List<Integer> pickupPop = new ArrayList<>(List.of(0, 0));

            if (!deliveryStack.isEmpty()) {
                deliveryPop = deliveryStack.pop();
                updateStack(cap, deliveryStack, deliveryPop);
            }
            if (!pickupStack.isEmpty()) {
                pickupPop = pickupStack.pop();
                updateStack(cap, pickupStack, pickupPop);
            }

            long distance = Math.max(deliveryPop.get(0), pickupPop.get(0));
//            System.out.println("distance = " + distance);
            answer += 2 * distance;

//            System.out.print("deliveryStack : ");
//            for (List<Integer> integers : deliveryStack) {
//                System.out.print(integers);
//            }
//            System.out.println();
//
//            System.out.print("pickupStack : ");
//            for (List<Integer> integers : pickupStack) {
//                System.out.print(integers);
//            }
//            System.out.println();
//            System.out.println(answer);
        }

        return answer;
    }

    private void updateStack(int cap, Stack<List<Integer>> stack, List<Integer> pop) {
        int amount = pop.get(1);

        while (amount < cap) {
            if (stack.isEmpty()) {
                return;
            }
            cap -= amount;
            pop = stack.pop();
            amount = pop.get(1);
        }
        if (amount > cap) {
            stack.add(List.of(pop.get(0), amount - cap));
        }
    }
}

