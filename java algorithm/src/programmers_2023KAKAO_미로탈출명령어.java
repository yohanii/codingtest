import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class programmers_2023KAKAO_미로탈출명령어 {

    private static List<Direction> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        new Main().solution();
    }

    public void solution() {
        int n = 3;
        int m = 3;
        int x = 3;
        int y = 2;
        int r = 1;
        int c = 2;
        int k = 4;

        int distance = Math.abs(x - r) + Math.abs(y - c);
        if (checkImpossible(k, distance)) {
            System.out.println("impossible");
            return;
        }

        int repeat = (k - distance) / 2;

        PriorityQueue<Direction> directions = getDirections(x, y, r, c);

        System.out.println(directions);

        moveKTimes(n, m, x, y, k, repeat, directions);
        String resultStr = "";
        for (Direction direction : result) {
            if (direction.equals(Direction.DOWN)) {
                resultStr += "d";
            }
            if (direction.equals(Direction.UP)) {
                resultStr += "u";
            }
            if (direction.equals(Direction.LEFT)) {
                resultStr += "l";
            }
            if (direction.equals(Direction.RIGHT)) {
                resultStr += "r";
            }
        }
        System.out.println(resultStr);
//        return resultStr;
    }

    private void moveKTimes(int n, int m, int x, int y, int k, int repeat, PriorityQueue<Direction> directions) {
        int curPosX = x;
        int curPosY = y;
        int moveCount = 0;

        while (moveCount < k) {
            Direction bestRepeat = getBestRepeat(curPosX, curPosY, n, m);
            Direction bestDirection;
            if ((directions.isEmpty() || bestRepeat.compareTo(directions.peek()) < 0) && repeat > 0) {
                //queue에 반대 방향 추가
                bestDirection = bestRepeat;
                if (bestDirection.equals(Direction.DOWN)) {
                    directions.add(Direction.UP);
                }
                if (bestDirection.equals(Direction.UP)) {
                    directions.add(Direction.DOWN);
                }
                if (bestDirection.equals(Direction.LEFT)) {
                    directions.add(Direction.RIGHT);
                }
                if (bestDirection.equals(Direction.RIGHT)) {
                    directions.add(Direction.LEFT);
                }
                repeat--;
            } else {
                bestDirection = directions.poll();
            }

            result.add(bestDirection);
            if (bestDirection.equals(Direction.DOWN)) {
                curPosX++;
            }
            if (bestDirection.equals(Direction.UP)) {
                curPosX--;
            }
            if (bestDirection.equals(Direction.LEFT)) {
                curPosY--;
            }
            if (bestDirection.equals(Direction.RIGHT)) {
                curPosY++;
            }
            moveCount++;

            System.out.println("---------------------------");
            System.out.println("curPosX = " + curPosX);
            System.out.println("curPosY = " + curPosY);
            System.out.println("repeat = " + repeat);
            System.out.println("moveCount = " + moveCount);
            System.out.println("directions = " + directions);
            System.out.println("result = " + result);
        }
    }

    private Direction getBestRepeat(int curPosX, int curPosY, int n, int m) {
        if (n - curPosX > 0) {
            return Direction.DOWN;
        }
        if (curPosY > 1) {
            return Direction.LEFT;
        }
        if (m - curPosY > 0) {
            return Direction.RIGHT;
        }
        return Direction.UP;
    }

    private PriorityQueue<Direction> getDirections(int x, int y, int r, int c) {
        PriorityQueue<Direction> directions = new PriorityQueue<>();
        int xDistance = r - x;
        int yDistance = c - y;

        if (xDistance > 0) {
            for (int i = 0; i < xDistance; i++) {
                directions.add(Direction.DOWN);
            }
        } else {
            for (int i = 0; i < -xDistance; i++) {
                directions.add(Direction.UP);
            }
        }

        if (yDistance > 0) {
            for (int i = 0; i < yDistance; i++) {
                directions.add(Direction.RIGHT);
            }
        } else {
            for (int i = 0; i < -yDistance; i++) {
                directions.add(Direction.LEFT);
            }
        }
        return directions;
    }

    private boolean checkImpossible(int k, int distance) {
        return distance > k || (k - distance) % 2 == 1;
    }

    enum Direction {
        DOWN, LEFT, RIGHT, UP
    }
}

