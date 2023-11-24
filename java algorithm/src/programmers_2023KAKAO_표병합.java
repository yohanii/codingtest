import java.util.ArrayList;
import java.util.List;

public class programmers_2023KAKAO_표병합 {

    private static List<String> result = new ArrayList<>();
    private static List<List<Cell>> graph;

    public static void main(String[] args) throws Exception {

        new Main().solution();
    }

    public void solution() {
        String[] commands = new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 1 3 2 3", "MERGE 1 3 2 2", "UPDATE d b", "UNMERGE 1 3"};

        graph = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            List<Cell> graph_row = new ArrayList<>();
            for (int j = 0; j < 51; j++) {
                graph_row.add(new Cell(i, j));
            }
            graph.add(graph_row);
        }

        for (String command : commands) {
            parseCommand(command);
        }

        for (List<Cell> cells : graph) {
            System.out.println(cells);
        }
        System.out.println("result : " + result);
        result.toArray(new String[result.size()]);
    }

    private void parseCommand(String command) {
        String[] commandSplit = command.split(" ");

        switch (commandSplit[0]) {
            case "UPDATE":
                if (commandSplit.length == 4) {
                    updateValue(Integer.valueOf(commandSplit[1]), Integer.valueOf(commandSplit[2]), commandSplit[3]);
                    break;
                }
                updateAllValues(commandSplit[1], commandSplit[2]);
                break;
            case "MERGE":
                merge(Integer.valueOf(commandSplit[1]), Integer.valueOf(commandSplit[2]), Integer.valueOf(commandSplit[3]), Integer.valueOf(commandSplit[4]));
                break;
            case "UNMERGE":
                unmerge(Integer.valueOf(commandSplit[1]), Integer.valueOf(commandSplit[2]));
                break;
            case "PRINT":
                printValue(Integer.valueOf(commandSplit[1]), Integer.valueOf(commandSplit[2]));
                break;
            default:
                throw new IllegalArgumentException("잘못된 input입니다.");
        }
    }

    private void printValue(int r, int c) {
        result.add(graph.get(r).get(c).getValue());
    }

    private void unmerge(int r, int c) {
        Cell cell = graph.get(r).get(c);
        for (List<Integer> pos : cell.getGroup()) {
            Cell groupCell = graph.get(pos.get(0)).get(pos.get(1));
            groupCell.setGroup(List.of(List.of(pos.get(0), pos.get(1))));
            if (pos.get(0) == r && pos.get(1) == c) {
                continue;
            }
            updateValueOfCell(groupCell, "EMPTY");
        }

    }

    private void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return;
        }

        Cell cell1 = graph.get(r1).get(c1);
        Cell cell2 = graph.get(r2).get(c2);

        String value = !cell1.getValue().equals("EMPTY") ? cell1.getValue() : cell2.getValue();

        addPosToGroup(cell1, cell2);

        updateValueOfCell(cell1, value);
        updateValueOfCell(cell2, value);
    }

    private void addPosToGroup(Cell cell1, Cell cell2) {
        List<List<Integer>> group1 = cell1.getGroup();
        List<List<Integer>> group2 = cell2.getGroup();
        List<List<Integer>> newGroup = new ArrayList<>(group1);
        newGroup.addAll(group2);

        for (int i = group1.size() - 1; i >= 0; i--) {
            List<Integer> pos = group1.get(i);
            graph.get(pos.get(0)).get(pos.get(1)).setGroup(newGroup);
        }
        for (int i = group2.size() - 1; i >= 0; i--) {
            List<Integer> pos = group2.get(i);
            graph.get(pos.get(0)).get(pos.get(1)).setGroup(newGroup);
        }
    }

    private void updateAllValues(String value1, String value2) {
        for (List<Cell> cells : graph) {
            for (Cell cell : cells) {
                if (cell.getValue().equals(value1)) {
                    updateValueOfCell(cell, value2);
                }
            }
        }
    }

    private void updateValue(int r, int c, String value) {
        updateValueOfCell(graph.get(r).get(c), value);
    }

    private void updateValueOfCell(Cell cell, String value) {
        for (List<Integer> pos : cell.getGroup()) {
            graph.get(pos.get(0)).get(pos.get(1)).setValue(value);
        }
    }

    class Cell {
        private String value;
        private List<List<Integer>> group;

        public Cell(int i, int j) {
            value = "EMPTY";
            if (i > 0 && j > 0) {
                group = new ArrayList<>(List.of(List.of(i, j)));
            }
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<List<Integer>> getGroup() {
            return group;
        }

        public void setGroup(List<List<Integer>> group) {
            this.group = group;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}

