import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class programmers_2024KAKAO_friend {

    public static void main(String[] args) throws Exception {

        new Main().solution();
    }

    public void solution() {
        String[] friends = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        int maxNextMonthCount = 0;

        Map<String, Person> persons = Arrays.stream(friends)
                .collect(Collectors.toMap(name -> name, name -> new Person(name)));

        giftToMap(gifts, persons);
//        System.out.println(persons);

        for (String name : friends) {
            int nextMonthCount = getNextMonthCount(name, friends, persons);
            if (nextMonthCount > maxNextMonthCount) {
                maxNextMonthCount = nextMonthCount;
            }
        }
        System.out.println(maxNextMonthCount);
    }

    private int getNextMonthCount(String name, String[] friends, Map<String, Person> persons) {
        Person person = persons.get(name);
        int nextMonthCount = 0;
        for (String friend : friends) {
            if (friend.equals(person.getName())) {
                continue;
            }

            int gap = person.getGive().getOrDefault(friend, 0) - person.getReceive().getOrDefault(friend, 0);
            if (gap > 0) {
                nextMonthCount++;
            } else if (gap == 0) {
                if (person.getGiftPoint() > persons.get(friend).getGiftPoint()) {
                    nextMonthCount++;
                }
            }
        }
        return nextMonthCount;
    }

    private void giftToMap(String[] gifts, Map<String, Person> persons) {
        for (String gift : gifts) {
            String[] fromTo = gift.split(" ");
            Map<String, Integer> give = persons.get(fromTo[0]).getGive();
            give.put(fromTo[1], give.getOrDefault(fromTo[1], 0) + 1);
            Map<String, Integer> receive = persons.get(fromTo[1]).getReceive();
            receive.put(fromTo[0], receive.getOrDefault(fromTo[0], 0) + 1);
        }
    }

    class Person {
        private String name;
        private Map<String, Integer> give;
        private Map<String, Integer> receive;

        public Person(String name) {
            this.name = name;
            give = new HashMap<>();
            receive = new HashMap<>();
        }

        public int getGiftPoint() {
            return getGiveCounts() - getReceiveCounts();
        }

        public int getGiveCounts() {
            return give.values().stream()
                    .reduce((x, y) -> x + y)
                    .orElse(0);
        }

        public int getReceiveCounts() {
            return receive.values().stream()
                    .reduce((x, y) -> x + y)
                    .orElse(0);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, Integer> getGive() {
            return give;
        }

        public void setGive(Map<String, Integer> give) {
            this.give = give;
        }

        public Map<String, Integer> getReceive() {
            return receive;
        }

        public void setReceive(Map<String, Integer> receive) {
            this.receive = receive;
        }

        @Override
        public String toString() {
            String result = "";
            result += "give : " + give + "\n";
            result += "receive : " + receive + "\n";
            return result;
        }
    }
}

